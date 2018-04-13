package com.cafe24.iso159.adopt.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.iso159.animal.service.Animal;


@Repository
public class AdoptDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private static final Logger logger = LoggerFactory.getLogger(AdoptDao.class);
	private final String nameSpace = "com.cafe24.iso159.adopt.service.AdoptMapper."; 
	
	// 입양신청
	public void insertAdopt(AdoptRequest adoptRequest) {
		logger.debug("insertAdopt() 메서드 호출");
		sqlSessionTemplate.insert(nameSpace + "AdoptRequest", adoptRequest);
	}
	
	// 입양자 등록
	public void insertAdopter(Adopt adopt) {
		logger.debug("insertAdopter() 메서드 호출 adopt is {}", adopt);
		sqlSessionTemplate.insert(nameSpace + "insertAdopter", adopt);
	}
	// 입양자등록시 필요컬럼 조회
	public Adopt selectAdoptRequestByAdoptRequestCode(String adoptRequestCode) {
		logger.debug("selectAdoptRequestByAdoptRequestCode() 메서드 호출 adoptRequestCode is {]", adoptRequestCode);
		return sqlSessionTemplate.selectOne(nameSpace + "selectAdoptRequestByAdoptRequestCode", adoptRequestCode);
	}
	
	// 입양자조회
	public List<Adopt> selectAdopt(){
		logger.debug("selectAdopt() 메서드 호출 adoptRequestCode");
		List<Adopt> list = sqlSessionTemplate.selectList(nameSpace + "selectAdopt");
		logger.debug("selectAdopt() 메서드 호출 list is {}",list);
		return list;
	}
	
	// 입양신청메뉴에서 입양가능한 동물리스트 조회
	public List<Animal> selectAdoptAnimalList(String osCodeAnimal){
		logger.debug("selectAdoptAnimalList() 메서드 호출 osCodeAnimal is {}",osCodeAnimal);
		List<Animal> list = sqlSessionTemplate.selectList(nameSpace + "selectAdoptAnimalList", osCodeAnimal);
		return list;
	}
	
	// 파일등록
	public int insertAdoptFile(AdoptRequestFile adoptRequestFile) {
		logger.debug("insertAdoptFile() 메서드 호출, adoptRequestFile is {}", adoptRequestFile);
		return sqlSessionTemplate.insert(nameSpace + "insertAdoptFile", adoptRequestFile);
	}
	
	// max코드값 조회
	public String selectLastCodeAr() {
		logger.debug("selectLastCodeAr() 메서드 호출");
		return sqlSessionTemplate.selectOne(nameSpace + "selectLastCodeAr");
	}
	public String selectLastCodeOf() {
		logger.debug("selectLastCodeOf() 메서드 호출");
		return sqlSessionTemplate.selectOne(nameSpace + "selectLastCodeOf");
	}
	public String selectLastCodeA() {
		logger.debug("selectLastCodeA() 메서드 호출");
		return sqlSessionTemplate.selectOne(nameSpace + "selectLastCodeA");
	}
	
	
	// 입양신청조회
	public List<AdoptRequestAndOsCodeAnimal> selectAdoptRequest(){
		logger.debug("List<AdoptRequestAndOsCodeAnimal> selectAdoptRequest() 메서드 호출");
		List<AdoptRequestAndOsCodeAnimal> list = sqlSessionTemplate.selectList(nameSpace + "selectAdoptRequest");
		logger.debug("List<AdoptRequestAndOsCodeAnimal> selectAdoptRequest() list.size() is {}", list.size());
		return list;
	}
	
	// 입양신청 조회
	public List<AdoptCommand> selectAdoptCategory(Map map){
		logger.debug("List<AdoptCommand> selectAdoptCategory() 메서드 호출 map is {}",map);
		List<AdoptCommand> list = sqlSessionTemplate.selectList(nameSpace + "selectAdoptCategory", map);
		logger.debug("List<AdoptCommand> selectAdoptCategory() 메서드 호출 list is {}",list);
		return list;
	}
	// 입양신청 회원아이디로 개인조회
	public List<AdoptRequestAndOsCodeAnimal> selectAdoptRequestByMemberId(String mMemberId){
		logger.debug("selectAdoptRequestByMemberId() 메서드 호출 mMemberId is {}", mMemberId);
		List<AdoptRequestAndOsCodeAnimal> list = sqlSessionTemplate.selectList(nameSpace + "selectAdoptRequestByMemberId",mMemberId);
		logger.debug("selectAdoptRequestByMemberId() list is {}", list);
		return list;
	}
	
	// 입양신청 확인
	public void updateOsCodeAdoptRequest(String adoptRequestCode) {
		logger.debug("updateOsCodeAdopt() 메서드 호출");
		sqlSessionTemplate.update(nameSpace + "updateOsCodeAdopt412", adoptRequestCode);
	}
	
	// 입양신청 파일조회
	public List<AdoptRequestFile> selectAdoptFileList(String adoptRequestCode){
		logger.debug("selectAdoptFileList() 메서드 호출 adoptRequestCode is {}", adoptRequestCode);
		List<AdoptRequestFile> list = sqlSessionTemplate.selectList(nameSpace + "selectAdoptFileList", adoptRequestCode);
		return list;
	}
	
	// 상담등록확인
	public void updateOsCodeAdoptCounsel(String adoptRequestCode) {
		logger.debug("updateOsCodeAdoptCounsel() 메서드 호출");
		sqlSessionTemplate.update(nameSpace + "updateOsCodeAdopt415", adoptRequestCode);
	}
	
	// 입양결정완료
	public void updateOsCodeAdoptDecide(String adoptRequestCode) {
		logger.debug("updateOsCodeAdoptDecide() 메서드 호출");
		sqlSessionTemplate.update(nameSpace + "updateOsCodeAdopt417", adoptRequestCode);
	}
	
	// 동물상태코드 체험동물->입양동물 수정
	public void updateOsCodeAnimal(String animalCode) {
		logger.debug("updateOsCodeAnimal() 메서드 호출 animalCode is {}", animalCode);
		sqlSessionTemplate.update(nameSpace + "updateOsCodeAnimal", animalCode);
	}
	// 동물상태코드 체험동물로 수정
	public void updateOsCodeAnimal312(String animalCode) {
		logger.debug("updateOsCodeAnimal312() 메서드 호출 animalCode is {}", animalCode);
		sqlSessionTemplate.update(nameSpace + "updateOsCodeAnimal312", animalCode);
	}
	// 파일삭제 
	public void deleteAdoptFile(String adoptRequestCode) {
		logger.debug("deleteAdoptFile() 메서드 호출");
		sqlSessionTemplate.delete(nameSpace + "deleteAdoptFile", adoptRequestCode);
	}
	
	// 입양취소 
	public void deleteAdopt(String adoptRequestCode) {
		logger.debug("deleteAdopt() 메서드 호출");
		sqlSessionTemplate.delete(nameSpace + "deleteAdopt", adoptRequestCode);
	}
	
	// 상담내용입력
	public void updateAdoptRequestAdvice(AdoptRequest adoptRequest) {
		logger.debug("updateAdoptRequestAdvice() 메서드 호출");
		logger.debug("updateAdoptRequestAdvice() 메서드 adoptRequest is {}", adoptRequest);
		sqlSessionTemplate.update(nameSpace + "updateAdoptRequestAdvice", adoptRequest);
	}
	// 상담내용조회
	public AdoptRequest selectAdoptCounselList(String adoptRequestCode) {
		logger.debug("selectAdoptCounselList() 메서드 호출");
		logger.debug("selectAdoptCounselList() 메서드 adoptRequestCode is {}", adoptRequestCode);
		return sqlSessionTemplate.selectOne(nameSpace + "selectAdoptCounselList", adoptRequestCode);
	}
}
