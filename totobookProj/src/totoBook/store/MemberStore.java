package totoBook.store;

import java.util.List;

import totoBook.domain.Member;

/**
 * @author
 * @version 1.0
 */
public interface MemberStore {

	void insertMember(Member member);
	Member selectMemberById(String memberId);
	Member selectMember(Member member);
	void updateMember(Member member);
	void deleteMember(String member);
	List<Member> selectMembersByTel(String memberTel);
	List<Member> selectMembersByName(String memberName);
	List<Member> selectAllmembers();
}
