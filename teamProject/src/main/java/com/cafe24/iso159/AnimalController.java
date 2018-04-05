package com.cafe24.iso159;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.cxf.io.CachedOutputStream;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.iso159.animal.service.Animal;
import com.cafe24.iso159.animal.service.AnimalAndFile;
import com.cafe24.iso159.animal.service.AnimalCommand;
import com.cafe24.iso159.animal.service.AnimalService;
import com.cafe24.iso159.shelter.service.BusinessLicense;
import com.cafe24.iso159.shelter.service.ShelterService;

@Controller
public class AnimalController {
	
	@Autowired
	private AnimalService animalservice;
	@Autowired
	private ShelterService shelterService;
	private static final Logger logger = LoggerFactory.getLogger(AnimalController.class);
	
	//동물등록 페이지로 이동
	@RequestMapping(value="/animal/animalAdd", method=RequestMethod.GET)
	public String animalAdd(HttpSession session,Model model
							,@RequestParam(value="animalBreed", defaultValue="") String animalBreed
							,@RequestParam(value="animalArea", defaultValue="") String animalArea
							,@RequestParam(value="animalIdCode", defaultValue="") String animalIdCode
							,@RequestParam(value="animalWeight", defaultValue="") String animalWeight
							,@RequestParam(value="animalAge", defaultValue="") String animalAge
							,@RequestParam(value="imagePath", defaultValue="") String imagePath) {
		logger.debug("animalAdd(HttpSession session,Model model, Animal animal) 메서드 호출");
		logger.debug("animalAdd(HttpSession session,Model model, Animal animal) 메서드 animalBreed is {}", animalBreed);
		logger.debug("animalAdd(HttpSession session,Model model, Animal animal) 메서드 animalArea is {}", animalArea);
		logger.debug("animalAdd(HttpSession session,Model model, Animal animal) 메서드 animalIdCode is {}", animalIdCode);
		logger.debug("animalAdd(HttpSession session,Model model, Animal animal) 메서드 animalWeight is {}", animalWeight);
		logger.debug("animalAdd(HttpSession session,Model model, Animal animal) 메서드 animalAge is {}", animalAge);
		logger.debug("animalAdd(HttpSession session,Model model, Animal animal) 메서드 imagePath is {}", imagePath);
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		model.addAttribute("animalBreed", animalBreed);
		model.addAttribute("animalArea", animalArea);
		model.addAttribute("animalIdCode", animalIdCode);
		model.addAttribute("animalWeight", animalWeight);
		model.addAttribute("animalAge", animalAge);
		model.addAttribute("imagePath", imagePath);
		logger.debug("animalAdd(HttpSession session,Model model, Animal animal) 메서드 끝");
		return "animal/animalAdd";
	}
	
