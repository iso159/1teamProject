package com.cafe24.iso159.animal.service;

import java.util.List;

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
	//동물등록
	public int insertAnimal(Animal animal) {
		
		logger.debug("insertAnimal()메서드 animal is {}", animal);		
		return sqlSessionTemplate.insert(nameSpace+"insertAnimal", animal); 
	}
	//동물 리스트 조회
	public List<AnimalCommand> selectAnimalList(){
		logger.debug("selectAnimalList()메서드 호출");
		List<AnimalCommand> AnimalList = sqlSessionTemplate.selectList(nameSpace+"selectAnimalList");
		logger.debug("AnimalList is {}", AnimalList);
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
}
