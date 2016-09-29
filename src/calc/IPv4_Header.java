package calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class IPv4_Header {
	//TODO: (1) add IP header checksum and computing logic
	//TODO: (2) add input integrity checks
	private int version_dec;
	private Binary version_bin = new Binary();
	private int ihl_dec; // IP header length
	private Binary ihl_bin = new Binary();;
	private int tos_dec; // type of service
	private Binary tos_bin = new Binary();;
	private int total_length_dec;
	private Binary total_length_bin = new Binary();;
	private int id_dec; // identification
	private Binary id_bin = new Binary();;
	private Binary flag = new Binary();;
	private int fragment_offset_dec;
	private Binary fragment_offset_bin = new Binary();;
	private int ttl_dec;
	private Binary ttl_bin = new Binary();;
	private int protocol_dec;
	private Binary protocol_bin = new Binary();;
	private String source_ip_dec; // source IP address
	private Binary source_ip_bin = new Binary();;
	private String destination_ip_dec; // destination IP address
	private Binary destination_ip_bin = new Binary();;

	String[] input_text = {
			"Version: ",
			"IP Header Length (IHL): ",
			"type of service (TOS): ",
			"total length: ",
			"ID: ",
			"flag: ",
			"fragment-offset: ",
			"time-to-live (TTL): ",
			"protocol: ",
			"source IP adress: ",
			"target IP adress: "
	};

	private ArrayList<String> header = new ArrayList<String>();
	private ArrayList<String> b_header = new ArrayList<String>();

	public void setVersion(int a) {
		version_dec = a;
		version_bin.setValue(a, 4);
	}
	public void setIHL(int a) {
		ihl_dec = a;
		ihl_bin.setValue(a, 4);
	}
	public void setTOS(int a) {
		tos_dec = a;
		tos_bin.setValue(a, 8);
	}
	public void setTotalLength(int a) {
		total_length_dec = a;
		total_length_bin.setValue(a, 16);
	}
	public void setID(int a) {
		id_dec = a;
		id_bin.setValue(a, 16);
	}
	public void setFlag(String s) {
		flag.setValue(s, 3);
	}
	public void setFragmentOffset(int a) {
		fragment_offset_dec = a;
		fragment_offset_bin.setValue(a, 13);
	}
	public void setTTL(int a) {
		ttl_dec = a;
		ttl_bin.setValue(a, 8);
	}
	public void setProtocol(int a) {
		protocol_dec = a;
		protocol_bin.setValue(a, 8);
	}
	public void setSIP(String s) {
		source_ip_dec = s;
		String[] temp = s.split("\\."); // splits the ip address per "." and returns an array
		String binary = ""; // binary string
		for (int i = 0; i < temp.length; i++) {
			String x = Integer.toBinaryString(Integer.parseInt(temp[i]));
			binary = binary + x;
		}
		source_ip_bin.setValue(binary, 24);
	}
	public void setDIP(String s) {
		destination_ip_dec = s;
		String[] temp = s.split("\\."); // splits the ip address per "." and returns an array
		String binary = ""; // binary string
		for (int i = 0; i < temp.length; i++) {
			String x = Integer.toBinaryString(Integer.parseInt(temp[i]));
			binary = binary + x;
		}
		destination_ip_bin.setValue(binary, 24);
	}

	public void setHeader() {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			for (int i = 0; i < 11; i++) {
				System.out.print(input_text[i]);
				header.add(bReader.readLine());
			}
			this.setVersion(Integer.parseInt(header.get(0)));
			this.setIHL(Integer.parseInt(header.get(1)));
			this.setTOS(Integer.parseInt(header.get(2)));
			this.setTotalLength(Integer.parseInt(header.get(3)));
			this.setID(Integer.parseInt(header.get(4)));
			this.setFlag(header.get(5));
			this.setFragmentOffset(Integer.parseInt(header.get(6)));
			this.setTTL(Integer.parseInt(header.get(7)));
			this.setProtocol(Integer.parseInt(header.get(8)));
			this.setSIP(header.get(9));
			this.setDIP(header.get(10));
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
		System.out.println("\n"	+ "Header information:\n" + output);
	}

	public String arrayListToString(ArrayList<String> array) {
		String out = "";
		for (int i = 0; i < array.size(); i++) {
			out += array.get(i);
			if(i != (array.size() - 1)) {
				out += " ";
			}
		}
		return out;
	}
	public void toBinary() {
		b_header.add(version_bin.getValue());
		b_header.add(ihl_bin.getValue());
		b_header.add(tos_bin.getValue());
		// TEST: print the first 16 bit;
		String test = b_header.get(0).toString() + b_header.get(1).toString() + b_header.get(2).toString();
		int dec = Integer.parseInt(test, 2);
		String hex = Integer.toString(dec, 16);
		System.out.println(hex);
		// TEST end
		b_header.add(total_length_bin.getValue());
		b_header.add(id_bin.getValue());
		b_header.add(flag.getValue());
		b_header.add(fragment_offset_bin.getValue());
		b_header.add(ttl_bin.getValue());
		b_header.add(protocol_bin.getValue());
		b_header.add(source_ip_bin.getValue());
		b_header.add(destination_ip_bin.getValue());

		System.out.println("\n"
				+ "binary header information:"
				+ arrayListToString(b_header));
	}
}
