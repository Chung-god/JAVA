package 세션관리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String memberID="test9";
		String memberPassword="test9";
		String target = "http://www.dowellcomputer.com/hacking/member/memberLogicnAction.jsp?memberID"+memberID+"&memberPassword"+memberPassword;
		HttpURLConnection con = (HttpURLConnection) new URL(target).openConnection();
		String cookie = ""; //세션값 들어감
		String temp = con.getHeaderField("Set-Cookie"); //temp 안에 쿠키 값을 넘어줌 
		if(temp!=null) {
			cookie = temp;
		}else{
			System.out.println("Null");
		}
		System.out.println("현재 당신의 세션은 :" + cookie);
		
		con =(HttpURLConnection) new URL("http://dowellcomputer.com/hacking/member/memberUpdateForm.jsp?ID="+memberID).openConnection();
		//con.setRequestProperty("Cookie",cookie); //쿠키 값을 해당 웹사이트로 보내도록 리퀘스트 매칭해줌 
		//이러면 웹서버는 정상적으로 받아들임 
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
		while((temp = br.readLine())!=null) {
			System.out.println(temp);
		}
		con.disconnect();
		br.close();
	}
}

/*
 현재 웹사이트에 변화가 생겼는지 쿠키 정보를 알아낼 수가 없음. URL 쪽을 보니 target 으로 설정한 문자열과 좀 다르게 로그인이 됨. 
 그게 바뀌어서 그런게 아닌가 싶음
 */
