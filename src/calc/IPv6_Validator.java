package calc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IPv6_Validator{
	private IPv6_Header header;

	public int checkVersion(){
		boolean valid = false;
		int version = -1;
		do {
			try {
				version = fetchNumberInput("Version:");
				if(version == 6){
					valid = true;
				}
				else{
					throw new RuntimeException(">>Invalid version!\n");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!valid);
		return version;
	}

	public int checkTrafficClass(){
		boolean valid = false;
		int trafficClass = -1;
		do {
			try {
				trafficClass = fetchNumberInput("Traffic Class:");
				if(trafficClass > 0 && trafficClass < 256){
					valid = true;
				}
				else{
					throw new RuntimeException(">>Invalid Traffic Class!\n");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!valid);
		return trafficClass;
	}

	public int checkFlowLabel(){
		boolean valid = false;
		int flowLabel = -1;
		do {
			try {
				flowLabel = fetchNumberInput("Flow Label:");
				if(flowLabel > 0 && flowLabel < 1048576){
					valid = true;
				}
				else{
					throw new RuntimeException(">>Invalid Flow Label!\n");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!valid);
		return flowLabel;
	}

	public int checkPayloadLength(){
		int payLoadLength = fetchNumberInput("Payload Length:");
		return 0;
	}

	public int checkNextHeader(){
		int nextHeader = fetchNumberInput("Next Header:");
		return 0;
	}

	public int checkHopLimit(){
		boolean valid = false;
		int hopLimit = -1;
		do {
			try {
				hopLimit = fetchNumberInput("Hop Limit:");
				if(hopLimit > 0 && hopLimit < 256){
					valid = true;
				}
				else{
					throw new RuntimeException(">>Invalid Hop Limit!\n");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!valid);
		return hopLimit;
	}

	public IPv6_Address checkSourceAddress() {
		boolean valid = false;
		String ip = "undefined";
		do {
			ip = fetchUserInput("Source IP address (ex.: 2001:0db8:0000:08d3:0000:8a2e:0070:7344):");
			valid = validateIPaddress(ip);
		} while (!valid);
		IPv6_Address address = new IPv6_Address(convertInputIp(ip));
		return address;
	}

	public IPv6_Address checkDestinationAddress() {
		boolean valid = false;
		String ip = "undefined";
		do {
			ip = fetchUserInput("Destination IP address (ex.: 2001:0db8:0000:08d3:0000:8a2e:0070:7344):");
			valid = validateIPaddress(ip);
		} while (!valid);
		IPv6_Address address = new IPv6_Address(convertInputIp(ip));
		return address;
	}

	public IPv6_Header getCheckedHeader(){
		return this.header;
	}

	private boolean validateIPaddress(String ip_address) {
		boolean valid = false;
		try {
			String ip = ip_address;
			String hex = "0123456789abcdef";
			if(ip.contains(":")){
				String[] ip_parts = ip.split("\\:");
				if (ip_parts.length != 8) {
					throw new RuntimeException(">>Invalid length of IP adress!\n");
				}
				for(String string : ip_parts){
					if(!string.matches("^[a-f0-9]+$") && string.length() != 4){
						throw new RuntimeException(">>Invalid IP adress!\n");
					}
				}
				valid = true;
			}
			else{
				throw new RuntimeException(">>Please format your input appropriately.\n");
			}
		} catch (NumberFormatException nfe) {
			System.out.println(">>Please enter valid numbers for the ip adress.\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valid;
	}

	private String[] convertInputIp(String ip){
		String[] address = new String[8];
		address = ip.split("\\:");
		return address;
	}

	public static String fetchUserInput(String message) {
		String input = "";
		System.out.print(message);
		try {
			BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
			input = bReader.readLine();
		} catch (Exception e) {
			e.getMessage();
		}
		return input;
	}
	
	public static int fetchNumberInput(String message) {
		Integer number = null;
		do {
			try {
				number = Integer.parseInt(fetchUserInput(message));
			} catch (Exception e) {
				System.out.println(">>Please enter a valid number.\n");
			}
		} while (number == null);
		return number;
	}

	public IPv6_Validator(){
		this.header = new IPv6_Header(checkVersion(), checkTrafficClass(), checkFlowLabel(), checkPayloadLength(), checkNextHeader(), checkHopLimit(), checkSourceAddress(), checkDestinationAddress());
	}
}