package ���ǰ���;

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
		String cookie = ""; //���ǰ� ��
		String temp = con.getHeaderField("Set-Cookie"); //temp �ȿ� ��Ű ���� �Ѿ��� 
		if(temp!=null) {
			cookie = temp;
		}else{
			System.out.println("Null");
		}
		System.out.println("���� ����� ������ :" + cookie);
		
		con =(HttpURLConnection) new URL("http://dowellcomputer.com/hacking/member/memberUpdateForm.jsp?ID="+memberID).openConnection();
		//con.setRequestProperty("Cookie",cookie); //��Ű ���� �ش� ������Ʈ�� �������� ������Ʈ ��Ī���� 
		//�̷��� �������� ���������� �޾Ƶ��� 
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
		while((temp = br.readLine())!=null) {
			System.out.println(temp);
		}
		con.disconnect();
		br.close();
	}
}

/*
 ���� ������Ʈ�� ��ȭ�� ������� ��Ű ������ �˾Ƴ� ���� ����. URL ���� ���� target ���� ������ ���ڿ��� �� �ٸ��� �α����� ��. 
 �װ� �ٲ� �׷��� �ƴѰ� ����
 */
