package totoBook.service.logic;

import java.util.List;

import javax.servlet.http.HttpSession;

import totoBook.domain.Member;
import totoBook.service.MemberService;
import totoBook.store.MemberStore;
import totoBook.store.logic.MemberStoreLogic;

/**
 * @author
 * @version 1.0
 */
public class MemberServiceLogic implements MemberService {
	
	private MemberStore memberStore;
	
	public MemberServiceLogic() {
		
		memberStore = new MemberStoreLogic();
	}

	@Override
	public void registerMember(Member member) {
		
		memberStore.insertMember(member);
	}

	@Override
	public Member findMemberById(String memberId) {
		return memberStore.selectMemberById(memberId);
	}

	@Override
	public void modifyMember(Member member) {
		memberStore.updateMember(member);
	}

	@Override
	public void removeMember(String member) {

		
		
		memberStore.deleteMember(member);
	}

	@Override
	public boolean checkId(String memberId) {
		
		Member result= memberStore.selectMemberById(memberId);
		if(result != null){
			return true;
		}else{
		
		return false;
		}
	}

	@Override
	public boolean checkPw(Member member) {
		
		Member result= memberStore.selectMember(member);
		if(result != null){
			return true;
		}else{
		
		return false;
		}
	}

	@Override
	public List<Member> findMembersByTel(String memberTel) {
		return memberStore.selectMembersByTel(memberTel);
	}

	@Override
	public List<Member> findMembersByName(String memberName) {
		return memberStore.selectMembersByName(memberName);
	}

	@Override
	public List<Member> findAllMembers() {
		return memberStore.selectAllmembers();
	}

	@Override
	public boolean findMember(Member member) {
		Member searchedMember = new Member();
		searchedMember = memberStore.selectMember(member);
			 if(searchedMember!=null && searchedMember.getPassword().equals(member.getPassword())) {
		
				 return true;
				}else{
		return false;
	}
	}
}