package com.cafe24.iso159.exp.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.iso159.animal.service.Animal;

@Service
@Transactional
public class ExpService {
	@Autowired
	//@Autowired를 통해서 new를 통해서 객체를 생성하지 않고 미리 생성해서 사용
	private ExpDao expDao;
	//디버그용 로거 생성
	private static final Logger logger = LoggerFactory.getLogger(ExpService.class);
	
	//체험돌물 보여줄때 해당동물 이미 진행한 체험 기록 보여줌
	public Map<String, Object> selectOneAnimalExpInfo(Map<String, Object> map){
		logger.debug("ExpService.java 호출 {selectOneAnimalExpInfo}.");
		logger.debug("selectOneAnimalExpInfo() 메서드 실행 map is {}", map);
		// map 에서 currentPage,rowPerPage 리턴맵에 담기위해 꺼낸다
		int currentPage = (Integer)map.get("currentPage");
		int rowPerPage = (Integer)map.get("rowPerPage");
		// 시작 페이지를 구한다
		int startRow = (currentPage-1)*rowPerPage;
		logger.debug("selectOneAnimalExpInfo() 메서드 실행 startRow is {}", startRow);
		map.put("startRow", startRow);
		//startRow,rowPerPage,animalCode 를 이용해서 리스트를 꺼내온다
		List<ExpAndExpJournal> expAndAnimalAndExpJournal = expDao.selectOneAnimalExpInfo(map);
		logger.debug("selectOneAnimalExpInfo() 메서드 실행 expAndAnimalAndExpJournal is {}", expAndAnimalAndExpJournal);
		// 데이터 총갯수 구함
		String animalCode = (String)map.get("animalCode");
		int totalCount = expDao.selectExpAnimalTotalCount(animalCode);
		// 페이지 마지막 표시
		int lastPage = (int)Math.ceil((double)totalCount/(double)rowPerPage);
		//리턴 맵에 가져온 리스트와 currentPage,rowPerPage,startRow,lastPage,totalCount 담아서 넘김
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("currentPage",currentPage);
		returnMap.put("rowPerPage",rowPerPage);
		returnMap.put("startRow", startRow);
		returnMap.put("lastPage", lastPage);
		returnMap.put("totalCount", totalCount);
		returnMap.put("expAndAnimalAndExpJournal", expAndAnimalAndExpJournal);
		return returnMap;
	}
	
	//체험 하기 클릭시 체험 가능 동물 내용 띄워줌
	public List<Animal> selectExpAnimalList(){
		logger.debug("ExpService.java 호출 {selectExpAnimalList}.");
		String osCodeAnimal = "os_animal_3_1_2";
		logger.debug("selectExpAnimalList() 메서드 실행 osCodeAnimal is {}", osCodeAnimal);
		List<Animal> animal = expDao.selectExpAnimalList(osCodeAnimal);
		logger.debug("selectExpAnimalList() 메서드 실행 animal is {}", animal);
		return animal;
	}
	
	//체험 일지 수정
	public void updateExpJournal(ExpJournal expJournal) {
		logger.debug("ExpService.java 호출 {updateExpJournal}.");
		logger.debug("updateExpJournal() 메서드 실행 expJournal is {}", expJournal);
		expDao.updateExpJournal(expJournal);
	}
	
	//해당번호 체험일지 수정 내용 조회
	public ExpJournal selectExpJournalInfo(String expJournalCode) {
		logger.debug("ExpService.java 호출 {selectExpJournalInfo}.");
		logger.debug("selectExpJournalInfo() 메서드 실행 expJournalCode is {}", expJournalCode);
		ExpJournal expJournal = expDao.selectExpJournalInfo(expJournalCode);
		logger.debug("selectExpJournalInfo() 메서드 실행 expJournal is {}", expJournal);
		return expJournal;
	}
	
