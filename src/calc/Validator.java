package calc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.xml.transform.Source;

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
					header.setIhl(ihl);
					valid = true;
				} else {
					throw new RuntimeException("Der IHL muss ein Vielfaches von 32bit sein.\n");
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!valid);
	}
	
	public void setTos() {
		boolean valid = false;
		int[] allowedTOS = {
			0, 32, 40, 56, 72, 88, 96, 112, 136, 144, 152, 160, 184, 192, 224
		};
		do {
			try {
				int tos = fetchNumberInput("TOS:");
				for (int i : allowedTOS) {
					if (i == tos) {
						header.setTos(tos);
						valid = true;
					} else {
						throw new RuntimeException("Die Eingabe ist kein gültiger Type of Service.\n");
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!valid);
	}
	
	public void setID() {
		boolean valid = false;
		do {
			try {
				int id = fetchNumberInput("ID:");
				header.setId(id);
				valid = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!valid);
	}
	
	public void setFlag() {
	// TODO: add validation of 3 bit flag
		boolean valid = false;
		do {
			try {
				String flag = fetchUserInput("Flag:");
				header.setFlag(flag);
				valid = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!valid);
	}
	
	public void setFragment_offset() {
		boolean valid = false;
		do {
			try {
				int offset = fetchNumberInput("Offset:");
				header.setFragment_offset(offset);
				valid = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!valid);
	}
	
	public void setTtl() {
		boolean valid = false;
		do {
			try {
				int ttl = fetchNumberInput("TTL:");
				if (ttl > 0) {
					header.setTtl(ttl);
					valid = true;
				} else {
					throw new RuntimeException("Das Paket ist abgelaufen und wird verworfen.\n");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!valid);
	}
	
	public void setProtocol() {
		boolean valid = false;
		do {
			try {
				int protocol = fetchNumberInput("Protocol:");
				// TODO: add protocol validation
				/*
				if (protocol) {
					header.setTtl(protocol);
					valid = true;
				} else {
					throw new RuntimeException("Ungültiges Protokoll.\n");
				}
				*/
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!valid);
	}
	
	
	public void setSourceIp() {
		boolean valid = false;
		do {
			try {
				String source_ip = fetchUserInput("Source IP adress (ex.: 192.168.1.2):");
				
				String[] ip_parts = source_ip.split("\\.");
				if (ip_parts.length < 1 && ip_parts.length > 4) {
					throw new RuntimeException("Invalid length of IP adress!\n");
				}
				for (String string : ip_parts) {
					int ip_part = Integer.parseInt(string);
					if (ip_part > 255) {
						throw new RuntimeException("Invalid IP adress!\n");
					}
				}
				header.setSource_ip(source_ip);
				valid = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!valid);
	}
	
	public void setDestinationIp() {
		boolean valid = false;
		do {
			try {
				String destination_ip = fetchUserInput("Enter destination IP adress (ex.: 192.168.1.4):");
				if (destination_ip.contains(".")) {
					String[] ip_parts = destination_ip.split("\\.");
					if (ip_parts.length < 1 && ip_parts.length > 4) {
						throw new RuntimeException("Invalid length of IP adress!\n");
					}
					for (String string : ip_parts) {
						int ip_part = Integer.parseInt(string);
						if (ip_part > 255) {
							throw new RuntimeException("Invalid IP adress!\n");
						}
					}
					header.setDestination_ip(destination_ip);
					valid = true;
				} else {
					throw new RuntimeException("Please use a separator for your input.");
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter valid numbers for the ip adress.");
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
