import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection; //URLConnection �� ������ Ŭ����
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
					fw = new FileWriter(temp.split("svt: ")[1].split(",")[0]+".txt"); //���� �����ð����� �ؽ�Ʈ ���� 
				}
				if(temp.contains("������")) {
					fw.write(temp + "\r\n"); //���๮�� �־��ֱ�
				}
			}
			fw.close();
			con.disconnect(); // ���� ������
			br.close(); //�ݾ���
			Thread.sleep(10000); // 10�ʸ��� �ݺ�
		}
	}

}
