package com.imagestore.work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.imagestore.util.DBConnector;
import com.imagestore.util.MakeRow;

public class WorkDAO {
	
	//총 수익금액 계산 메소드
	public int totalMoney(int user_num) throws Exception	{
		Connection con = DBConnector.getConnect();
		
		String sql = "select sum(download_hit*price) from work_info where user_num=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, user_num);
		ResultSet rs = st.executeQuery();
		rs.next();
		
		int result = rs.getInt(1);
		
		DBConnector.disConnect(rs, st, con);
		
		return result;
		
	}
	
	//판매 작품 총 갯수 구하는 메소드
	public int workTotalCount(int user_num) throws Exception	{
		Connection con = DBConnector.getConnect();
		
		String sql = "select count(*) from work_info where user_num=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, user_num);
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		int result = rs.getInt(1);
		
		DBConnector.disConnect(rs, st, con);
		
		return result;
		
	}
	
	public int update(WorkDTO workDTO) throws Exception	{
		Connection con = DBConnector.getConnect();
		
		String sql = "update work_info set work=?, work_date=?, price=?, contents=?, tag=? where work_seq=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, workDTO.getWork());
		st.setDate(2, workDTO.getWork_date());
		st.setInt(3, workDTO.getPrice());
		st.setString(4, workDTO.getContents());
		st.setString(5, workDTO.getTag());
		st.setInt(6, workDTO.getWork_seq());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
		
	}
	
	public WorkDTO selectOne(int work_seq) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select * from work_info where work_seq=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, work_seq);
		
		ResultSet rs = st.executeQuery();
		WorkDTO workDTO = null;
		if(rs.next()){
			workDTO = new WorkDTO();
			workDTO.setWork(rs.getString("work"));
			workDTO.setUser_num(rs.getInt("user_num"));
			workDTO.setNickname(rs.getString("nickname"));
			workDTO.setFile_num(rs.getInt("file_num"));
			workDTO.setWork_seq(work_seq);
			workDTO.setWork_date(rs.getDate("work_date"));
			workDTO.setUpload_check(rs.getString("upload_check"));
			workDTO.setTag(rs.getString("tag"));
			workDTO.setPrice(rs.getInt("price"));
			workDTO.setContents(rs.getString("contents"));
			workDTO.setReply(rs.getString("reply"));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return workDTO;
	}
	
	public List<WorkDTO> selectList(int user_num, MakeRow makeRow) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select * from (select rownum R, Q.* from (select * from work_info where user_num=? order by work_seq desc) Q) where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, user_num);
		st.setInt(2, makeRow.getStartRow());
		st.setInt(3, makeRow.getLastRow());
		
		ResultSet rs = st.executeQuery();
		
		List<WorkDTO> ar = new ArrayList<>();
		int a = 0;
		while(rs.next()){
			WorkDTO workDTO = new WorkDTO();
			workDTO.setWork_seq(rs.getInt("work_seq"));
			workDTO.setWork(rs.getString("work"));
			workDTO.setNickname(rs.getString("nickname"));
			workDTO.setWork_date(rs.getDate("work_date"));
			workDTO.setUpload_check(rs.getString("upload_check"));
			workDTO.setFile_num(rs.getInt("file_num"));
			workDTO.setTag(rs.getString("tag"));
			workDTO.setPrice(rs.getInt("price"));
			workDTO.setContents(rs.getString("contents"));
			workDTO.setReply(rs.getString("reply"));
			workDTO.setSell(rs.getString("sell"));
			workDTO.setDownload_hit(rs.getInt("download_hit"));
						
			ar.add(workDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return ar;
	}
	
	public int getTotalCount() throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select count(nvl(work_seq, 0)) from work_info";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		rs.next();
		int result = rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		
		return result;
	}
	
	//총 내 작품에 쓰이는 토탈카운트 메소드
	public int getTotalCount(int user_num) throws Exception	{
		Connection con = DBConnector.getConnect();
		String sql = "select count(nvl(work_seq, 0)) from work_info where user_num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, user_num);
		ResultSet rs = st.executeQuery();
		rs.next();
		int result = rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		
		return result;
	}
}
