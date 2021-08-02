package com.xio.exam.demo.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xio.exam.demo.vo.Member;

@Mapper
public interface MemberRepository {
	@Insert("""
			insert into `member`
			set regDate = now(),
			updateDate = now(),
			loginId = #{loginId},
			loginPw = #{loginPw},
			name = #{name},
			nickname = #{nickname},
			cellphoneNo = #{cellphoneNo},
			email = #{email}
			""")
	public void join(@Param("loginId") String loginId, @Param("loginPw") String loginPw, @Param("name") String name,
			@Param("nickname") String nickname,@Param("cellphoneNo")  String cellphoneNo,@Param("email")  String email);
	
	@Select("""
			select last_insert_id()
			""")
	public int getLastInsertId();
	
	@Select("""
			select * from `member`
			where id = #{id}
			""")
	public Member getMemberById(int id);
}
