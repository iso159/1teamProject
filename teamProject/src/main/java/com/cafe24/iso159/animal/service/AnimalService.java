package com.cafe24.iso159.animal.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		
	}
	//동물리스트
	public List<AnimalCommand> listAnimal() {
		logger.debug("listAnimal()메서드 호출");
		List<AnimalCommand> AnimalList = animaldao.selectAnimalList();
		
		return AnimalList;
	}
	
	//동물삭제
	public void removeAnimal(String animalCode) {
		logger.debug("deleteAnimal()메서드 animalId is {}", animalCode);
		animaldao.deleteAnimal(animalCode);
	}
	//동물리스트 수정
	public void modifyAnimal(Animal animal) {
		
		logger.debug("modifyAnimal()메서드 animal is {}", animal);
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
}
