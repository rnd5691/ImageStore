package com.imagestore.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.imagestore.util.DBConnector;
import com.imagestore.util.MakeRow;

public class QnaDAO {
	
	public int update(QnaDTO qnaDTO) throws Exception{
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
	public int delete(int qna_seq) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "delete qna where qna_seq=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, qna_seq);
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
		
	}
	public int insert(QnaDTO qnaDTO, String kind) throws Exception	{
		Connection con = DBConnector.getConnect();
		
		String sql = "insert into qna values(qna_seq.nextval,?,?,?,?,sysdate,'답변 미완료',NULL)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, qnaDTO.getTitle());
		if(kind.equals("company")){
			st.setString(2, null);
			st.setString(3, qnaDTO.getWriter());
		}else{
			st.setString(2, qnaDTO.getWriter());
			st.setString(3, null);
		}
		st.setString(4, qnaDTO.getContents());
		
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
			if(rs.getString("company_name")==null){
				qnaDTO.setWriter(rs.getString("nickname"));
			}else{
				qnaDTO.setWriter(rs.getString("company_name"));
			}
			qnaDTO.setContents(rs.getString("contents"));
			qnaDTO.setReg_date(rs.getDate("reg_date"));
			qnaDTO.setReply_check(rs.getString("reply_check"));
			qnaDTO.setReply(rs.getString("reply"));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return qnaDTO;
	}
	public List<QnaDTO> selectList(MakeRow makeRow, String kind, String search) throws Exception	{
		Connection con = DBConnector.getConnect();
		String sql = "select * from "
			+	"(select rownum R, Q.* from "
			+   "(select * from qna where "+kind+" like ? order by qna_seq desc) Q) "
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
			if(rs.getString("company_name")==null){
				qnaDTO.setWriter(rs.getString("nickname"));
			}else{
				qnaDTO.setWriter(rs.getString("company_name"));
			}
			qnaDTO.setContents(rs.getString("contents"));
			qnaDTO.setReg_date(rs.getDate("reg_date"));
			qnaDTO.setReply_check(rs.getString("reply_check"));
			qnaDTO.setReply(rs.getString("reply"));
			ar.add(qnaDTO);
		}
		DBConnector.disConnect(rs, st, con);
		return ar;
		
	}
	public int getTotalCount(String kind, String search) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select nvl(count(qna_seq), 0) from qna where "+kind+" like ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, "%"+search+"%");
		ResultSet rs = st.executeQuery();
		rs.next();
		int result = rs.getInt(1);
		
		DBConnector.disConnect(rs, st, con);
		System.out.println("result : "+result);
		return result;
	}
}
