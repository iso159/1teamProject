package com.cafe24.iso159.animal.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.iso159.member.service.Member;
import com.cafe24.iso159.shelter.service.BusinessLicense;

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
	public List<Animal> selectAnimalList(){
		
		logger.debug("selectAnimalList()메서드 호출");
		List<Animal> AnimalList = sqlSessionTemplate.selectList(nameSpace+"selectAnimalList");
		logger.debug("AnimalList is {}", AnimalList);
		return AnimalList;
	}
	//mShelterId로 보호소 통합관리코드 조회
	public List<BusinessLicense> selectShelterName(String mId) {
		
		logger.debug("selectShelterName()메서드 호출");
		List<BusinessLicense> shelterlist = sqlSessionTemplate.selectList(nameSpace+"selectShelterName");
		return shelterlist;
	}
}