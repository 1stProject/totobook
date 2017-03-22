package totoBook.store.logic;

import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import totoBook.domain.Member;
import totoBook.store.MemberStore;
import totoBook.store.mapper.MemberMapper;


public class MemberStoreLogic implements MemberStore{

	private SqlSessionFactory factory;
	
	public MemberStoreLogic() {
		factory=SqlSessionFactoryProvider.getSqlSessionFactory();
	}
	@Override
	public void insertMember(Member member) {
		SqlSession session = factory.openSession();
		try{
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			mapper.insertMember(member);
			session.commit();
		}finally{
			session.close();
		}
		
	}

	@Override
	public Member selectMemberById(String memberId) {
		SqlSession session = factory.openSession();
		Member member = null;
		
		try{
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			member = mapper.selectMemberById(memberId);
		}finally{
			session.close();
			
		}
		
		return member;
	}

	@Override
	public Member selectMember(Member member) {
		SqlSession session= factory.openSession();
		member = new Member();
		
		try{
			MemberMapper mapper = session.getMapper(MemberMapper.class);
		}finally{
			session.close();
		}
		return member;
	}

	@Override
	public void updateMember(Member member) {
		SqlSession session = factory.openSession();
		try{
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			mapper.updateMember(member);
			session.commit();
		}finally{
			session.close();
		}
	}

	@Override
	public void deleteMember(String member) {
		SqlSession session = factory.openSession();
		try{
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			mapper.deleteMember(member);
			session.commit();
		}finally{
			session.close();
		}
	}

	@Override
	public List<Member> selectMembersByTel(String memberTel) {
		SqlSession session = factory.openSession();
		List<Member> list =null;
		try{
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			list = mapper.selectMembersByTel(memberTel);
					
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public List<Member> selectMembersByName(String memberName) {
		SqlSession session = factory.openSession();
		List<Member>list = null;
		try{
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			list = mapper.selectMembersByName(memberName);
		}finally{
			session.close();
			
		}
		return list;
	}

	@Override
	public List<Member> selectAllmembers() {
		SqlSession session=factory.openSession();
		List<Member> list=null;
		try{
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			list= mapper.selectAllmembers();
		}finally{
			session.close();
		}
		return list;
	}

}
