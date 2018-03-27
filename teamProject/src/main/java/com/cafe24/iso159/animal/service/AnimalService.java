package com.cafe24.iso159.animal.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.iso159.shelter.service.BusinessLicense;

@Service
@Transactional
public class AnimalService {

	@Autowired
	private AnimalDao animaldao;
	
	private static final Logger logger = LoggerFactory.getLogger(AnimalService.class);
	//동물등록
	public void addAnimal(Animal animal, String mShelterId, String blCode){
		logger.debug("addAnimal()메서드 Animal is {}",animal);
		//m_shelterId셋팅
		animal.setmShelterId(mShelterId);
		//bl_code 셋팅
		animal.setBlCode(blCode);	
		animaldao.insertAnimal(animal);
		//bl_code로 보호소 이름조회
		BusinessLicense shelterName = animaldao.selectShelterName(blCode);
		logger.debug("shelterName is{}", shelterName);
	}
	//동물리스트
	public List<Animal> listAnimal() {
		logger.debug("listAnimal()메서드 호출");
		List<Animal> AnimalList = animaldao.selectAnimalList();
		
		return AnimalList;
	}
}
