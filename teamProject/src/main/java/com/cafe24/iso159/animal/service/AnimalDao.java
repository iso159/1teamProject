package com.cafe24.iso159.animal.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AnimalDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private static final Logger logger = LoggerFactory.getLogger(AnimalDao.class);
	
	private final String nameSpace = "com.cafe24.iso159.animal.service.AnimalMapper.";
	
	// 동물 상태별 카운트 조회 쿼리문 selectAnimalCountByOsName을 접근하는 DAO 메서드
	public int selectAnimalCountByOsName(Map<String,Object> map) {
		logger.debug("selectAnimalCountByOsName(Map<String,Object> map) 메서드 호출");
		logger.debug("selectAnimalCountByOsName(Map<String,Object> map) 메서드 map is {}", map);
		int totalCount = sqlSessionTemplate.selectOne(nameSpace + "selectAnimalCountByOsName", map);
		logger.debug("selectAnimalCountByOsName(Map<String,Object> map) 메서드 totalCount is {}", totalCount);
		logger.debug("selectAnimalCountByOsName(Map<String,Object> map) 메서드 끝");
		return totalCount;
	}
	
	// animal 테이블에서 동물 상태코드를 수정하는 쿼리문 updateAnimalOsCode을 접근하는 DAO 메서드
	public void updateAnimalOsCode(Animal animal) {
		logger.debug("updateAnimalOsCode(Animal animal) 메서드 호출");
		logger.debug("updateAnimalOsCode(Animal animal) 메서드 animal is {}", animal);
		int result = sqlSessionTemplate.update(nameSpace + "updateAnimalOsCode", animal);
		logger.debug("updateAnimalOsCode(Animal animal) 메서드 result is {}", result);
		logger.debug("updateAnimalOsCode(Animal animal) 메서드 끝");
	}
	
	//동물등록
	public int insertAnimal(Animal animal) {		
		logger.debug("insertAnimal()메서드 animal is {}", animal);		
		return sqlSessionTemplate.insert(nameSpace+"insertAnimal", animal); 
	}
	//max코드값 조회
		public String selectLastCode() {
			return sqlSessionTemplate.selectOne(nameSpace+"selectLastCode");
		}
	//동물 리스트 조회
	public List<AnimalCommand> selectAnimalList(Map<String,Object> map){
		logger.debug("selectAnimalList(String blCode)메서드 호출");
		logger.debug("selectAnimalList(String blCode)메서드 map is {}", map);
		List<AnimalCommand> AnimalList = sqlSessionTemplate.selectList(nameSpace+"selectAnimalList",map);
		logger.debug("selectAnimalList(String blCode)메서드 호출 AnimalList is {}", AnimalList);
		logger.debug("selectAnimalList(String blCode)메서드 끝");
		return AnimalList;
	}
	//동물삭제
	public void deleteAnimal(String animalCode) {
		//String값 받아오는지 확인
		logger.debug("deleteAnimal()메서드 animalCode is {}", animalCode);
		sqlSessionTemplate.delete(nameSpace+"deleteAnimal",animalCode);
	}
	//동물리스트수정
	public void updateAnimal(Animal animal) {
		//animal 리스트 확인
		logger.debug("updateAnimal()메서드 animal is {}", animal);
		sqlSessionTemplate.update(nameSpace+"updateAnimal", animal);
	}
	//동물리스트 한개 조회
	public Animal selectAnimalOne(String animalCode) {
		//매개변수 확인
		logger.debug("selectAnimalOne()메서드 animalCode is {}", animalCode);
		return sqlSessionTemplate.selectOne(nameSpace+"selectAnimalOne", animalCode);
	}
	//동물 상세조회
	public AnimalCommand animalDetail(String animalCode) {
		//매개변수 확인
		logger.debug("animalDetail()메서드 animalCode is {}", animalCode);
		return sqlSessionTemplate.selectOne(nameSpace+"animalDetail", animalCode);
	}
	
	//동물조건검색
	public List<AnimalCommand> selectCategory(Map map) {
		logger.debug("selectCategory()메서드 selectName is {}", map);
		List<AnimalCommand> animalCategory = sqlSessionTemplate.selectList(nameSpace+"selectAnimalcategory", map);
		logger.debug("selectCategory()메서드 animalCategory is {}", animalCategory);
		return animalCategory;
	}
}