	//해당 체험자 체험일지 리스트
	public List<ExpJournal> selectExpJournalList(String expCode){
		logger.debug("ExpService.java 호출 {selectExpJournalList}.");
		logger.debug("selectExpJournalList() 메서드 실행 expCode is {}", expCode);
		List<ExpJournal> expJournal = expDao.selectExpJournalList(expCode);
		logger.debug("selectExpJournalList() 메서드 실행 expJournal is {}", expJournal);
		return expJournal;
	}
	
	// 체험일지 작성
	public void addExpJournal(ExpJournal expJournal) {
		//호출된곳 확인
		logger.debug("ExpService.java 호출 {addExpJournal}.");
		logger.debug("addExpJournal() 메서드 실행 expJournal is {}", expJournal);
		//expJournalCode 생성 및 대입
		int expJournalCode = expDao.selectExpJournalCode();
		logger.debug("addExpJournal() 메서드 실행 expJournalCode is {}", expJournalCode);
		expJournal.setExpJournalCode("exp_journal_code_" + expJournalCode);
		//뷰에서 받아온 정보랑 같이 넘김
		expDao.addExpJournal(expJournal);
	}
	
	// 보호소 체험진행,종료시 동물,체험 상태 변경
	public void progressionAnimalAndExpUpdate(Map<String, Object> map) {
		//호출된곳 확인
		logger.debug("ExpService.java 호출 {progressionAnimalAndExpUpdate}.");
		logger.debug("progressionAnimalAndExpUpdate() 메서드 실행 map is {}", map);
		// 보호소 체험진행,종료시 동물 상태 변경
		Animal animal = (Animal)map.get("animal");
		expDao.progressionAnimalUpdate(animal);
		// 보호소 체험진행,종료시 동물 상태 변경
		Exp exp = (Exp)map.get("exp");
		if(exp.getOsCodeExp().equals("os_exp_12_1_2")) {
			logger.debug("동물반환완료 클릭 {}.");
			exp.setOsCodeCostReturn("os_cost_return_24_1_1");
			logger.debug("progressionAnimalAndExpUpdate() 메서드 실행 osCodeCostReturn is {}", exp.getOsCodeCostReturn());
		}
		expDao.progressionExpUpdate(exp);
		// costIo 생성
		CostIo costIo = (CostIo)map.get("costIo");
		// expCost를 이용해서 분기 생성
		if(costIo.getCostIoCost() != 1) {
			//costIoCode코드 생성 및 대입
			int costIoCodenum = expDao.selectCostIoCode();
			String costIocode = "cost_io_code_" + costIoCodenum;
			logger.debug("progressionAnimalAndExpUpdate() 메서드 실행 costIocode is {}", costIocode);
			costIo.setCostIoCode(costIocode);
			logger.debug("progressionAnimalAndExpUpdate() 메서드 실행 costIo is {}", costIo);
			expDao.addCostIo(costIo);
		}else {
			String costIoCode = expDao.selectFindCostIoCode(costIo);
			costIo.setCostIoCode(costIoCode);
			expDao.updateCostIoOsCode(costIo);
		}
	}
	
	//보호소 체험 신청 현황 수정
	public void updateOsExp(Exp exp) {
		//호출된곳 확인
		logger.debug("ExpService.java 호출 {updateOsExp}.");
		logger.debug("updateOsExp() 메서드 실행 exp is {}", exp);
		// 체험 수락 날짜 입력
		// 오늘 날짜 생성
		Date today = new Date();
		// 날짜 입력 폼 생성
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// 날짜 입력
		logger.debug("updateOsExp() 메서드 실행 date.format(today) is {}", date.format(today));
		exp.setExpCheckDate(date.format(today));
		expDao.updateOsExp(exp);
	}
	
