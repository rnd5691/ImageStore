package com.imagestore.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.imagestore.util.DBConnector;

public class MemberDAO {
	
	//수정 정보 업로드
	public int update(MemberDTO memberDTO, Connection con) throws Exception{
		String sql = "update user_info set pw=?, phone=?, email=? where user_num=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getPw());
		st.setString(2, memberDTO.getPhone());
		st.setString(3, memberDTO.getEmail());
		st.setInt(4, memberDTO.getUser_num());
		
		int result = st.executeUpdate();
		
		st.close();
		
		return result;
	}
	//로그인을 위한 회원 정보 조회
	public MemberDTO selectOne(MemberDTO memberDTO) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select * from user_info where id=? and pw=? and kind=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getKind());
		
		ResultSet rs = st.executeQuery();
			
		if(rs.next()) {
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setPhone(rs.getString("phone"));
			memberDTO.setToken(rs.getString("token"));
			memberDTO.setUser_num(rs.getInt("user_num"));
		}else {
			memberDTO = null;
		}
		DBConnector.disConnect(rs, st, con);
			
		return memberDTO;
			
	}
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
		
		String sql = "select * from user_info where id=? and session_check='N'";
		
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
