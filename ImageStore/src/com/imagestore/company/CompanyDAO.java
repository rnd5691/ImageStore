package com.imagestore.company;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CompanyDAO {
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
