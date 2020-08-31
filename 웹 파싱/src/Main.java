import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection; //URLConnection �� ������ Ŭ����
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		String target = "https://www.naver.com/";
		HttpURLConnection con = (HttpURLConnection) new URL(target).openConnection(); //��ü ����, ��û
		//protected �� ����Ǿ� �־� ���� ��ü ������ ����
		//URL ��ü�� openConnection() �޼��尡 �����ϴ� URLConnection ��ü�� HttpURLConnection�� �ν��Ͻ��� �� �� �ֱ� ������ ĳ�����ؼ� ��� 
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8")); // ����
		//BufferedReader �̸�ó�� ���۸� �̿��ؼ� �а� ����  �Լ� 
		//����� ȿ���� ������ 
		//���� �����͸� ���� �� ���, ���� �ν� 
		String temp;
		while((temp = br.readLine()) != null) { //null�� �� ���� �� �� �� �б� 
			if(temp.contains("svt: ")) { //���ڿ��� ���ԵǾ��ִ���  
				temp = temp.split("svt: ")[1].split(",")[0];//�ش� ���ڿ��� �������� ������  [1] �� �����ſ� �ι�°�� ��� �����ϸ� ��
				int year = Integer.parseInt(temp.substring(0,4)); //���ڿ��� 10������ Integer ������ ��ȯ
				int month = Integer.parseInt(temp.substring(4,6));
				int day = Integer.parseInt(temp.substring(6,8));
				int hour = Integer.parseInt(temp.substring(8,10));
				int minute = Integer.parseInt(temp.substring(10,12));
				int sec = Integer.parseInt(temp.substring(12,14));
				System.out.print(year +"�� ");
				System.out.print(month+"�� ");
				System.out.print(day+"�� ");
				System.out.print(hour +"�� ");
				System.out.print(minute+"�� ");
				System.out.print(sec+"�� ");
				
			}
		}
		con.disconnect(); // ���� ������
		br.close(); //�ݾ���
		
	}

}
