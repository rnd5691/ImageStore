package com.imagestore.file;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imagestore.util.DBConnector;
import com.imagestore.work.WorkDTO;

public class FileDAO {
	
	//salesReuqestViewDelete
	public void salesRequestViewDelete(int work_seq, Connection con) throws Exception {
		String sql = "DELETE file_table WHERE work_seq=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, work_seq);
		st.executeUpdate();
		st.close();
	}
	
	//salesRequestViewUpdate
	public int salesRequestViewUpdate(FileDTO fileDTO, Connection con) throws Exception {
		String sql = "UPDATE file_table SET file_route=?, width=?, height=?, file_name=? WHERE work_seq=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, fileDTO.getFile_route());
		st.setString(2, fileDTO.getWidth());
		st.setString(3, fileDTO.getHeight());
		st.setString(4, fileDTO.getFile_name());
		st.setInt(5, fileDTO.getWork_seq());
		int result = st.executeUpdate();
		st.close();
		return result;
	}
	
	//부모의 work_seq로 file_table 모든 정보 가져오기
	public FileDTO selectOne(int work_seq, Connection con) throws Exception{
		String sql = "select * from file_table where work_seq=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, work_seq);
		
		ResultSet rs = st.executeQuery();
		FileDTO fileDTO = null;
		if(rs.next()){
			fileDTO = new FileDTO();
			fileDTO.setFile_num(rs.getInt("file_num"));
			fileDTO.setFile_route(rs.getString("file_route"));
			fileDTO.setFile_name(rs.getString("file_name"));
			fileDTO.setWidth(rs.getString("width"));
			fileDTO.setHeight(rs.getString("height"));
		}
		rs.close();
		st.close();
		return fileDTO;
	}
	
	//fileUpload
		public int fileUpload(HttpServletRequest request, HttpServletResponse response, FileDTO fileDTO,Connection con) throws Exception {
			String sql = "INSERT INTO file_table VALUES(file_num.nextval,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, fileDTO.getWork_seq());
			st.setString(2, fileDTO.getFile_route());
			st.setString(3, fileDTO.getFile_name());
			st.setString(4, fileDTO.getWidth());
			st.setString(5, fileDTO.getHeight());
			int result = st.executeUpdate();
			st.close();
			return result;
		}
	
}
