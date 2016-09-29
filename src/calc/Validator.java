package calc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Validator {
	private IPv4_Header header = null;
	
	public Validator(IPv4_Header header) {
		this.header = header;
	}
	public void setVersion() {
		boolean valid = false;
		do {
			try {
				int number = fetchNumberInput("Version:");
				header.setVersion(number);
				valid = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!valid);
	}
	
	public void setIhl() {
		boolean valid = false;
		do {
			try {
				int ihl_byte = fetchNumberInput("IHL in Byte:");
				int ihl = 0;
				int mod = ((ihl_byte * 8) % 32);
				if (mod == 0) {
					ihl = ((ihl_byte * 8) / 32);
				} else {
					throw new RuntimeException("Der IHL muss ein Vielfaches von 32bit sein.\n");
				}
				header.setIhl(ihl);
				valid = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!valid);
	}
	
	private String fetchUserInput(String message) {
		String input = "";
		System.out.println(message);
		try {
			BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
			input = bReader.readLine();
		} catch (Exception e) {
			e.getMessage();
		}
		return input;
	}
	
	private int fetchNumberInput(String message) {
		Integer number = null;
		do {
			try {
				number = Integer.parseInt(fetchUserInput(message));
				
			} catch (Exception e) {
				System.out.println("Keine gültige Zahl eingegeben.");
			}
		} while (number == null);
		return number;
	}
}