	//해당 보호소 체험자 정보
	public ExpAndAnimalAndOverallStatusAndExpPeriodAndMemberInfo selectExpShelterInfo(String expCode) {
		//호출된곳 확인
		logger.debug("ExpService.java 호출 {selectExpShelterInfo}.");
		logger.debug("selectExpShelterInfo() 메서드 실행 expCode is {}", expCode);
		//체험 리스트에서 체험 코드 가져와서 정보 확인
		ExpAndAnimalAndOverallStatusAndExpPeriodAndMemberInfo expShelterInfo = expDao.selectExpShelterInfo(expCode);
		logger.debug("selectExpShelterInfo() 메서드 실행 expShelterInfo is {}", expShelterInfo);
		return expShelterInfo;
	}
	
	//해당 보호소 체험자 리스트 에서 정보 확인할때 확인자 아이디,체험 상태 등록
	public void updateExpmShelterIdCheck(Exp exp) {
		logger.debug("ExpService.java 호출 {updateExpmShelterIdCheck}.");
		logger.debug("updateExpmShelterIdCheck() 메서드 실행 exp is {}", exp);
		// 체험 상태 확인
		Exp checkExp = expDao.updateExpOsNameCheck(exp);
		if(checkExp.getOsName().equals("예약 신청")) {
			// 체험 상태 변경
			String osCodeExp = "os_exp_12_1_4";
			exp.setOsCodeExp(osCodeExp);
			expDao.updateExpmShelterIdCheck(exp);
		}
	}
	
	//해당 보호소 체험자 리스트
	public List<Exp> selectExpShelterList(String blCode){
		//호출된곳 확인
		logger.debug("ExpService.java 호출 {selectExpShelterList}.");
		logger.debug("selectExpShelterList() 메서드 실행 blCode is {}", blCode);
		List<Exp> exp = expDao.selectExpShelterList(blCode);
		logger.debug("selectExpShelterList() 메서드 실행 exp is {}", exp);
		return exp;
	}
	
	//체험신청자 체험 삭제
	public void deleteExpOne(String expCode) {
		//호출된곳 확인
		logger.debug("ExpService.java 호출 {deleteExpOne}.");
		logger.debug("deleteExpOne() 메서드 실행 expCode is {}", expCode);
		expDao.deleteExpOne(expCode);
	}
	
	//사용자 자신의 체험 정보 리스트 뿌려주는 부분
	public Map<String, Object> selectExpOneList(Map<String, Object> map) {
		//호출된곳 확인
		logger.debug("ExpService.java 호출 {selectExpOneList}.");
		logger.debug("selectExpOneList() 메서드 실행 map is {}", map);
		String mExpId = (String)map.get("mExpId");
		int currentPage = (Integer)map.get("currentPage");
		int rowPerPage = (Integer)map.get("rowPerPage");
		// 시작  페이지
		int startRow = (currentPage-1)*rowPerPage;
		map.put("startRow", startRow);
		List<ExpAndAnimal> expAndAnimal = expDao.selectExpOneList(map);
		logger.debug("selectExpOneList() 메서드 실행 expAndAnimal is {}", expAndAnimal);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("rowPerPage", rowPerPage);
		returnMap.put("currentPage", currentPage);
		returnMap.put("startRow", startRow);
		returnMap.put("expAndAnimal", expAndAnimal);
		// 데이터 총갯수 구함
		int totalCount = expDao.selectExpTotalCount(mExpId);
		returnMap.put("totalCount", totalCount);
		// 페이지마다 마지막 표시
		int lastPage = (int)Math.ceil((double)totalCount/(double)rowPerPage);
		returnMap.put("lastPage", lastPage);
		return returnMap;
	}
	
	//사용자 자신이 신청한 체험 정보 뿌려주는 부분
	public Map<String, Object> selectExpOneInfo(String expCode){
		//호출된곳 확인
		logger.debug("ExpService.java 호출 {selectExpOneInfo}.");
		ExpAndAnimalAndBusinessLicense expAndAnimalAndBusinessLicense = expDao.selectExpOneInfo(expCode);
		logger.debug("selectExpOneInfo() 메서드 실행 expAndAnimalAndBusinessLicense is {}", expAndAnimalAndBusinessLicense);
		//체험일지 작성 횟수 확인
		int count = expDao.selectExpCodeCountFind(expCode);
		//담아서 리턴
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("expAndAnimalAndBusinessLicense", expAndAnimalAndBusinessLicense);
		map.put("count", count);
		return map;
	}
	
