package com.imagestore.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.imagestore.util.DBConnector;

public class MemberDAO {
	//회원 번호 가져오기
	public int searchUserNum(MemberDTO memberDTO, Connection con) throws Exception{
		String sql = "select user_num from user_info where id=? and pw=? and kind=?";

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getKind());
		
		ResultSet rs = st.executeQuery();
		int user_num = 0;
		if(rs.next()){
			user_num = rs.getInt("user_num");
		}
		
		return user_num;
	}
	//회원가입 정보 넣기(공통정보)
	public int insert(MemberDTO memberDTO, Connection con) throws Exception{
		String sql = "insert into user_info values(user_num.nextval,?,?,?,?,'N','NULL',?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getPhone());
		st.setString(4, memberDTO.getEmail());
		st.setString(5, memberDTO.getKind());
		
		int result = st.executeUpdate();
		
		st.close();
		
		return result;
	}
	
	//회원가입 ID 중복확인
	public boolean checkId(String id) throws Exception{
		boolean check = true;
		Connection con = DBConnector.getConnect();
		
		String sql = "select * from user_info where id=? and session_check='false'";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()){
			check = false;
		}
		
		DBConnector.disConnect(rs, st, con);
		return check;
	}
}
