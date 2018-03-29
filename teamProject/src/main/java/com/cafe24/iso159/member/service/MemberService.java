package com.cafe24.iso159.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

	public void addMember(Member member, MemberInfo memberInfo) {
		logger.debug("addMember(Member member) 메서드 member is {}", member);
		logger.debug("addMember(MemberInfo memberInfo) 메서드 memberInfo is {}", memberInfo);
		// 변수에 지정해서
		String mInfoCode = "m_info_code_";
		String mRightCode = "mr_3_1";
		// dao를 불러와서 +1 시키고 변수에 담음
		int mInfoCodeNumber = memberDao.selectMemberInfoCodeNumber() + 1;
		logger.debug("addMember(MemberInfo memberInfo) 메서드 mInfoCodeNumber is {}", mInfoCodeNumber);
		// 둘을 합친다.
		mInfoCode += mInfoCodeNumber;
		memberInfo.setmInfoCode(mInfoCode);
		logger.debug("addMember(MemberInfo memberInfo) 메서드 memberInfo is {}", memberInfo);
		memberDao.addMemberInfo(memberInfo);
		member.setmInfoCode(mInfoCode);
		member.setmRightCode(mRightCode);
		memberDao.addMember(member);
	}
	//회원 로그인 체크
	public MemberLoginLevel loginCheck(Member member) {
		logger.debug("loginget(Member member, MemberLoginLevel memberloginlevel) 메서드 member is {}", member);
		logger.debug("loginget(Member member, MemberLoginLevel memberloginlevel) 메서드 member is {}", member);
		MemberLoginLevel memberLoginLevel = memberDao.MemberLoginLevel(member);
		return memberLoginLevel;
	}
	
	// 상품 리스트 전체 조회
	public List<MemberAndMemberInfo> getMemberList() {
		// 전체 회원 조회 메서드 호출 후 리턴
		logger.debug("getMemberList() 메서드 호출");
		List<MemberAndMemberInfo> list = memberDao.selectMemberList();
		logger.debug("getMemberList() 메서드 호출 끝");
		logger.debug("getMemberList() 메서드 list is {}", list);
		// 리턴받은 리스트 출력
		return list;
	}

	// 회원 정보 수정 member service
	public void updateMemberInfo(Member member, MemberInfo memberInfo) {
		// 매개변수 member 값 확인
		logger.debug("updateMemberInfo(Member member, MemberInfo memberInfo) 메서드 member is {}", member);
		memberDao.updateMember(member);
		logger.debug("updateMemberInfo(Member member, MemberInfo memberInfo) 메서드 memberInfo is {}", memberInfo);
		memberDao.updateMemberInfo(memberInfo);
	}
	 
	// 회원 1명 조회
	public MemberInfo getMemberOne(String mLoginId) {
		// 매개변수 member 값 확인
		logger.debug("getMemberOne(Member member) 메서드 mLoginId is {}",mLoginId);
		String memberInfoCode = memberDao.selectMemberOneId(mLoginId);
		MemberInfo memberInfo = memberDao.selectMemberOne(memberInfoCode);
		// 리턴값 확인
		logger.debug("getMemberOne(Member member) 메서드 memberInfo is {}",memberInfo);
		return memberInfo;
	}
	// member 테이블 삭제
		public void removeMember(String memberId) {
			logger.debug("removeMember(String mId) 메서드 mId is {}",memberId);
			final String mRightCode = "mr_3_3";
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("mRightCode", mRightCode);
			map.put("mId", memberId);
			logger.debug("removeMember(String mId) 메서드 map is {}",map);
			memberDao.updateMemberRight(map);
		}
}
