package com.imagestore.person;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PersonDAO {
	public int insert(PersonDTO personDTO, Connection con) throws Exception{
		String sql = "insert into person values(?, ?, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, personDTO.getNickName());
		st.setInt(2, personDTO.getUser_num());
		st.setString(3, personDTO.getName());
		st.setDate(4, personDTO.getBirth());
		st.setString(5, personDTO.getArtist());
		
		int result = st.executeUpdate();
		
		return result;
	}
}
