package com.cafe24.iso159.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private final String nameSpace = "com.cafe24.iso159.member.service.MemberMapper.";

	// 회원가입 member dao
	public void addMember(Member member) {
		logger.debug("addMember(Member member) 메서드member is {}", member);
		sqlSessionTemplate.insert(nameSpace + "addMember", member);
	}

	// 회원관리 정보 memberinfo dao
	public void addMemberInfo(MemberInfo memberInfo) {
		logger.debug("addInfoMember(MemberInfo memberinfo) 메서드 memberinfo is {}", memberInfo);
		sqlSessionTemplate.insert(nameSpace + "addMemberInfo", memberInfo);
	}

	// m_code 만들기위해 호출 dao
	public int selectMemberInfoCodeNumber() {
		logger.debug("addMemberCodeNumber(int member) 메서드 member");
		int result = sqlSessionTemplate.selectOne(nameSpace + "selectMemberInfoCodeNumber");
		logger.debug("addMemberCodeNumber(int member) 메서드 result is {}", result);
		return result;
	}

	// 회원 정보 한개 조회 dao
	public Member selectMemberOne(Member member) {
		logger.debug("selectMemberOne(Member member) 메서드 member is {}", member);
		return sqlSessionTemplate.selectOne(nameSpace + "selectMemberOne", member);
	}

	// 로그인 메서드
	public MemberLoginLevel MemberLoginLevel(Member member){
		logger.debug("MemberLoginLevel(Member member) 메서드 member is {}", member);
		MemberLoginLevel memberLoginLevel = sqlSessionTemplate.selectOne(nameSpace + "selectLoginCheck",member);
		logger.debug("MemberLoginLevel(Member member) 메서드 rsult is {}", memberLoginLevel);
		return memberLoginLevel;
	}
}