	//동물등록
	@RequestMapping(value="/animal/animalAdd", method=RequestMethod.POST)
	public String animalAdd(HttpSession session, AnimalAndFile animalAndFile
							, @RequestParam(value="file") MultipartFile file) {
		logger.debug("animalAdd(...) 메서드 호출");
		//세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		logger.debug("animalAdd(...) 메서드 animalAndFile is {}", animalAndFile);
		logger.debug("animalAdd(...) 메서드 file is {}",file);
		//세션에서 로그인 아이디를 가져와서 mShelterId에 셋팅
		String mShelterId = (String)session.getAttribute("loginId");
		logger.debug("mShelterId is {}", mShelterId);
		//세션에서 로그인 blCode를 가져와서 blCode에 셋팅		
		String blCode = (String)session.getAttribute("loginBlCode");
		logger.debug("blcode is {}", blCode);
		String path = null;
		if(file != null) {
			path = session.getServletContext().getRealPath("/");
			path += "resources/animalUpload/";
		}
		animalservice.addAnimal(animalAndFile, mShelterId, blCode, path, file);
		return "redirect:/animal/animalList";
	}
	//동물리스트
	@RequestMapping(value="/animal/animalList", method=RequestMethod.GET)
	public String animal(HttpSession session, Model model) {
		logger.debug("animal()메서드 호출");
		String blCode = (String)session.getAttribute("loginBlCode");
		List<AnimalCommand> AnimalList = animalservice.listAnimal(blCode);
		model.addAttribute("AnimalList", AnimalList);
		return "animal/animalList";
	}
	//동물 조건검색
	@RequestMapping(value="/animal/animalCategory", method=RequestMethod.POST)
	public String animalCategory(Model model
								,@RequestParam(value="AnimalCategory",required=false) String AnimalCategory
								,@RequestParam(value="selectName",required=false) String selectName) {
		
		logger.debug("animalCategory()메서드  is {}", AnimalCategory);
		logger.debug("animalCategory()메서드 is {}", selectName);

		List<AnimalCommand> selectCategory = animalservice.categoryAnimal(AnimalCategory, selectName);
		logger.debug("selectCategory is {}", selectCategory);
		model.addAttribute("AnimalList", selectCategory);
		return "animal/animalList";
	}
	//동물리스트 상세페이지요청
	@RequestMapping(value="/animal/animalDetail", method=RequestMethod.GET)
	public String animalDetail(HttpSession session, Model model, @RequestParam(value="animalCode",required=true)String animalCode) {
			
		AnimalCommand animalDetail =animalservice.detailAnimal(animalCode);
		model.addAttribute("animalDetail", animalDetail);
		return "animal/animalDetail";
	}
	//동물리스트 삭제
	@RequestMapping(value="/animal/animalDelete", method=RequestMethod.GET)
	public String animalRemove(HttpSession session
								, @RequestParam(value="animalCode")String animalCode
								, @RequestParam(value="animalImagePath", defaultValue="") String animalImagePath) {
		logger.debug("animalRemove(...) 메서드 호출");
		logger.debug("animalRemove(...) 메서드 animalCode is {}", animalCode);
		logger.debug("animalRemove(...) 메서드 animalImagePath is {}", animalImagePath);
		String path=null;
		if(!animalImagePath.equals("")) {
			path = session.getServletContext().getRealPath("/");
			path += "resources/animalUpload/";
		}
		logger.debug("animalRemove(...) 메서드 path is {}", path);
		animalservice.removeAnimal(animalCode, animalImagePath, path);
		return "redirect:/animal/animalList";
	}
	//동물리스트 수정 GET방식
	@RequestMapping(value="/animal/animalUpdate", method=RequestMethod.GET)
	public String animalModify(Model model, @RequestParam(value="animalCode",required=true)String animalCode, HttpSession session) {
		//세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트 
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		Animal animal = animalservice.getAnimalOne(animalCode);
		// 매개변수 animal 값 확인
		logger.debug("animalModify()메서드 animalCode is {}", animalCode);
		model.addAttribute("animal", animal);
		logger.debug("animalModify()메서드 animal is {}", animal);
		return "animal/animalUpdate";
	}
	//동물리스트 수정 POST방식
	@RequestMapping(value="/animal/animalUpdate", method = RequestMethod.POST)
	public String animalModify(AnimalAndFile animalAndFile, HttpSession session
							, @RequestParam(value="animalCode") String animalCode
							, @RequestParam(value="file") MultipartFile file
							, @RequestParam(value="filePath") String filePath) {
		logger.debug("animalModify(...)메서드 호출");
		//세션에 로그인 값을 확인하고 로그인 정보가 없으면 리다이렉트
		if(session.getAttribute("loginId")==null) {
			return "redirect:/member/login";
		}
		logger.debug("animalModify(...)메서드 animalAndFile is {}", animalAndFile);
		logger.debug("animalModify(...)메서드 file is {}", file);
		logger.debug("animalModify(...)메서드 filePath is {}", filePath);
		String path = session.getServletContext().getRealPath("/");
		path += "resources/animalUpload/";
		animalservice.modifyAnimal(animalAndFile,file,path,filePath,animalCode);
		return "redirect:/animal/animalList";
	}
	
