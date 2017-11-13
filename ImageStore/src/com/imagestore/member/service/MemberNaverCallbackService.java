package com.imagestore.member.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imagestore.action.Action;
import com.imagestore.action.ActionFoward;
import com.imagestore.member.MemberDAO;
import com.imagestore.member.MemberDTO;
import com.imagestore.member.NaverDAO;
import com.imagestore.person.PersonDAO;
import com.imagestore.person.PersonDTO;
import com.imagestore.util.DBConnector;

public class MemberNaverCallbackService implements Action {

	/*@SuppressWarnings("unchecked")*/
	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		ActionFoward actionFoward = new ActionFoward();
		HttpSession session = request.getSession();
		//2.접근 토큰 발급
		String clientId = "ktmuqeVgbwjBrjz57J54";
		String clientSecret = "6k1LYtIks5";
		String code = request.getParameter("code");//로그인 인증 요청 api 호출에 성공하고 리턴받은 '인증코드값'
		String state = request.getParameter("state");
		String storedState = (String)session.getAttribute("state");

		String redirectURI=null;
		String apiURL=null;
		Connection connect = null;
		try {
			redirectURI = URLEncoder.encode("http://localhost/ImageStore/member/memberNaverCallback.member","UTF-8");
			apiURL = "https://nid.naver.com/oauth2.0/token?";
			apiURL += "client_id="+clientId;
			apiURL += "&client_secret="+clientSecret;
			apiURL += "&grant_type=authorization_code";
			apiURL += "&state="+state;
			apiURL += "&code="+code;
			
			//grant_type : 인증과정에 대한 구분값. 발급-authorization_code, 갱신-refresh_token, 삭제-delete
			apiURL += "&redirect_uri="+redirectURI;
			
			URL url = new URL(apiURL);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			int responseCode=0;
			BufferedReader br;
			//상태토큰 검증. state 파라미터의 값과 처음에 생성한 상태 토큰이 일치하는지 확인.
			if(!(state.equals(storedState))){
				responseCode=401;
			}else{
				responseCode=200;
			}
			
			if(responseCode==200){
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}else{
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			
			StringBuffer res = new StringBuffer();
			
			while((inputLine = br.readLine())!= null){
				if(!inputLine.equals("{")&&!inputLine.equals("}")){
					res.append(inputLine);					
				}
			}
			
			StringTokenizer st = new StringTokenizer(res.toString(), "\"");
			String result = null;
			String [] ar = new String[8];
			int index = 0;
			while(st.hasMoreTokens()){
				result = st.nextToken();
				if(!result.equals(":")&&!result.equals(",")){
					ar[index]=result;					
					index++;
				}
			}
			String access_token = ar[1];
			String refresh_token = ar[3];
		
			br.close();
			System.out.println("res : "+res.toString());
			
			//////////////////////////////////////////////
			NaverDAO naverDAO = new NaverDAO();
			PersonDTO personDTO = naverDAO.naver_info(access_token, refresh_token);
			PersonDAO personDAO = new PersonDAO();
			boolean check = naverDAO.searchToken(personDTO.getToken());
			connect = DBConnector.getConnect();
			MemberDAO memberDAO = new MemberDAO();
			int user_num = memberDAO.searchUserNum(personDTO, connect);
			
			personDTO.setUser_num(user_num);
			if(check==true){
				
				//회원정보에 값이 없을 때
				connect.setAutoCommit(false);
				memberDAO.insert(personDTO, connect);
				
				personDAO.insert(personDTO, connect);
				
				connect.commit();
			}
			
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setId(personDTO.getId());
			memberDTO.setPw(personDTO.getPw());
			memberDTO.setUser_num(personDTO.getUser_num());
			memberDTO.setEmail(personDTO.getEmail());
			memberDTO.setKind(personDTO.getKind());
			memberDTO.setToken(personDTO.getToken());
			
			session.setAttribute("member", memberDTO);
			String writer = personDAO.selectWriter(memberDTO.getUser_num());
			session.setAttribute("writer", writer);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			connect.rollback();
			e.printStackTrace();
		}finally {
			connect.setAutoCommit(true);
		}

		actionFoward.setCheck(false);
		actionFoward.setPath("../index.jsp");
		
		return actionFoward;
	}

}
