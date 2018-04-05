package com.cafe24.iso159.exp.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.iso159.animal.service.Animal;
import com.cafe24.iso159.member.service.Member;


@Repository
public class ExpDao {
	@Autowired
	//생성해서 사용할 객체를 bean을 통해 생성해서 가져옴
	private SqlSessionTemplate sqlSessionTemplate;
	//디버그용 로거 생성
	private static final Logger logger = LoggerFactory.getLogger(ExpDao.class);
	//맵퍼 id를 가져올때 사용할 맵퍼 생성
	private final String nameSpace = "com.cafe24.iso159.exp.service.ExpMapper.";
	
	//체험 일지 수정
	public void updateExpJournal(ExpJournal expJournal) {
		logger.debug("ExpDao.java 호출 {updateExpJournal}.");
		logger.debug("updateExpJournal() 메서드 실행 expJournal is {}", expJournal);
		sqlSessionTemplate.update(nameSpace + "updateExpJournal", expJournal);
	}
	
	//해당번호 체험일지 수정 내용 조회
	public ExpJournal selectExpJournalInfo(String expJournalCode) {
		logger.debug("ExpDao.java 호출 {selectExpJournalInfo}.");
		logger.debug("selectExpJournalInfo() 메서드 실행 expJournalCode is {}", expJournalCode);
		ExpJournal expJournal = sqlSessionTemplate.selectOne(nameSpace + "selectExpJournalInfo", expJournalCode);
		logger.debug("selectExpJournalInfo() 메서드 실행 expJournal is {}", expJournal);
		return expJournal;
	}
	
	//해당 체험자 체험일지 리스트
	public List<ExpJournal> selectExpJournalList(String expCode) {
		logger.debug("ExpDao.java 호출 {selectExpJournalList}.");
		logger.debug("selectExpJournalList() 메서드 실행 expCode is {}", expCode);
		List<ExpJournal> expJournal = sqlSessionTemplate.selectList(nameSpace + "selectExpJournalList", expCode);
		logger.debug("selectExpJournalList() 메서드 실행 expJournal is {}", expJournal);
		return expJournal;
	}
	
	//체험일지 작성
	public void addExpJournal(ExpJournal expJournal) {
		logger.debug("ExpDao.java 호출 {addExpJournal}.");
		logger.debug("addExpJournal() 메서드 실행 expJournal is {}", expJournal);
		sqlSessionTemplate.insert(nameSpace + "addExpJournal", expJournal);
	}
	
	//exp_journal_code PK값 구하는 부분
	public int selectExpJournalCode() {
		logger.debug("ExpDao.java 호출 {selectExpJournalCode}.");
		int expJournalCode = sqlSessionTemplate.selectOne(nameSpace + "selectExpJournalCode");
		logger.debug("selectExpJournalCode() 메서드 실행 expJournalCode is {}", expJournalCode+1);
		return expJournalCode+1;
	}
	
	// 동물반환완료 클릭시 os_code수정
	public void updateCostIoOsCode(CostIo costIo) {
		logger.debug("ExpDao.java 호출 {updateCostIoOsCode}.");
		logger.debug("updateCostIoOsCode() 메서드 실행 costIo is {}", costIo);
		sqlSessionTemplate.update(nameSpace + "updateCostIoOsCode", costIo);
	}
	
	// 체험일지 작성 횟수 확인
	public int selectExpCodeCountFind(String expCode) {
		logger.debug("ExpDao.java 호출 {selectExpCodeCountFind}.");
		logger.debug("selectExpCodeCountFind() 메서드 실행 expCode is {}", expCode);
		int count = sqlSessionTemplate.selectOne(nameSpace+"selectExpCodeCountFind", expCode);
		logger.debug("selectExpCodeCountFind() 메서드 실행 count is {}", count);
		return count;
	}
	
