package com.cafe24.iso159.member.service;

import java.util.List;
import java.util.Map;

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
		logger.debug("addMemberCodeNumber() 메서드 member");
		int result = sqlSessionTemplate.selectOne(nameSpace + "selectMemberInfoCodeNumber");
		logger.debug("addMemberCodeNumber() 메서드 result is {}", result);
		return result;
	}

	// 로그인 dao
	public MemberLoginLevel MemberLoginLevel(Member member) {
		logger.debug("MemberLoginLevel(Member member) 메서드 member is {}", member);
		MemberLoginLevel memberLoginLevel = sqlSessionTemplate.selectOne(nameSpace + "selectLoginCheck", member);
		logger.debug("MemberLoginLevel(Member member) 메서드 rsult is {}", memberLoginLevel);
		return memberLoginLevel;
	}

	// member 테이블 전체 리스트 조회 dao
	public List<MemberAndMemberInfo> selectMemberList() {
		// 아이디가 selectMemberList인 쿼리를 실행해 List<Member>형태로 받은후 리턴
		List<MemberAndMemberInfo> list = sqlSessionTemplate.selectList(nameSpace + "selectMemberList");
		// 콘솔창에 리턴 값 출력
		logger.debug("selectMemberList() 메서드 list is {}", list);
		return list;
	}

	// 회원 수정 updateMember 호출 dao
	public void updateMember(Member member) {
		logger.debug("updateMember(Member mId) 메서드 member is {}", member);
		sqlSessionTemplate.update(nameSpace + "updateMember", member);
	}
 
	// 회원 수정 updateMemberInfo 호출 dao
	public void updateMemberInfo(MemberInfo memberInfo) {
		logger.debug("updateMemberInfo (MemberInfo memberInfo) 메서드 memberInfo is {}", memberInfo);
		sqlSessionTemplate.update(nameSpace + "updateMemberInfo", memberInfo);
	}

	// MemberInfo 테이블 컬럼 결과 하나만 조회
	public MemberInfo selectMemberOne(String memberInfoCode) {
		// 매개변수 member 값 확인
		logger.debug("selectMemberOne(Member member) 메서드 memberInfoCode is {}",memberInfoCode);
		// 아이디가 selectMember인 쿼리를 실행해 결과를 Member형태로 받은후 리턴
		MemberInfo memberInfo = sqlSessionTemplate.selectOne(nameSpace + "selectOneMemberInfo", memberInfoCode);
		// 리턴 값 확인
		logger.debug("selectMemberOne(Member member) 메서드 memberInfo is {}",memberInfo);		
		return memberInfo;
	}
	
	// Mapper에 selectOneMemberId 사용 해서 멤버 아이디로  멤버인코드구함
	public String selectMemberOneId(String memberId) {
		logger.debug("selectMemberOneId(String mId) 메서드 memberId is {}", memberId);
		String checkMemberId = sqlSessionTemplate.selectOne(nameSpace + "selectOneMemberId", memberId);
		logger.debug("selectMemberOneId(String memberId) 메서드 memberId is {}", memberId);
		return checkMemberId;	
	}

	// member 회원삭제
	public void updateMemberRight(Map<String, Object> map) {
		// 매개변수 member 값 확인
		logger.debug("memberRemove(Member memberId) 메서드 mId is {}",map);
		// 아이디가 updateMember인 쿼리를 실행해 member필드의 id와 같은 컬럼 삭제
		sqlSessionTemplate.update(nameSpace + "updateMemberRight", map);
	}

	public List<Member> duplication() {
		return null;
	}
}