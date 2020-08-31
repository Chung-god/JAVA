//네이버에서 현재 기온 체크하는 웹 파싱
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main2 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
			String target = "https://www.naver.com/";
			HttpURLConnection con = (HttpURLConnection) new URL(target).openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
			String temp;
			while((temp = br.readLine()) != null) {
				if(temp.contains("현재기온")) {
					temp=temp.split(">")[1].split("<")[0];
					System.out.println("현재 기온은 "+temp + "입니다.");
				}
			}
			con.disconnect();
			br.close();
	}

}