	//체험 신청할때 날짜선택 뿌려주는 부분
	public List<ExpPeriod> expPeriod() {
		//호출된곳 확인
		logger.debug("ExpService.java 호출 {expPeriod}.");
		List<ExpPeriod> expPeriod = expDao.selectExpPeriod();
		logger.debug("expPeriod() 메서드 실행 expPeriod is {}", expPeriod);
		return expPeriod;
	}
	
	// 체험 신청 입력부분
	public void addExp(Exp exp) {
		//입력받거나 생성된 정보입력을 위해 객체 생성
		Exp addexp = new Exp();
		//호출된곳 확인
		logger.debug("ExpService.java 호출 {addExp}.");
		
		//expCode 값 생성
		int expCode = expDao.selectExpCode();
		logger.debug("addExp() 메서드 실행 expCode is {}", expCode);
		//expCode 값 대입
		addexp.setExpCode("exp_code_"+expCode);
		logger.debug("addExp() 메서드 실행 expCode is {}", addexp.getExpCode());
		//animalCode 값 대입
		logger.debug("addExp() 메서드 실행 AnimalCode is {}", exp.getAnimalCode());
		addexp.setAnimalCode(exp.getAnimalCode());
		
		//mExpId 값 대입
		logger.debug("addExp() 메서드 실행 mExpId is {}", exp.getmExpId());
		addexp.setmExpId(exp.getmExpId());
		
		//blCode 값 대입
		logger.debug("addExp() 메서드 실행 blCode is {}", exp.getBlCode());
		addexp.setBlCode(exp.getBlCode());
		
		//epCode 값 대입
		logger.debug("addExp() 메서드 실행 ExpPeriodCode is {}", exp.getExpPeriodCode());
		addexp.setExpPeriodCode(exp.getExpPeriodCode());;
		
		//osCodeReserve 값 대입
		//신청은 os_exp_reserve_12_1_1 이기 때문에 변수로 생성해서 대입
		String osCodeExp = "os_exp_12_1_3";
		logger.debug("addExp() 메서드 실행 osCodeReserve is {}", osCodeExp);
		addexp.setOsCodeExp(osCodeExp);
		
		//osCodeCostReturn 값 대입
		//책임비는 os_cost_return_24_1_2 로 변수로 생성해서 대입
		String osCodeCostReturn = "os_cost_return_24_1_2";
		logger.debug("addExp() 메서드 실행 osCodeCostReturn is {}", osCodeCostReturn);
		addexp.setOsCodeCostReturn(osCodeCostReturn);
		
		//expJournalCount 값 대입
		logger.debug("addExp() 메서드 실행 expJournalCount is {}", exp.getExpJournalCount());
		addexp.setExpJournalCount(exp.getExpJournalCount());
		
		//expCost 값 대입
		logger.debug("addExp() 메서드 실행 expCost is {}", exp.getExpCost());
		addexp.setExpCost(exp.getExpCost());
		
		//expPurpose 값 대입
		logger.debug("addExp() 메서드 실행 expPurpose is {}", exp.getExpPurpose());
		addexp.setExpPurpose(exp.getExpPurpose());
		
		//expStartDate 값 대입
		logger.debug("addExp() 메서드 실행 expStartDate is {}", exp.getExpStartDate());
		addexp.setExpStartDate(exp.getExpStartDate());
		
		//expEndDate 값 대입
		logger.debug("addExp() 메서드 실행 expEndDate is {}", exp.getExpEndDate());
		addexp.setExpEndDate(exp.getExpEndDate());
		
		//입력받아온값들 Dao대입
		logger.debug("addExp() 메서드 실행 addexp is {}", addexp);
		expDao.addExp(addexp);
	}
}
