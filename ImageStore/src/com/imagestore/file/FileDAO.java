package com.imagestore.file;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imagestore.util.DBConnector;

public class FileDAO {
	
	//현재 판매 중인 내 작품 에 쓰이는 토탈메소드
	public int getTotalCount(int user_num, String file_kind) throws Exception	{
		Connection con = DBConnector.getConnect();
		String sql = "select count(*) from file_table f, work_info w where f.work_seq=w.work_seq and f.file_kind=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, file_kind);
		ResultSet rs = st.executeQuery();
		rs.next();
		
		int result = rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		
		return result;
	}

//현재 판매중인 내 작품 이미지 조회 메소드
	public List<FileDTO> selectNow(int user_num, String file_kind) throws Exception	{
		Connection con = DBConnector.getConnect();
		String sql = "select f.file_num, f.work_seq, f.file_name,f.file_kind, w.user_num, w.sell from work_info w, file_table f where f.work_seq=w.work_seq and user_num=? and w.upload_check='승인' and file_kind='image'";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, user_num);
		
		ResultSet rs = st.executeQuery();
		List<FileDTO> ar = new ArrayList<>();
		FileDTO fileDTO = null;
		while(rs.next())	{
			fileDTO = new FileDTO();
			fileDTO.setFile_num(rs.getInt("file_num"));
			fileDTO.setWork_seq(rs.getInt("work_seq"));
			fileDTO.setFile_name(rs.getString("file_name"));
			fileDTO.setUser_num(rs.getInt("user_num"));
			fileDTO.setFile_kind(rs.getString("file_kind"));
			fileDTO.setSell(rs.getString("sell"));
			ar.add(fileDTO);
		}
		DBConnector.disConnect(rs, st, con);
		return ar;
	}

//현재 판매중인 내 작품 비디오 조회 메소드
public List<FileDTO> selectNow2(int user_num, String file_kind) throws Exception	{
Connection con = DBConnector.getConnect();
String sql = "select f.file_num, f.work_seq, f.file_name,f.file_kind, w.user_num, w.sell from work_info w, file_table f where f.work_seq=w.work_seq and w.user_num=? and w.upload_check='승인' and f.file_kind='video'";
PreparedStatement st = con.prepareStatement(sql);

st.setInt(1, user_num);

ResultSet rs = st.executeQuery();

List<FileDTO> ar1 = new ArrayList<>();
FileDTO fileDTO = null;
while(rs.next())	{
	fileDTO = new FileDTO();
	fileDTO.setFile_num(rs.getInt("file_num"));
	fileDTO.setWork_seq(rs.getInt("work_seq"));
	fileDTO.setFile_name(rs.getString("file_name"));
	fileDTO.setUser_num(rs.getInt("user_num"));
	fileDTO.setFile_kind(rs.getString("file_kind"));
	fileDTO.setSell(rs.getString("sell"));
	ar1.add(fileDTO);
}

DBConnector.disConnect(rs, st, con);
return ar1;
}
	
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
			fileDTO.setFile_kind(rs.getString("file_kind"));
			fileDTO.setWork_seq(work_seq);
		}
		rs.close();
		st.close();
		return fileDTO;
	}
	
	//fileUpload
		public int fileUpload(HttpServletRequest request, HttpServletResponse response, FileDTO fileDTO,Connection con) throws Exception {
			String sql = "INSERT INTO file_table VALUES(file_num.nextval,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, fileDTO.getWork_seq());
			st.setString(2, fileDTO.getFile_route());
			st.setString(3, fileDTO.getFile_name());
			st.setString(4, fileDTO.getWidth());
			st.setString(5, fileDTO.getHeight());
			st.setString(6, fileDTO.getFile_kind());
			int result = st.executeUpdate();
			st.close();
			return result;
		}
	
}
