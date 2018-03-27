package com.cafe24.iso159.exp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExpService {
	@Autowired
	//@Autowired를 통해서 new를 통해서 객체를 생성하지 않고 미리 생성해서 사용
	private ExpDao expDao;
	//디버그용 로거 생성
	private static final Logger logger = LoggerFactory.getLogger(ExpService.class);
	
	
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
		String osCodeExp = "os_exp_exp_12_1_3";
		logger.debug("addExp() 메서드 실행 osCodeReserve is {}", osCodeExp);
		addexp.setOsCodeExp(osCodeExp);
		
		//osCodeCostReturn 값 대입
		//책임비는 처음에 받기 때문에 os_cost_13_1_1 로 변수로 생성해서 대입
		String osCodeCostReturn = "os_cost_13_1_1";
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
