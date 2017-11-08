package com.imagestore.file;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.imagestore.util.DBConnector;

public class FileDAO {
	public FileDTO selectOne(int file_num) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select * from file_table where file_num=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, file_num);
		
		ResultSet rs = st.executeQuery();
		FileDTO fileDTO = null;
		if(rs.next()){
			fileDTO = new FileDTO();
			fileDTO.setFile_num(file_num);
			fileDTO.setFile_route(rs.getString("file_route"));
			fileDTO.setWidth(rs.getString("width"));
			fileDTO.setHeight(rs.getString("height"));
			fileDTO.setFile_name(rs.getString("file_name"));
		}
		DBConnector.disConnect(rs, st, con);
		return fileDTO;
	}
}
