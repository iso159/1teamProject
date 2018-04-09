package com.cafe24.iso159.jindan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.iso159.animal.service.Animal;
import com.cafe24.iso159.animal.service.AnimalDao;
import com.cafe24.iso159.service.common.OverallStatus;
import com.cafe24.iso159.shelter.service.BusinessLicense;
import com.cafe24.iso159.shelter.service.ShelterDao;

@Service
public class JindanService {
	@Autowired
	private JindanDAO jindanDAO;
	@Autowired
	private AnimalDao animalDao;
	private static final Logger logger = LoggerFactory.getLogger(JindanService.class);
	
	// 진단서 등록시 DTO별 값 세팅 및 진단 정보별 DAO를 호출하는 메서드
	public void addJindan(AllJindanInfo allJindanInfo, String animalCode, String blCode, String mShelterId) {
		logger.debug("addJindan(AllJindanInfo allJindanInfo, String animalCode, String blCode, String mShelterId) 메서드 호출");
		logger.debug("addJindan(AllJindanInfo allJindanInfo, String animalCode, String blCode, String mShelterId) 메서드 allJindanInfo is {}", allJindanInfo);
		logger.debug("addJindan(AllJindanInfo allJindanInfo, String animalCode, String blCode, String mShelterId) 메서드 animalCode is {}", animalCode);
		logger.debug("addJindan(AllJindanInfo allJindanInfo, String animalCode, String blCode, String mShelterId) 메서드 blCode is {}", blCode);
		logger.debug("addJindan(AllJindanInfo allJindanInfo, String animalCode, String blCode, String mShelterId) 메서드 mShelterId is {}", mShelterId);
		// 진단서 정보별 기본키 변수 선언 및 초기화
		String jindanCode = "jindan_code_";
		String jindanEarsCode = "jindan_ears_code_";
		String jindanEyesCode = "jindan_eyes_code_";
		String jindanGeneralCode = "jindan_general_code_";
		String jindanNoseCode = "jindan_nose_code_";
		String jindanSkinCode = "jindan_skin_code_";
		
		String jindanExpostPoint = null;
		String osCodeMedical = allJindanInfo.getOsCodeMedical();
		// 진단서 종류별 포인트 설정
		if(osCodeMedical.equals("os_jindan_2_1_2")) {
			jindanExpostPoint = "300";
		}else {
			jindanExpostPoint = "0";
		}
		// 진단서 기본키의 숫자 최대값을 구하는 DAO 메서드 호출
		String maxNum = jindanDAO.selectJindanCodeMaxNum();
		logger.debug("addJindan(AllJindanInfo allJindanInfo, String animalCode, String blCode, String mShelterId) 메서드 maxNum is {}", maxNum);
		int maxNumPlus = 1;
		
		// 진단서 정보별 기본키 코드 생성
		if(maxNum == null) {
			jindanCode += maxNumPlus;
			jindanEarsCode += maxNumPlus;
			jindanEyesCode += maxNumPlus;
			jindanGeneralCode += maxNumPlus;
			jindanNoseCode += maxNumPlus;
			jindanSkinCode += maxNumPlus;
		}else {
			maxNumPlus += Integer.parseInt(maxNum);
			jindanCode += maxNumPlus;
			jindanEarsCode += maxNumPlus;
			jindanEyesCode += maxNumPlus;
			jindanGeneralCode += maxNumPlus;
			jindanNoseCode += maxNumPlus;
			jindanSkinCode += maxNumPlus;
		}
		
		// Jindan DTO 세팅 및 입력 쿼리 접근 DAO 호출 시작
		Jindan jindan = new Jindan();
		jindan.setJindanCode(jindanCode);
		jindan.setAnimalCode(animalCode);
		jindan.setBlCode(blCode);
		jindan.setmShelterId(mShelterId);
		jindan.setOsCodeMedical(osCodeMedical);
		jindan.setJindanExpostPoint(jindanExpostPoint);
		jindan.setJindanOverallOpinion(allJindanInfo.getJindanOverallOpinion());
		logger.debug("addJindan(AllJindanInfo allJindanInfo, String animalCode, String blCode, String mShelterId) 메서드 jindan is {}", jindan);
		jindanDAO.insertJindan(jindan);
		// Jindan DTO 세팅 및 입력 쿼리 접근 DAO 호출 끝
		
		// JindanGeneral DTO 세팅 및 입력 쿼리 접근 DAO 호출 시작
		JindanGeneral jindanGeneral = new JindanGeneral();
		jindanGeneral.setJindanGeneralCode(jindanGeneralCode);
		jindanGeneral.setJindanCode(jindanCode);
		jindanGeneral.setOsBody(allJindanInfo.getOsBody());
		jindanGeneral.setOsManner(allJindanInfo.getOsManner());
		jindanGeneral.setOsRheum(allJindanInfo.getOsRheum());
		jindanGeneral.setOsGeneralOddYumu(allJindanInfo.getOsGeneralOddYumu());
		logger.debug("addJindan(AllJindanInfo allJindanInfo, String animalCode, String blCode, String mShelterId) 메서드 jindanGeneral is {}", jindanGeneral);
		jindanDAO.insertJindanGeneral(jindanGeneral);
		// JindanGeneral DTO 세팅 및 입력 쿼리 접근 DAO 호출 끝
		
		// JindanSkin DTO 세팅 및 입력 쿼리 접근 DAO 호출 시작
		JindanSkin jindanSkin = new JindanSkin();
		jindanSkin.setJindanSkinCode(jindanSkinCode);
		jindanSkin.setJindanCode(jindanCode);
		jindanSkin.setOsCoat(allJindanInfo.getOsCoat());
		jindanSkin.setOsSkin(allJindanInfo.getOsSkin());
		jindanSkin.setOsSkinOddYumu(allJindanInfo.getOsSkinOddYumu());
		logger.debug("addJindan(AllJindanInfo allJindanInfo, String animalCode, String blCode, String mShelterId) 메서드 jindanSkin is {}", jindanSkin);
		jindanDAO.insertJindanSkin(jindanSkin);
		// JindanSkin DTO 세팅 및 입력 쿼리 접근 DAO 호출 끝
		
		// JindanEars DTO 세팅 및 입력 쿼리 접근 DAO 호출 시작
		JindanEars jindanEars = new JindanEars();
		jindanEars.setJindanEarsCode(jindanEarsCode);
		jindanEars.setJindanCode(jindanCode);
		jindanEars.setOsEarsSecrete(allJindanInfo.getOsEarsSecrete());
		jindanEars.setOsHearing(allJindanInfo.getOsHearing());
		jindanEars.setOsMite(allJindanInfo.getOsMite());
		jindanEars.setOsEarsOddYumu(allJindanInfo.getOsEarsOddYumu());
		logger.debug("addJindan(AllJindanInfo allJindanInfo, String animalCode, String blCode, String mShelterId) 메서드 jindanEars is {}", jindanEars);
		jindanDAO.insertJindanEars(jindanEars);
		// JindanEars DTO 세팅 및 입력 쿼리 접근 DAO 호출 끝
		
		// JindanEyes DTO 세팅 및 입력 쿼리 접근 DAO 호출 시작
		JindanEyes jindanEyes = new JindanEyes();
		jindanEyes.setJindanEyesCode(jindanEyesCode);
		jindanEyes.setJindanCode(jindanCode);
		jindanEyes.setOsConjunctiva(allJindanInfo.getOsConjunctiva());
		jindanEyes.setOsCornea(allJindanInfo.getOsCornea());
		jindanEyes.setOsCrystalline(allJindanInfo.getOsCrystalline());
		jindanEyes.setOsEyesOddYumu(allJindanInfo.getOsEyesOddYumu());
		logger.debug("addJindan(AllJindanInfo allJindanInfo, String animalCode, String blCode, String mShelterId) 메서드 jindanEyes is {}", jindanEyes);
		jindanDAO.insertJindanEyes(jindanEyes);
		// JindanEyes DTO 세팅 및 입력 쿼리 접근 DAO 호출 끝
		
		// JindanNose DTO 세팅 및 입력 쿼리 접근 DAO 호출 시작
		JindanNose jindanNose = new JindanNose();
		jindanNose.setJindanNoseCode(jindanNoseCode);
		jindanNose.setJindanCode(jindanCode);
		jindanNose.setOsNoseSecrete(allJindanInfo.getOsNoseSecrete());
		jindanNose.setOsNoseOddYumu(allJindanInfo.getOsNoseOddYumu());
		logger.debug("addJindan(AllJindanInfo allJindanInfo, String animalCode, String blCode, String mShelterId) 메서드 jindanNose is {}", jindanNose);
		jindanDAO.insertJindanNose(jindanNose);
		// JindanNose DTO 세팅 및 입력 쿼리 접근 DAO 호출 끝
		
		// 동물 상태코드를 체험가능동물로 수정
		final String osCodeAnimal ="os_animal_3_1_2";
		Animal animal = new Animal();
		animal.setAnimalCode(animalCode);
		animal.setOsCodeAnimal(osCodeAnimal);
		logger.debug("addJindan(AllJindanInfo allJindanInfo, String animalCode, String blCode, String mShelterId) 메서드 animal is {}", animal);
		animalDao.updateAnimalOsCode(animal);
		
		logger.debug("addJindan(AllJindanInfo allJindanInfo, String animalCode, String blCode, String mShelterId) 메서드 끝");
	}
	
