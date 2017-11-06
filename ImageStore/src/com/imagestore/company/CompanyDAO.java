package com.imagestore.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.imagestore.util.DBConnector;

public class CompanyDAO {
	//업로드 부분
	public int update(CompanyDTO companyDTO, Connection con) throws Exception{
		String sql = "update company set company_name=?, company_num=?, company_phone=? where user_num=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, companyDTO.getCompany_name());
		st.setString(2, companyDTO.getCompany_num());
		st.setString(3, companyDTO.getCompany_phone());
		st.setInt(4, companyDTO.getUser_num());
		
		int result = st.executeUpdate();
		
		st.close();
		
		return result;
	}
	public CompanyDTO selectOne(int user_num) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select * from company where user_num=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, user_num);
		
		ResultSet rs = st.executeQuery();
		CompanyDTO companyDTO = null;
		if(rs.next()){
			companyDTO = new CompanyDTO();
			companyDTO.setUser_num(user_num);
			companyDTO.setCompany_name(rs.getString("company_name"));
			companyDTO.setCompany_num(rs.getString("company_num"));
			companyDTO.setCompany_phone(rs.getString("company_phone"));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return companyDTO;
	}
	public int insert(CompanyDTO companyDTO, Connection con) throws Exception{
		//company_name,user_num,company_num,company_phone
		String sql = "insert into company values(?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, companyDTO.getCompany_name());
		st.setInt(2, companyDTO.getUser_num());
		st.setString(3, companyDTO.getCompany_num());
		st.setString(4, companyDTO.getCompany_phone());
	
		int result = st.executeUpdate();
		
		st.close();
		
		return result;
	}
}
