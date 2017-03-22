package totoBook.service;

import java.util.List;

import totoBook.domain.Member;

/**
 * @author
 * @version 1.0
 */
public interface MemberService {

	void registerMember(Member member);
	Member findMemberById(String memberId);
	void modifyMember(Member member);
	void removeMember(String member);
	boolean checkId(String memberId);
	boolean checkPw(Member member);
	List<Member> findMembersByTel(String memberTel);
	List<Member> findMembersByName(String memberName);
	List<Member> findAllMembers();
	boolean findMember(Member member);
	
	
	
}
