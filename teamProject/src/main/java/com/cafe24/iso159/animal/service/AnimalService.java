package com.cafe24.iso159.animal.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class AnimalService {

	@Autowired
	private AnimalDao animaldao;

	private static final Logger logger = LoggerFactory.getLogger(AnimalService.class);
	//동물등록
	public void addAnimal(AnimalAndFile animalAndFile, String mShelterId, String blCode, String path, MultipartFile file){
		logger.debug("addAnimal()메서드 animalAndFile is {}",animalAndFile);
		// 동물정보 변수에 입력
		String animalIdCode = animalAndFile.getAnimalIdCode();
		String animalAge = animalAndFile.getAnimalAge();
		String animalWeight = animalAndFile.getAnimalWeight();
		String animalArea = animalAndFile.getAnimalArea();
		String animalBreed = animalAndFile.getAnimalBreed();
		String osCodeAnimal = animalAndFile.getOsCodeAnimal();
		String animalImagePath = animalAndFile.getAnimalImagePath();
		String osCodeKind = "os_animal_kinds_11_1_1";
		
		// 변수를 객체의 필드에 세팅
		Animal animal = new Animal();		
		animal.setAnimalIdCode(animalIdCode);
		animal.setAnimalAge(animalAge);
		animal.setAnimalWeight(animalWeight);
		animal.setAnimalArea(animalArea);
		animal.setAnimalBreed(animalBreed);
		animal.setOsCodeAnimal(osCodeAnimal);
		animal.setAnimalImagePath(animalImagePath);
		animal.setOsCodeKind(osCodeKind);
		
		//마지막코드 숫자값을 저장
		String lastNum = animaldao.selectLastCode();
		logger.debug("lastCode is {}", lastNum);
		
		//마지막 animal_code 코드
		String animalCode = "animal_code_";
		int lastAnimalNum=1;
		
		if(lastNum == null) {
			animalCode += lastAnimalNum;  
		}else {
			lastAnimalNum += Integer.parseInt(lastNum);
			animalCode += lastAnimalNum;
		}
		logger.debug("AnimalCode is {}", animalCode);
		//animalCode셋팅
		animal.setAnimalCode(animalCode);
		//m_shelterId셋팅
		animal.setmShelterId(mShelterId);
		//bl_code 셋팅
		animal.setBlCode(blCode);
		// 파일이 비어있지않다면 if 블록 실행
		if(!file.isEmpty()) {
			// 랜덤아이디 생성
			UUID uuid = UUID.randomUUID();
			// 저장파일명을 toString 메서드로 문자열형태로 입력
			String storeFileName = uuid.toString();
			String fullFileName = file.getOriginalFilename();
			logger.debug("addAnimal(...) 메서드 fullFileName is {}",fullFileName);
			// 마지막 .의 위치 값을 입력
			int pos = fullFileName.indexOf(".");
			logger.debug("addAnimal(...) 메서드 pos is {}",pos);
			// 원본 파일명의 마지막 . 위치 앞의 원본 파일명을 변수에 입력
			String originalFileName = fullFileName.substring(0, pos);
			logger.debug("addAnimal(...) 메서드 originalFileName is {}",originalFileName);
			// 원본 파일명의 마지막 . 위치 뒤의 확장자를 ext 변수에 입력
			String ext = fullFileName.substring(pos+1);
			logger.debug("addAnimal(...) 메서드 ext is {}",ext);
			// file 사이즈를 저장
			long size = file.getSize();
			logger.debug("addAnimal(...) 메서드 size is {}",size);
			
			File temp = new File(path);
			if(!temp.exists()) {
				// 디렉토리가 없을경우 디렉토리 생성
				temp.mkdirs();
				logger.debug("addAnimal(...) 메서드 디렉토리 생성 성공");
			}
			
			animal.setAnimalImagePath(storeFileName+"."+ext);
			File temp2 = new File(path+storeFileName+"."+ext);
			logger.debug("addAnimal(...) 메서드 temp2 is {}",temp2);
			
			try {
				// 원본 파일을 빈 파일에 복사
				file.transferTo(temp2);
			} catch (IllegalStateException e) {
				// IllegalStateException 예외 발생시 처리
				e.printStackTrace();
				if(temp.delete()) {
					logger.debug("addAnimal(...) 메서드 {} 파일 삭제 성공",temp);
				}else {
					logger.debug("addAnimal(...) 메서드 {} 파일 삭제 실패",temp);
				}
			} catch (IOException e) {
				// IOException 예외 발생시 처리
				e.printStackTrace();
				if(temp.delete()) {
					logger.debug("addAnimal(...) 메서드 {} 파일 삭제 성공",temp);
				}else {
					logger.debug("addAnimal(...) 메서드 {} 파일 삭제 실패",temp);
				}
			}
		}
		animaldao.insertAnimal(animal);
		
	}
	//동물리스트
	public Map<String,Object> listAnimal(String blCode, String osCodeAnimal, 
										  int currentPage, int pagePerRow) {
		logger.debug("listAnimal(...)메서드 호출");
		logger.debug("listAnimal(...)메서드 호출 blCode is {}", blCode);
		logger.debug("listAnimal(...)메서드 호출 osCodeAnimal is {}", osCodeAnimal);
		logger.debug("listAnimal(...)메서드 호출 currentPage is {}", currentPage);
		logger.debug("listAnimal(...)메서드 호출 pagePerRow is {}", pagePerRow);
		// 시작 행 입력
		int startRow = currentPage*pagePerRow;
		// 쿼리에 입력할 맵 생성
		Map<String,Object> map = new HashMap<String, Object>();
		// 매개변수 값 매핑
		map.put("blCode", blCode);
		map.put("osCodeAnimal", osCodeAnimal);
		map.put("osName", osCodeAnimal);
		map.put("startRow", startRow);
		map.put("pagePerRow", pagePerRow);
		
		// 동물 정보 리스트 입력
		List<AnimalCommand> AnimalList = animaldao.selectAnimalList(map);
		
		// 조회결과의 개수 입력
		int totalCount = animaldao.selectAnimalCountByOsName(map);
		double pageCount = (double)totalCount/(double)pagePerRow;
		logger.debug("listAnimal(...)메서드 pageCount is {}", pageCount);
		// 마지막 페이지 구하기
		int maxPage = (int)(Math.ceil(pageCount));
		logger.debug("listAnimal(...)메서드 AnimalList is {}", AnimalList);
		logger.debug("listAnimal(...)메서드 totalCount is {}", totalCount);
		logger.debug("listAnimal(...)메서드 maxPage is {}", maxPage);
		
		// 리턴할 맵 생성
		Map<String,Object> returnMap = new HashMap<String, Object>();
		returnMap.put("AnimalList", AnimalList);
		returnMap.put("maxPage", maxPage);				
		logger.debug("listAnimal(String blCode)메서드 끝");
		return returnMap;
	}
	
	//동물삭제
	public void removeAnimal(String animalCode, String animalImagePath,String path) {
		logger.debug("deleteAnimal()메서드 호출");
		logger.debug("deleteAnimal()메서드 animalId is {}", animalCode);
		logger.debug("deleteAnimal()메서드 animalImagePath is {}", animalImagePath);
		logger.debug("deleteAnimal()메서드 path is {}", path);
		if(path!=null) {
			File temp = new File(path+animalImagePath);
			if(temp.exists()) {
				if(temp.delete()) {
					logger.debug("파일 삭제 성공");
				}else {
					logger.debug("파일 삭제 실패");
				}
			}
		}
		animaldao.deleteAnimal(animalCode);
	}
	//동물리스트 수정
	public void modifyAnimal(AnimalAndFile animalAndFile, MultipartFile file, String path, String filePath,String animalCode) {
		logger.debug("modifyAnimal(...)메서드 animal 호출");
		logger.debug("modifyAnimal(...)메서드 animal is {}", animalAndFile);
		logger.debug("modifyAnimal(...)메서드 file is {}", file);
		logger.debug("modifyAnimal(...)메서드 path is {}", path);
		logger.debug("modifyAnimal(...)메서드 filePath is {}", filePath);
		
		// 동물정보 변수에 입력
		String animalAge = animalAndFile.getAnimalAge();
		String animalWeight = animalAndFile.getAnimalWeight();
		String animalArea = animalAndFile.getAnimalArea();
		String animalBreed = animalAndFile.getAnimalBreed();
		String animalImagePath = animalAndFile.getAnimalImagePath();
		
		// 변수를 객체의 필드에 세팅
		Animal animal = new Animal();
		animal.setAnimalCode(animalCode);
		animal.setAnimalAge(animalAge);
		animal.setAnimalWeight(animalWeight);
		animal.setAnimalArea(animalArea);
		animal.setAnimalBreed(animalBreed);
		animal.setAnimalImagePath(animalImagePath);
		
		if(!file.isEmpty()) {
			// 랜덤아이디 생성
			UUID uuid = UUID.randomUUID();
			// 저장파일명을 toString 메서드로 문자열형태로 입력
			String storeFileName = uuid.toString();
			String fullFileName = file.getOriginalFilename();
			logger.debug("modifyAnimal(...) 메서드 fullFileName is {}",fullFileName);
			// 마지막 .의 위치 값을 입력
			int pos = fullFileName.indexOf(".");
			logger.debug("modifyAnimal(...) 메서드 pos is {}",pos);
			// 원본 파일명의 마지막 . 위치 앞의 원본 파일명을 변수에 입력
			String originalFileName = fullFileName.substring(0, pos);
			logger.debug("modifyAnimal(...) 메서드 originalFileName is {}",originalFileName);
			// 원본 파일명의 마지막 . 위치 뒤의 확장자를 ext 변수에 입력
			String ext = fullFileName.substring(pos+1);
			logger.debug("modifyAnimal(...) 메서드 ext is {}",ext);
			// file 사이즈를 저장
			long size = file.getSize();
			logger.debug("modifyAnimal(...) 메서드 size is {}",size);
			
			File temp = new File(path);
			if(!temp.exists()) {
				// 디렉토리가 없을경우 디렉토리 생성
				temp.mkdirs();
				logger.debug("modifyAnimal(...) 메서드 디렉토리 생성 성공");
			}
			temp = new File(path + filePath);
			logger.debug("modifyAnimal(...) 메서드 temp is {}", temp);
			if(temp.exists()) {
				if(temp.delete()) {
					logger.debug("파일 삭제 성공");
				}else {
					logger.debug("파일 삭제 실패");
				}
			}
			
			animal.setAnimalImagePath(storeFileName+"."+ext);
			File temp2 = new File(path+storeFileName+"."+ext);
			logger.debug("modifyAnimal(...) 메서드 temp2 is {}",temp2);
			
			try {
				// 원본 파일을 빈 파일에 복사
				file.transferTo(temp2);
			} catch (IllegalStateException e) {
				// IllegalStateException 예외 발생시 처리
				e.printStackTrace();
				if(temp.delete()) {
					logger.debug("modifyAnimal(...) 메서드 {} 파일 삭제 성공",temp);
				}else {
					logger.debug("modifyAnimal(...) 메서드 {} 파일 삭제 실패",temp);
				}
			} catch (IOException e) {
				// IOException 예외 발생시 처리
				e.printStackTrace();
				if(temp.delete()) {
					logger.debug("modifyAnimal(...) 메서드 {} 파일 삭제 성공",temp);
				}else {
					logger.debug("modifyAnimal(...) 메서드 {} 파일 삭제 실패",temp);
				}
			}
		}
		animaldao.updateAnimal(animal);
	}
	//동물리스트 한개 조회
	public Animal getAnimalOne(String animalCode) {
		logger.debug("getAnimalOne()메서드 animalCode is {}", animalCode);
		Animal oneAnimal = animaldao.selectAnimalOne(animalCode);
		//리턴받은 한개 동물리스트 출력
		logger.debug("getAnimalOne()메서드 oneAnimal is {}", oneAnimal);
		return oneAnimal;
	}
	//동물상세 조회
	public AnimalCommand detailAnimal(String animalCode) {
		logger.debug("animalDetail()메서드 animalCode is {}", animalCode);
		AnimalCommand animalDetail = animaldao.animalDetail(animalCode);
		logger.debug("animalDetail()메서드 animalDetail is {}", animalDetail);
		return animalDetail;
	}
	//동물 조건검색
	public List<AnimalCommand> categoryAnimal(String AnimalCategory, String selectName) {
		logger.debug("categoryAnimal()메서드 selectName is {}", selectName);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("AnimalCategory", AnimalCategory);
		map.put("selectName", selectName);
		
		List<AnimalCommand> categoryAnimal = animaldao.selectCategory(map);
		logger.debug("categoryAnimal()메서드 categoryAnimal is {}", categoryAnimal);
		return categoryAnimal;
	}
}