	// 진단 목록 종류를 조회하기위해 selectJindanOs DAO 메서드 호출후 리턴값을 map에 매핑하는 서비스 메서드
	public Map<String,Object> getJindanOs(){
		logger.debug("getJindanOs() 메서드 호출");
		// 여러 객체를 담기위해 map 사용
		Map<String,Object> map = new HashMap<String, Object>();
		
		String osLarge = "일반상태";
		List<OverallStatus> general = jindanDAO.selectJindanOs(osLarge);
		logger.debug("getJindanOs() 메서드 general is {}", general);	
		map.put("general", general);
		
		osLarge = "피부상태";
		List<OverallStatus> skin = jindanDAO.selectJindanOs(osLarge);
		logger.debug("getJindanOs() 메서드 skin is {}", skin);
		map.put("skin",skin);
		
		osLarge = "눈";
		List<OverallStatus> eyes = jindanDAO.selectJindanOs(osLarge);
		logger.debug("getJindanOs() 메서드 eyes is {}", eyes);
		map.put("eyes",eyes);
		
		osLarge = "귀";
		List<OverallStatus> ears = jindanDAO.selectJindanOs(osLarge);
		logger.debug("getJindanOs() 메서드 ears is {}", ears);
		map.put("ears",ears);
		
		osLarge = "코";
		List<OverallStatus> nose = jindanDAO.selectJindanOs(osLarge);
		logger.debug("getJindanOs() 메서드 nose is {}", nose);
		map.put("nose",nose);
		
		osLarge = "상태 이상 유무";
		List<OverallStatus> isang = jindanDAO.selectJindanOs(osLarge);
		logger.debug("getJindanOs() 메서드 isang is {}", isang);
		map.put("isang",isang);
		
		osLarge = "진단서종류";
		List<OverallStatus> jindanKind = jindanDAO.selectJindanOs(osLarge);
		logger.debug("getJindanOs() 메서드 jindanKind is {}", jindanKind);
		map.put("jindanKind",jindanKind);
		
		logger.debug("getJindanOs() 메서드 끝");
		return map;
	}
	
	//진료 신청을 위한 보호소 전체리스트 조회
	public List<BusinessLicense> getBusinessLicenseList(){
		logger.debug("getBusinessLicenseList() 메서드 호출");
		List<BusinessLicense> list = jindanDAO.selectBusinessLicenseList();
		logger.debug("getBusinessLicenseList() 메서드 list is {}", list);
		return list;
	}
}