package calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class IPv4_Header {
	private int version = 0;
	private int ihl = 0; // IP header length
	private int tos = 0; // type of service
	private int id = 0; // Kennung
	private String flag = "000";
	private int fragment_offset = 0;
	private int ttl = 32;
	private int protocol = 0;
	private String s_ip = ""; // source ip adress
	private String t_ip =""; // target ip adress
	
	private ArrayList<String> header = new ArrayList<String>();
	
	public void setHeader() {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i <= 10; i++) {
			try {
				header.add(bReader.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void printStr() {
		String output = "";
		char seperator = '-';
		for (String string : header) {
			for (int i = 0; i <= header.size(); i++) {
				if (i < header.size()) {
					output = string + seperator;
				} else {
					output = output + string;
				}
			}
		}
		System.out.println(output);
	}
}