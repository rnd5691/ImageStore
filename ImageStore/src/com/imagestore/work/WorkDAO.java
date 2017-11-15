package com.imagestore.work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.imagestore.file.FileDTO;
import com.imagestore.util.DBConnector;
import com.imagestore.util.MakeRow;

public class WorkDAO {
	//관리자 승인시 업데이트
	public int approvalUpdate(int work_seq) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "update work_info set upload_check='승인', sell='Y' where work_seq=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, work_seq);
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}
	//관리자 거부시 업데이트
	public int replyUpdate(WorkDTO workDTO) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "update work_info set reply=?, upload_check='거부' where work_seq=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, workDTO.getReply());
		st.setInt(2, workDTO.getWork_seq());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}
	//salesReuqestViewDelete
	public void salesRequestViewDelete(int work_seq, Connection con) throws Exception {
			String sql = "DELETE work_info WHERE work_seq=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, work_seq);
			st.executeUpdate();
			st.close();
	}
	
	//viewUpdate
	public int salesViewUpdate(WorkDTO workDTO, Connection con) throws Exception {
		String sql = "UPDATE work_info SET work=?, work_date=sysdate, tag=?, price=?, contents=?, upload_check='대기중', reply=null WHERE work_seq=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, workDTO.getWork());
		st.setString(2, workDTO.getTag());
		st.setInt(3, workDTO.getPrice());
		st.setString(4, workDTO.getContents());
		st.setInt(5, workDTO.getWork_seq());
		int result = st.executeUpdate();
		st.close();
		return result;
	}
	
	public String searchWork(int work_seq) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select work from work_info where work_seq=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, work_seq);
		ResultSet rs = st.executeQuery();
		
		String work = null;
		if(rs.next()){
			work = rs.getString("work");
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return work;
		
	}
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
		
		String sql = "select count(*) from work_info where user_num=? and upload_check='승인'";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, user_num);
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		int result = rs.getInt(1);
		
		DBConnector.disConnect(rs, st, con);
		
		return result;
		
	}
	
	//태그에 해당하는 값만 가져와!
		public List<FileDTO> seachWorkSEQ(Connection con, String tag) throws Exception {
			String sql = "SELECT rownum ,f.* FROM FILE_TABLE f WHERE work_seq IN (SELECT w.work_seq FROM work_info w WHERE tag LIKE '%"+tag+"%') ORDER BY rownum desc";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			List<FileDTO> ar = new ArrayList<>();
			FileDTO fileDTO = null;
			while(rs.next()) {
				fileDTO = new FileDTO();
				fileDTO.setWork_seq(rs.getInt("work_seq"));
				fileDTO.setFile_name(rs.getString("file_name"));
				fileDTO.setFile_kind(rs.getString("file_kind"));
				ar.add(fileDTO);
			}
			rs.close();
			st.close();
			return ar;
		}
		//모든정보 가져와!
		public List<WorkDTO> selectAll(Connection con) throws Exception {
			String sql = "SELECT * FROM work_info";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			List<WorkDTO> ar = new ArrayList<>();
			WorkDTO workDTO = null;
			while(rs.next()) {
				workDTO = new WorkDTO();
				workDTO.setWork(rs.getString("work"));
				workDTO.setUser_num(rs.getInt("user_num"));
				workDTO.setNickname(rs.getString("nickname"));
				workDTO.setWork_seq(rs.getInt("work_seq"));
				workDTO.setWork_date(rs.getDate("work_date"));
				workDTO.setUpload_check(rs.getString("upload_check"));
				workDTO.setTag(rs.getString("tag"));
				workDTO.setPrice(rs.getInt("price"));
				workDTO.setContents(rs.getString("contents"));
				workDTO.setReply(rs.getString("reply"));
				ar.add(workDTO);
			}
			rs.close();
			st.close();
			return ar;
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
	
	public WorkDTO selectOne(int work_seq, Connection con) throws Exception{
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
			workDTO.setWork_seq(rs.getInt("work_seq"));
			workDTO.setWork_date(rs.getDate("work_date"));
			workDTO.setUpload_check(rs.getString("upload_check"));
			workDTO.setTag(rs.getString("tag"));
			workDTO.setPrice(rs.getInt("price"));
			workDTO.setContents(rs.getString("contents"));
			workDTO.setReply(rs.getString("reply"));
		}
		
		rs.close();
		st.close();
		
		return workDTO;
	}
	public List<WorkDTO> adminSelectList(MakeRow makeRow) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select * from "
				+	"(select rownum R, Q.* from "
				+   "(select * from work_info where upload_check='대기중' order by work_seq desc) Q) "
				+   "where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, makeRow.getStartRow());
		st.setInt(2, makeRow.getLastRow());
		
		ResultSet rs = st.executeQuery();
		List<WorkDTO> ar = new ArrayList<>();
		while(rs.next()){
			WorkDTO workDTO = new WorkDTO();
			workDTO.setWork_seq(rs.getInt("work_seq"));
			workDTO.setWork(rs.getString("work"));
			workDTO.setNickname(rs.getString("nickname"));
			workDTO.setWork_date(rs.getDate("work_date"));
			workDTO.setUpload_check(rs.getString("upload_check"));
			workDTO.setDownload_hit(rs.getInt("download_hit"));
			workDTO.setPrice(rs.getInt("price"));
			
			ar.add(workDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return ar;
	}
	
	public List<WorkDTO> MoneySelectList(int user_num, MakeRow makeRow) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select * from "
				+	"(select rownum R, Q.* from "
				+   "(select * from work_info where user_num=? and upload_check='승인' order by work_seq desc) Q) "
				+   "where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, user_num);
		st.setInt(2, makeRow.getStartRow());
		st.setInt(3, makeRow.getLastRow());
		
		ResultSet rs = st.executeQuery();
		List<WorkDTO> ar = new ArrayList<>();
		while(rs.next()){
			WorkDTO workDTO = new WorkDTO();
			workDTO.setWork_seq(rs.getInt("work_seq"));
			workDTO.setWork(rs.getString("work"));
			workDTO.setNickname(rs.getString("nickname"));
			workDTO.setWork_date(rs.getDate("work_date"));
			workDTO.setUpload_check(rs.getString("upload_check"));
			workDTO.setDownload_hit(rs.getInt("download_hit"));
			workDTO.setPrice(rs.getInt("price"));
			
			ar.add(workDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return ar;
	}
	
	public List<WorkDTO> selectList(int user_num, MakeRow makeRow) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select * from "
				+	"(select rownum R, Q.* from "
				+   "(select * from work_info where user_num=? order by work_seq desc) Q) "
				+   "where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, user_num);
		st.setInt(2, makeRow.getStartRow());
		st.setInt(3, makeRow.getLastRow());
		
		ResultSet rs = st.executeQuery();
		List<WorkDTO> ar = new ArrayList<>();
		while(rs.next()){
			WorkDTO workDTO = new WorkDTO();
			workDTO.setWork_seq(rs.getInt("work_seq"));
			workDTO.setWork(rs.getString("work"));
			workDTO.setNickname(rs.getString("nickname"));
			workDTO.setWork_date(rs.getDate("work_date"));
			workDTO.setUpload_check(rs.getString("upload_check"));
			workDTO.setDownload_hit(rs.getInt("download_hit"));
			workDTO.setPrice(rs.getInt("price"));
			
			ar.add(workDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return ar;
	}
	
	/*public int getTotalCount() throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select count(nvl(work_seq, 0)) from work_info";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		rs.next();
		int result = rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		
		return result;
	}*/
	//관리자 작품승인요청에 사용될 totalCount
	public int getTotalCount() throws Exception	{
		Connection con = DBConnector.getConnect();
		String sql = "select count(nvl(work_seq, 0)) from work_info where upload_check='대기중'";
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		rs.next();
		int result = rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		
		return result;
	}
	//수익현황에 사용될 totalCount
	public int getTotalCount(int user_num, String check) throws Exception	{
		Connection con = DBConnector.getConnect();
		String sql = "select count(nvl(work_seq, 0)) from work_info where user_num=? and upload_check=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, user_num);
		st.setString(2, check);
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
	
	public int insert(WorkDTO workDTO,Connection con) throws Exception {
		String sql = "INSERT INTO work_info VALUES(?,?,?,?,sysdate,?,?,?,?,?,?,0)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, workDTO.getWork_seq());
		st.setString(2, workDTO.getWork());
		st.setInt(3, workDTO.getUser_num());
		st.setString(4, workDTO.getNickname());
		st.setString(5, workDTO.getUpload_check());
		st.setString(6, workDTO.getTag());
		st.setInt(7, workDTO.getPrice());
		st.setString(8, workDTO.getContents());
		st.setString(9, workDTO.getReply());
		st.setString(10, workDTO.getSell());
		int result = st.executeUpdate();
		st.close();
		return result;
	}
	
	//work_seq 찾기
		 public int fileNumSelect(Connection con) throws Exception {
			 String sql = "SELECT work_seq.nextval work_seq from dual";
			 PreparedStatement st = con.prepareStatement(sql);
			 ResultSet rs = st.executeQuery();
			 int work_seq = 0;
			 if(rs.next()) {
				work_seq = rs.getInt("work_seq");
			 }
			 rs.close();
			 st.close();
			 return work_seq;
		 }
}
