import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection; //URLConnection 을 구현한 클래스
import java.net.MalformedURLException;
import java.net.URL;

public class Main3 {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		while(true) {
			String target = "https://www.naver.com/";
			HttpURLConnection con = (HttpURLConnection) new URL(target).openConnection(); 
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8")); 
			FileWriter fw =  null;
			String temp;
			while((temp = br.readLine()) != null) { 
				if(temp.contains("svt: ")) { 
					fw = new FileWriter(temp.split("svt: ")[1].split(",")[0]+".txt"); //현재 서버시간으로 텍스트 생성 
				}
				if(temp.contains("신정락")) {
					fw.write(temp + "\r\n"); //개행문자 넣어주기
				}
			}
			fw.close();
			con.disconnect(); // 연결 끊어줌
			br.close(); //닫아줌
			Thread.sleep(10000); // 10초마다 반복
		}
	}

}
