package com.cafe24.iso159.exp.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
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
	public List<ExpAndAnimal> selectExpOneList(String mExpId) {
		//호출된곳 확인
		logger.debug("ExpService.java 호출 {selectExpOneList}.");
		List<ExpAndAnimal> expAndAnimal = expDao.selectExpOneList(mExpId);
		logger.debug("selectExpOneList() 메서드 실행 expAndAnimal is {}", expAndAnimal);
		return expAndAnimal;
	}
	
	//사용자 자신이 신청한 체험 정보 뿌려주는 부분
	public ExpAndAnimalAndBusinessLicense selectExpOneInfo(String expCode){
		//호출된곳 확인
		logger.debug("ExpService.java 호출 {selectExpOneInfo}.");
		ExpAndAnimalAndBusinessLicense expAndAnimalAndBusinessLicense = expDao.selectExpOneInfo(expCode);
		logger.debug("selectExpOneInfo() 메서드 실행 expAndAnimalAndBusinessLicense is {}", expAndAnimalAndBusinessLicense);
		return expAndAnimalAndBusinessLicense;
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
