import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection; //URLConnection 을 구현한 클래스
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		String target = "https://www.naver.com/";
		HttpURLConnection con = (HttpURLConnection) new URL(target).openConnection(); //개체 생성, 요청
		//protected 로 선언되어 있어 직접 객체 생성은 못함
		//URL 객체의 openConnection() 메세드가 리턴하는 URLConnection 객체는 HttpURLConnection의 인스턴스가 될 수 있기 때문에 캐스팅해서 사용 
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8")); // 반응
		//BufferedReader 이름처럼 버퍼를 이용해서 읽고 쓰는  함수 
		//입출력 효율이 좋아짐 
		//많은 데이터를 받을 때 사용, 엔터 인식 
		String temp;
		while((temp = br.readLine()) != null) { //null일 때 까지 한 줄 씩 읽기 
			if(temp.contains("svt: ")) { //문자열에 포함되어있는지  
				temp = temp.split("svt: ")[1].split(",")[0];//해당 문자열을 기준으로 나눠줌  [1] 은 나눈거에 두번째꺼 라고 생각하면 됨
				int year = Integer.parseInt(temp.substring(0,4)); //문자열을 10진수의 Integer 형으로 변환
				int month = Integer.parseInt(temp.substring(4,6));
				int day = Integer.parseInt(temp.substring(6,8));
				int hour = Integer.parseInt(temp.substring(8,10));
				int minute = Integer.parseInt(temp.substring(10,12));
				int sec = Integer.parseInt(temp.substring(12,14));
				System.out.print(year +"년 ");
				System.out.print(month+"월 ");
				System.out.print(day+"일 ");
				System.out.print(hour +"시 ");
				System.out.print(minute+"분 ");
				System.out.print(sec+"초 ");
				
			}
		}
		con.disconnect(); // 연결 끊어줌
		br.close(); //닫아줌
		
	}

}