	// exp_code로 costIoCode 검색
	public String selectFindCostIoCode(CostIo costIo) {
		logger.debug("ExpDao.java 호출 {selectFindCostIoCode}.");
		logger.debug("selectFindCostIoCode() 메서드 실행 costIo is {}", costIo);
		String costIoCode = sqlSessionTemplate.selectOne(nameSpace + "selectFindCostIoCode", costIo);
		logger.debug("selectFindCostIoCode() 메서드 실행 costIoCode is {}", costIoCode);
		return costIoCode;
	}
	
	//동물지급완료 클릭시 cose_io생성
	public void addCostIo(CostIo costIo) {
		logger.debug("ExpDao.java 호출 {addCostIo}.");
		logger.debug("addCostIo() 메서드 실행 costIo is {}", costIo);
		sqlSessionTemplate.insert(nameSpace + "addCostIo", costIo);
	}
	
	// cost_io_code PK값 구하는 부분
	public int selectCostIoCode() {
		logger.debug("ExpDao.java 호출 {selectCostIoCode}.");
		int costIoCode = sqlSessionTemplate.selectOne(nameSpace + "selectCostIoCode");
		logger.debug("selectCostIoCode() 메서드 실행 costIoCode is {}", costIoCode+1);
		return costIoCode+1;
	}
	
	// 보호소 체험진행,종료시 체험 상태 변경
	public void progressionExpUpdate(Exp exp) {
		logger.debug("ExpDao.java 호출 {progressionExpUpdate}.");
		logger.debug("progressionExpUpdate() 메서드 실행 exp is {}", exp);
		sqlSessionTemplate.update(nameSpace + "progressionExpUpdate", exp);
	}
	
	// 보호소 체험진행,종료시 동물 상태 변경
	public void progressionAnimalUpdate(Animal animal) {
		logger.debug("ExpDao.java 호출 {progressionAnimalUpdate}.");
		logger.debug("progressionAnimalUpdate() 메서드 실행 animal is {}", animal);
		sqlSessionTemplate.update(nameSpace + "progressionAnimalUpdate", animal);
	}
	
	//보호소 체험 신청 현황 수정
	public void updateOsExp(Exp exp) {
		logger.debug("ExpDao.java 호출 {updateOsExp}.");
		logger.debug("updateOsExp() 메서드 실행 exp is {}", exp);
		sqlSessionTemplate.update(nameSpace + "updateOsExp", exp);
	}
	//해당 보호소 체험자 정보
	public ExpAndAnimalAndOverallStatusAndExpPeriodAndMemberInfo selectExpShelterInfo(String expCode) {
		logger.debug("ExpDao.java 호출 {selectExpShelterInfo}.");
		logger.debug("selectExpShelterInfo() 메서드 실행 expCode is {}", expCode);
		//체험 리스트에서 체험 코드 가져와서 정보 확인
		ExpAndAnimalAndOverallStatusAndExpPeriodAndMemberInfo expShelterInfo = sqlSessionTemplate.selectOne(nameSpace + "selectExpShelterInfo", expCode);
		logger.debug("selectExpShelterInfo() 메서드 실행 expShelterInfo is {}", expShelterInfo);
		return expShelterInfo;
	}
	
	//해당 보호소 체험자 리스트 에서 정보 확인할때 체험 상태 확인
	public Exp updateExpOsNameCheck(Exp exp) {
		logger.debug("ExpDao.java 호출 {updateExpOsNameCheck}.");
		logger.debug("updateExpOsNameCheck() 메서드 실행 exp is {}", exp);
		Exp checkExp = sqlSessionTemplate.selectOne(nameSpace + "updateExpOsNameCheck", exp);
		return checkExp;
	}
	
	//해당 보호소 체험자 리스트 에서 정보 확인할때 확인자 아이디 ,체험 상태 등록
	public void updateExpmShelterIdCheck(Exp exp) {
		logger.debug("ExpDao.java 호출 {updateExpmShelterIdCheck}.");
		logger.debug("updateExpmShelterIdCheck() 메서드 실행 exp is {}", exp);
		sqlSessionTemplate.update(nameSpace + "updateExpmShelterIdCheck", exp);
	}
	
