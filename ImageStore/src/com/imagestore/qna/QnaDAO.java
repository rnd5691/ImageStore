package com.imagestore.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.imagestore.util.DBConnector;
import com.imagestore.util.MakeRow;

public class QnaDAO {
	
	public int delete(int qna_seq) throws Exception	{
		Connection con = DBConnector.getConnect();
		
		String sql = "delete qna where qna_seq=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, qna_seq);
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
		
	}
	
	public int update(QnaDTO qnaDTO) throws Exception	{
		Connection con = DBConnector.getConnect();
		
		String sql = "update qna set title=?, contents=? where qna_seq=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, qnaDTO.getTitle());
		st.setString(2, qnaDTO.getContents());
		st.setInt(3, qnaDTO.getQna_seq());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	public int insert(QnaDTO qnaDTO) throws Exception	{
		Connection con = DBConnector.getConnect();
		
		String sql = "insert into qna values(qna_seq.nextval,?,?,?,sysdate,0,qna_seq.currval,0,0)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, qnaDTO.getTitle());
		st.setString(2, qnaDTO.getNickname());
		st.setString(3, qnaDTO.getContents());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	public QnaDTO selectOne(int qna_seq) throws Exception {
		Connection con = DBConnector.getConnect();
		
		String sql = "select * from qna where qna_seq=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, qna_seq);
		ResultSet rs = st.executeQuery();
		QnaDTO qnaDTO = null;
		if(rs.next())	{
			qnaDTO = new QnaDTO();
			qnaDTO.setQna_seq(rs.getInt("qna_seq"));
			qnaDTO.setTitle(rs.getString("title"));
			qnaDTO.setNickname(rs.getString("nickname"));
			qnaDTO.setContents(rs.getString("contents"));
			qnaDTO.setReg_date(rs.getDate("reg_date"));
			qnaDTO.setReply_check(rs.getString("reply_check"));
			qnaDTO.setReply(rs.getString("reply"));
		}
		
		DBConnector.disConnect(rs, st, con);
		return qnaDTO;
	}
	
	public int getTotalCount(String kind, String search) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select count(nvl(qna_seq, 0)) from qna where "+kind+" like ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+search+"%");
		ResultSet rs = st.executeQuery();
		rs.next();
		int result = rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		return result;
	}

	public List<QnaDTO> selectList(MakeRow makeRow, String kind, String search) throws Exception	{
		Connection con = DBConnector.getConnect();
		
		String sql = "select * from "
			+	"(select rownum R, Q.* from "
			+   "(select * from qna where "+kind+" like ? order by ref desc, step asc) Q) "
			+   "where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, "%"+search+"%");
		st.setInt(2, makeRow.getStartRow());
		st.setInt(3, makeRow.getLastRow());
		
		ResultSet rs = st.executeQuery();
		List<QnaDTO> ar = new ArrayList<>();
		while(rs.next())	{
			QnaDTO qnaDTO = new QnaDTO();
			qnaDTO.setQna_seq(rs.getInt("qna_seq"));
			qnaDTO.setTitle(rs.getString("title"));
			qnaDTO.setNickname(rs.getString("nickname"));
			qnaDTO.setContents(rs.getString("contents"));
			qnaDTO.setReg_date(rs.getDate("reg_date"));
			qnaDTO.setReply_check(rs.getString("reply_check"));
			qnaDTO.setReply(rs.getString("reply"));
			ar.add(qnaDTO);
		}
		DBConnector.disConnect(rs, st, con);
		return ar;
		
	}
}
