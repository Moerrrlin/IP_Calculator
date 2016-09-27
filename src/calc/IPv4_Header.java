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
	private int ttl = 0;
	private int protocol = 0;
	private String s_ip = ""; // source ip adress
	private String t_ip =""; // target ip adress

	String[] input_text = {
			"Version:",
			"IP Header Length (IHL):",
			"type of service (TOS):",
			"ID:",
			"flag:",
			"fragment-offset:",
			"time-to-live (TTL):",
			"protocol:",
			"source IP adress:",
			"target IP adress:"
	};

	private ArrayList<String> header = new ArrayList<String>();
	private ArrayList<String> b_header = new ArrayList<String>();

	public void setHeader() {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(input_text[i]);
				header.add(bReader.readLine());
				if (header.size() == 10) {
					version = Integer.parseInt(header.get(0).toString());
					ihl = Integer.parseInt(header.get(1));
					tos = Integer.parseInt(header.get(2));
					id = Integer.parseInt(header.get(3));
					flag = header.get(4);
					fragment_offset = Integer.parseInt(header.get(5));
					ttl = Integer.parseInt(header.get(6));
					protocol = Integer.parseInt(header.get(7));
					s_ip = header.get(8).toString();
					t_ip = header.get(9).toString();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void printStr() {
		String output = "";
		char seperator = '-';
		int i = 0;
		for (String string : header) {
			if (i < header.size()-1) {
				output = output + string + seperator;
				i++;
			} else {
				output = output + string;
			}
		}
		System.out.println("Header information:\n" + output);
	}
	public String leadingZero(String s, int b) {
		while (s.length() < b) {
			s = '0' + s;
		}
		return s;
	}
	public String arrayListToString(ArrayList<String> array){
		String out = "";
		System.out.println(array.size());
		for (int i = 0; i < array.size(); i++){
			out += array.get(i);
			if(i != (array.size() - 1)){
				out += " ";
			}
		}
		return out;
	}
	public void toBinary() {
		b_header.add(leadingZero(Integer.toBinaryString(version), 4));
		b_header.add(leadingZero(Integer.toBinaryString(ihl), 4));
		b_header.add(leadingZero(Integer.toBinaryString(tos), 8));
		b_header.add(leadingZero(Integer.toBinaryString(id), 16));
		b_header.add(flag);
		b_header.add(leadingZero(Integer.toBinaryString(fragment_offset), 13));
		b_header.add(leadingZero(Integer.toBinaryString(ttl), 8));
		b_header.add(leadingZero(Integer.toBinaryString(protocol), 8));

		// source ip to binary
		String[] sip_temp = s_ip.split("\\."); // splits the ip address per "." and returns an array
		String b_sip = ""; // binary string
		for (int i = 0; i < sip_temp.length; i++) {
			String x = leadingZero(Integer.toBinaryString(Integer.parseInt(sip_temp[i])), 8);
			b_sip = b_sip + x;
		}
		b_header.add(b_sip);
		// target ip to binary
		String[] tip_temp = t_ip.split("\\.");
		String b_tip= "";
		for (int i = 0; i < tip_temp.length; i++) {
			String x = leadingZero(Integer.toBinaryString(Integer.parseInt(tip_temp[i])), 8);
			b_tip = b_tip + x;
		}
		b_header.add(b_tip);
		System.out.println(arrayListToString(b_header));
	}
}
