package com.imagestore.member;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringTokenizer;

import com.imagestore.person.PersonDTO;
import com.imagestore.util.DBConnector;

public class NaverDAO {
	//네이버 토큰 확인
	public boolean searchToken(String token) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select * from user_info where token=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, token);
		ResultSet rs = st.executeQuery();
		boolean check = true;
		if(rs.next()){
			check = false;
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return check;
	}
	//네이버 회원 정보
		public PersonDTO naver_info(String access_token, String refresh_token) throws Exception{
			PersonDTO personDTO = new PersonDTO();
			String header = "Bearer "+access_token;
			String apiUPL = "https://openapi.naver.com/v1/nid/me";
			URL url = new URL(apiUPL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", header);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if(responseCode==200){//정상호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}else{//에러발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String inputLine;
			StringBuffer response = new StringBuffer();
			while((inputLine = br.readLine())!= null){
				if(!inputLine.equals("{")&&!inputLine.equals("}")){
					response.append(inputLine);					
				}
			}
			System.out.println("response : "+response);
			StringTokenizer st = new StringTokenizer(response.toString(), "\"");
			String result = null;
			String [] ar = new String[21];
			int index = 0;
			while(st.hasMoreTokens()){
				result = st.nextToken();
				if(!result.equals(":")&&!result.equals(",")&&!result.equals("{")&&!result.equals("}}")&&!result.equals(":{")){
					ar[index]=result;					
					index++;
				}
			}
			for(int i=0; i<ar.length; i++){
				System.out.println(i+"번째  : "+ar[i]);
			}
			
			br.close();
			
			//email값을 이용하여 id 값 구하기
			String email = ar[18];
			StringTokenizer st_id = new StringTokenizer(email, "@");
			String result_id = null;
			if(st_id.hasMoreTokens()){
				result_id = st_id.nextToken();
			}
			personDTO.setId(result_id);
			personDTO.setPw("NULL");
			personDTO.setEmail(ar[18]);
			personDTO.setKind("person");
			personDTO.setToken(ar[16]);
			
			///////////////////////////
			personDTO.setNickName(ar[6]);
			personDTO.setArtist("person");
			return personDTO;
		}
}
