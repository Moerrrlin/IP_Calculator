package calc;

import static java.util.Arrays.asList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Validator {
	private IPv4_Header header = null;
	
	public Validator(IPv4_Header header) {
		this.header = header;
	}
	public void setVersion() {
		boolean valid = false;
		do {
			try {
				int version = fetchNumberInput("Version:");
				if (version == 4 || version == 6) {
					header.setVersion(version);
					valid = true;
				} else {
					throw new RuntimeException("Invalid version type.\n");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!valid);
	}
	
	public void setIhl() {
		boolean valid = false;
		do {
			try {
				int ihl_byte = fetchNumberInput("IHL in byte:");
				int ihl = 0;
				int mod = ((ihl_byte * 8) % 32);
				if (mod == 0) {
					ihl = ((ihl_byte * 8) / 32);
					if (ihl >= 5 && ihl <= 15) { // minimum IHL is 5 (20 bytes); maximum 15 (60 bytes)
						header.setIhl(ihl);
						valid = true;
					} else {
						throw new RuntimeException("Value is outside of header size range.\n");
					}
				} else {
					throw new RuntimeException("The IHL is required to be a multiple of 32bit.\n");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!valid);
	}
	
	/**
	 * 
	 */
	public void setTos() {
		boolean valid = false;
//		int[] allowedTOS = {
//			0, 32, 40, 56, 72, 88, 96, 112, 136, 144, 152, 160, 184, 192, 224
//		};
		final List<Integer> allowedTOS = asList(
			0, 32, 40, 56, 72, 88, 96, 112, 136, 144, 152, 160, 184, 192, 224
		);
		do {
			try {
				int tos = fetchNumberInput("TOS:");
				
				/*
			  	for (int i : allowedTOS) {
				  if (i == tos) {
				  	header.setTos(tos);
				  	valid = true;
				  	break;
				  	}
				}
				  
				if (!valid) {
					throw new Exception("Please enter a valid type of service.\n");
				}
				*/
			
				if (allowedTOS.contains(tos)) {
					header.setTos(tos);
					valid = true;
				} else
					throw new RuntimeException("Please enter a valid type of service.\n");
			
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
		// 3 bit value; first bit is reserved for future use 
		final List<String> validFlags = asList(
				// "More Fragment" bit; if set, it represents a fragmented IP datagram that has more fragments after it
				"100", 
				// "Don't Fragment" bit;
				"010",
				// "Last Fragment" flag; 3rd bit is not set signaling the last fragment of a particular IP datagram
				"000"
		);
		boolean valid = false;
		do {
			try {
				String flag = fetchUserInput("Flag:");
				if (validFlags.contains(flag)) {
					header.setFlag(flag);
					valid = true;
				} else {
					throw new Exception("Invalid flag input. \n");
				}
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
					throw new RuntimeException("The packet is expired and will be discarded.\n");
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
				/* validates against IANA Assigned Internet Protocol Numbers
				 * 0 - 142: valid
				 * 143-252: unassigned
				 * 253 + 254: Use for experimentation and testing
				 * 255: reserved
				 */
				if (protocol >= 0 & protocol <= 142) {
					header.setProtocol(protocol);
					valid = true;
				} else {
					throw new RuntimeException("Invalid protocol number.\r".concat(
						"Please refer to http://www.iana.org/assignments/protocol-numbers/protocol-numbers.xhtml \n"));
				}
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
					if (ip_part >= 0 || ip_part <= 255) {
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
						if (ip_part >= 0 || ip_part <= 255) {
							throw new RuntimeException("Invalid IP adress!\n");
						}
					}
					header.setDestination_ip(destination_ip);
					valid = true;
				} else {
					throw new RuntimeException("Please format your input appropriately.\n");
				}
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter valid numbers for the ip adress.\n");
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
				System.out.println("Please enter a valid number.\n");
			}
		} while (number == null);
		return number;
	}
}