	//해당 보호소 체험자 리스트
	public List<Exp> selectExpShelterList(String blCode) {
		logger.debug("ExpDao.java 호출 {selectExpShelterList}.");
		logger.debug("selectExpShelterList() 메서드 실행 blCode is {}", blCode);
		List<Exp> exp = sqlSessionTemplate.selectList(nameSpace + "selectExpShelterList", blCode);
		logger.debug("selectExpShelterList() 메서드 실행 exp is {}", exp);
		return exp;
	}
	
	//체험자인지 보호소인지 확인
	public Member selectMemberCheck(String mId) {
		//호출된곳 확인
		logger.debug("ExpDao.java 호출 {selectMemberCheck}.");
		logger.debug("selectMemberCheck() 메서드 실행 mId is {}", mId);
		Member member = sqlSessionTemplate.selectOne(nameSpace + "selectMemberCheck", mId);
		logger.debug("selectMemberCheck() 메서드 실행 member is {}", member);
		return member;
	}
	
	//체험신청자 체험 삭제
	public void deleteExpOne(String expCode) {
		//호출된곳 확인
		logger.debug("ExpDao.java 호출 {deleteExpOne}.");
		logger.debug("deleteExpOne() 메서드 실행 expCode is {}", expCode);
		sqlSessionTemplate.delete(nameSpace + "deleteExpOne", expCode);
	}
	
	//사용자가 자기가신청한 체험 리스트 보는 코드
	public List<ExpAndAnimal> selectExpOneList(String mExpId) {
		//호출된곳 확인
		logger.debug("ExpDao.java 호출 {selectExpOneList}.");
		List<ExpAndAnimal> expAndAnimal = sqlSessionTemplate.selectList(nameSpace + "selectExpOneList", mExpId);
		logger.debug("selectExpOneList() 메서드 실행 expAndAnimal is {}", expAndAnimal);
		return expAndAnimal;
	}
	
	//사용자가 자기가신청한 체험정보 보는 코드
	public ExpAndAnimalAndBusinessLicense selectExpOneInfo(String expCode){
		//호출된곳 확인
		logger.debug("ExpDao.java 호출 {selectExpOne}.");
		ExpAndAnimalAndBusinessLicense expAndAnimalAndBusinessLicense = sqlSessionTemplate.selectOne(nameSpace + "selectExpAndAnimalAndBusinessLicenseOneInfo", expCode);
		logger.debug("selectExpOneInfo() 메서드 실행 expAndAnimalAndBusinessLicense is {}", expAndAnimalAndBusinessLicense);
		return expAndAnimalAndBusinessLicense;
	}
	
	//expPeriod 목록 띄워주는 코드
	public List<ExpPeriod> selectExpPeriod() {
		//호출된곳 확인
		logger.debug("ExpDao.java 호출 {selectExpPeriod}.");
		List<ExpPeriod> expPeriod = sqlSessionTemplate.selectList(nameSpace+"selectExpPeriod");
		logger.debug("selectExpPeriod() 메서드 실행 expPeriod is {}", expPeriod);
		return expPeriod;
	}
	
	//expCode 생성 코드
	public int selectExpCode() {
		//호출된곳 확인
		logger.debug("ExpDao.java 호출 {selectExpCode}.");
		//expCode 생성
		int expCode = sqlSessionTemplate.selectOne(nameSpace+"selectExpCode");
		logger.debug("selectExpCode() 메서드 실행 expCode is {}", expCode+1);
		return expCode+1;
	}
	
	//exp 입력 코드
	public void addExp(Exp exp) {
		logger.debug("ExpDao.java 호출 {addExp}.");
		logger.debug("addExp() 메서드 실행 exp is {}", exp);
		sqlSessionTemplate.insert(nameSpace+"addExp", exp);
	}
}
