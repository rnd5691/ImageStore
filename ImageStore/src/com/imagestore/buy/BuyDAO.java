package com.imagestore.buy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.imagestore.util.DBConnector;
import com.imagestore.util.MakeRow;
import com.imagestore.work.WorkDAO;

public class BuyDAO {
	
	public int getTotalCount(int user_num) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select nvl(count(buy_seq), 0) from buy_info where user_num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, user_num);
		ResultSet rs = st.executeQuery();
		rs.next();
		int result = rs.getInt(1);
		
		DBConnector.disConnect(rs, st, con);
		
		return result;
	}
			
	public List<BuyDTO> selectList(int user_num, MakeRow makeRow) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select * from "
				+ "(select rownum R, Q.* from "
				+ "(select * from buy_info where user_num=? order by buy_seq desc) Q) "
				+ "where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, user_num);
		st.setInt(2, makeRow.getStartRow());
		st.setInt(3, makeRow.getLastRow());
		
		ResultSet rs = st.executeQuery();
		List<BuyDTO> ar = new ArrayList<>();
		while(rs.next()){
			BuyDTO buyDTO = new BuyDTO();
			buyDTO.setBuy_seq(rs.getInt("buy_seq"));
			buyDTO.setUser_num(rs.getInt("user_num"));
			buyDTO.setNickname(rs.getString("nickname"));
			buyDTO.setWork(rs.getString("work"));
			buyDTO.setFile_num(rs.getInt("file_num"));
			/*WorkDAO workDAO = new WorkDAO();
			buyDTO.setWork(workDAO.searchWork(rs.getInt("work_seq")));*/
			buyDTO.setBuy_date(rs.getDate("buy_date"));
			buyDTO.setPrice(rs.getInt("price"));
			ar.add(buyDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return ar;
	}
}