	// 보호소 등록코드별 보호 유기동물리스트 api
	@RequestMapping(value = "/animal/yugiAnimalList", method = RequestMethod.POST)
	public void shelterAnimalList(HttpServletResponse response, HttpSession session
								, @RequestParam(value="animalStatusKind") String animalStatusKind) throws IOException {
		logger.debug("shelterAnimalList(...) 메서드 호출");
		logger.debug("shelterAnimalList(...) 메서드 animalStatusKind is {}", animalStatusKind);
		String blCode = (String)session.getAttribute("loginBlCode");
		if(blCode == null) {
			return;
		}
		BusinessLicense businessLicense = shelterService.getOneBusinessLicense(blCode);
		String careRegNo = businessLicense.getBlShelterRegNumber();
		logger.debug("shelterAnimalList(...) 메서드 businessLicense is {}", businessLicense);
		logger.debug("shelterAnimalList(...) 메서드 careRegNo is {}", careRegNo);
		if(careRegNo==null) {
			return;
		}
		response.setContentType("text/html; charset=utf-8");
		String addr = "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?ServiceKey=";
		String serviceKey = "7s3CsUFyR%2F1QMd5tktqM%2BnUw9gAEPUtI0GIsuGWxEUOJHwZP9NVTLOoMOKmVtZH0SmDPuv5Gg78SA94B%2BLMQsQ%3D%3D";
		String parameter = "";
		
		URL url = null;
		CachedOutputStream bos = null;
		InputStream in = null;
		
		
		parameter = parameter + "&" + "upr_cd=6450000";
		parameter = parameter + "&" + "org_cd=4640000";
		parameter = parameter + "&" + "care_reg_no=" + careRegNo;
		parameter = parameter + "&" + "upkind=417000";
		parameter = parameter + "&" + "_type=json";
		
		addr = addr + serviceKey + parameter;
		
		url = new URL(addr);
		in = url.openStream();
		bos = new CachedOutputStream();
		IOUtils.copy(in, bos);
		in.close();
		bos.close();
		
		String data = bos.getOut().toString();
		
		PrintWriter out = response.getWriter();
		out.println(data);
		logger.debug("data is {}", data);
		logger.debug("addr is {}", addr);
		JSONObject json = new JSONObject();
		json.put("data", data);
		
		logger.debug("shelterAnimalList(...) 메서드 끝");
	}
	
	// 유기동물품종 api
	@RequestMapping(value = "/animal/AnimalBreed", method = RequestMethod.POST)
	public void shelterAnimalBreed(HttpServletResponse response, HttpSession session){
		logger.debug("shelterAnimalBreed(...) 메서드 호출");
		String blCode = (String)session.getAttribute("loginBlCode");
		if(blCode == null) {
			return;
		}
		response.setContentType("text/html; charset=utf-8");
		// 호출할 데이터가 있는 url을 addr변수에 입력
		String addr = "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/kind?ServiceKey=";
		// 서비스키 입력
		String serviceKey = "7s3CsUFyR%2F1QMd5tktqM%2BnUw9gAEPUtI0GIsuGWxEUOJHwZP9NVTLOoMOKmVtZH0SmDPuv5Gg78SA94B%2BLMQsQ%3D%3D";
		// 요청메시지를 입력받을 parameter변수 선언 및 공백으로 초기화
		String parameter = "";
		
		URL url = null;
		CachedOutputStream bos = null;
		InputStream in = null;
		
		// 요청메세지 추가
		parameter = parameter + "&" + "up_kind_cd=417000";
		parameter = parameter + "&" + "_type=json";
		
		// 주소에 url + 서비스키 + 조건을 연결
		addr = addr + serviceKey + parameter;
		String data = null;
		PrintWriter out = null;
		
		// 예외처리
		try {
			// 데이터를 가져올 url 할당
			url = new URL(addr);
			// url주소와 연결한후 이 연결로부터 입력받을수있는 InputStream을 리턴받음
			in = url.openStream();
			// 출력을 받기위해 CachedOutputStream 객체 생성
			bos = new CachedOutputStream();
			// in에서 bos로 데이터 복사
			IOUtils.copy(in, bos);
			// 복사된 데이터를 String 형태로 data변수에 입력
			data = bos.getOut().toString();
			// 텍스트형식의 출력 스트림을 얻은후
			out = response.getWriter();
			// 얻어낸 스트림에 데이터 입력
			out.println(data);
			logger.debug("data is {}", data);
			logger.debug("addr is {}", addr);
			JSONObject json = new JSONObject();
			// json형태로 데이터를 넣음
			json.put("data", data);
			
			logger.debug("shelterAnimalBreed(...) 메서드 끝");
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {in.close();} catch (IOException e) {e.printStackTrace();}
			try {bos.close();} catch (IOException e) {e.printStackTrace();}
		}					
	}
}
