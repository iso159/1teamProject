package com.cafe24.iso159.jindan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.iso159.service.common.OverallStatus;
import com.cafe24.iso159.shelter.service.ShelterDao;

@Service
public class JindanService {
	@Autowired
	private JindanDAO jindanDAO;
	private static final Logger logger = LoggerFactory.getLogger(JindanService.class);
	
	// 진단 목록 종류를 조회하기위해 selectJindanOs DAO 메서드 호출후 리턴값을 map에 매핑하는 서비스 메서드
	public Map<String,Object> getJindanOs(){
		logger.debug("getJindanOs() 메서드 호출");
		// 여러 객체를 담기위해 map 사용
		Map<String,Object> map = new HashMap<String, Object>();
		
		String osLarge = "일반상태";
		List<OverallStatus> general = jindanDAO.selectJindanOs(osLarge);
		logger.debug("getJindanOs() 메서드 general is {}", general);	
		map.put("general", general);
		
		osLarge = "피부상태";
		List<OverallStatus> skin = jindanDAO.selectJindanOs(osLarge);
		logger.debug("getJindanOs() 메서드 skin is {}", skin);
		map.put("skin",skin);
		
		osLarge = "눈";
		List<OverallStatus> eyes = jindanDAO.selectJindanOs(osLarge);
		logger.debug("getJindanOs() 메서드 eyes is {}", eyes);
		map.put("eyes",eyes);
		
		osLarge = "귀";
		List<OverallStatus> ears = jindanDAO.selectJindanOs(osLarge);
		logger.debug("getJindanOs() 메서드 ears is {}", ears);
		map.put("ears",ears);
		
		osLarge = "코";
		List<OverallStatus> nose = jindanDAO.selectJindanOs(osLarge);
		logger.debug("getJindanOs() 메서드 nose is {}", nose);
		map.put("nose",nose);
		
		osLarge = "상태 이상 유무";
		List<OverallStatus> isang = jindanDAO.selectJindanOs(osLarge);
		logger.debug("getJindanOs() 메서드 isang is {}", isang);
		map.put("isang",isang);
		
		logger.debug("getJindanOs() 메서드 끝");
		return map;
	}
}
