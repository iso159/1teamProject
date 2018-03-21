package com.cafe24.iso159.member.service;

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

	public Member serviceMemberOne(Member member) {
		logger.debug("getMemberOne(Member member) 메서드 member is {}", member);
		Member getMember = memberDao.selectMemberOne(member);
		return getMember;
	}

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

	public MemberLoginLevel loginCheck(Member member) {
		logger.debug("loginget(Member member, MemberLoginLevel memberloginlevel) 메서드 member is {}", member);
		logger.debug("loginget(Member member, MemberLoginLevel memberloginlevel) 메서드 member is {}", member);
		MemberLoginLevel memberLoginLevel = memberDao.MemberLoginLevel(member);
		return memberLoginLevel;
	}
}
