package totoBook.service.logic;

import java.util.List;

import totoBook.domain.Member;
import totoBook.service.MemberService;

public class MemberServiceLogic implements MemberService {

	@Override
	public void registerMember(Member member) {
		
	}

	@Override
	public Member findMemberById(String memberId) {
		return null;
	}

	@Override
	public void modifyMember(Member member) {
		
	}

	@Override
	public void removeMember(String member) {
		
	}

	@Override
	public boolean chackId(String memberId) {
		return false;
	}

	@Override
	public boolean checkPw(Member member) {
		return false;
	}

	@Override
	public List<Member> findMembersByTel(String memberTel) {
		return null;
	}

	@Override
	public List<Member> findMembersByName(String memberName) {
		return null;
	}

	@Override
	public List<Member> findAllMembers() {
		return null;
	}

}
