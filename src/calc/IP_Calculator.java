package calc;

import java.util.Scanner;

public class IP_Calculator {

	public static void main(String[] args) {
		Scanner menu = new Scanner(System.in);
		boolean valid_option = false;
		// arbitrary option menu
		System.out.println(
				"*******************************\n" +
				"*                             *\n" +
				"*       IPv4 Calculator       *\n" +
				"*                             *\n" +
				"*******************************\n" +
				"*           Options           *\n" +
				"* (1) decimal input to binary *\n" +
				"*                             *\n" +
				"* (2) binary input to decimal *\n" +
				"*                             *\n" +
				"*******************************\n" +
				"*                             *\n" +
				"*       IPv6 Calculator       *\n" +
				"*                             *\n" +
				"*******************************\n" +
				"*           Options           *\n" +
				"* (3) decimal input to binary *\n" +
				"*                             *\n" +
				"* (4) binary input to decimal *\n" +
				"*                             *\n" +
				"*******************************\n");
		while (!valid_option) {
			System.out.print("Enter option: ");
			int option = menu.nextInt();
			switch(option){
				case 1:
					valid_option = true;
					/*
					System.out.println(">>Preparing to convert header information. Please enter the following data to proceed.");
					IPv4_Header header = new IPv4_Header();
					Validator valD = new Validator(header);

					// fetch user input for header information
					valD.setVersion();
					valD.setIhl();
					valD.setTos();
					valD.setTotalLength();
					valD.setID();
					valD.setFlag();
					valD.setFragmentOffset();
					valD.setTtl();
					valD.setProtocol();
					
					System.out.println(">> The checksum is handled as 0. "
					+ "Computing will be initialized after packet is complete.");
					
					valD.setSourceIp();
					valD.setDestinationIp();
					valD.computeChecksum();
					
					header.print();
					header.printBinary();
					*/
					//close the scanner
					menu.close();
					break;
				case 2:
					valid_option = true;
					/*
					System.out.println(">>Preparing to convert header information.\n"
						+ ">>Please enter a binary header object to proceed:");
					Binary bHeader = new Binary(Validator.fetchUserInput("Input:"));
					System.out.print("\nDecimal header information:\n"
					+ bHeader.toDecimalHeaderString());
					*/
					menu.close();
					break;
				case 3:
					valid_option = true;
					IPv6_Validator validator = new IPv6_Validator();
					int version = validator.getCheckedHeader().getVersionDec();
					int trafficClass = validator.getCheckedHeader().getTrafficClassDec();
					int flowLabel = validator.getCheckedHeader().getFlowLabelDec();
					int payloadLength = validator.getCheckedHeader().getPayloadLengthDec();
					int nextHeader = validator.getCheckedHeader().getNextHeaderDec();
					int hopLimit = validator.getCheckedHeader().getHopLimitDec();
					IPv6_Address sourceIp = validator.getCheckedHeader().getSourceAddr();
					IPv6_Address destinationIp = validator.getCheckedHeader().getDestinationAddr();
					IPv6_Header header = new IPv6_Header(version, trafficClass, flowLabel, payloadLength, nextHeader, hopLimit, sourceIp, destinationIp);
					header.displayDec();
					header.displayBin();
					menu.close();
					break;
				case 4:
					valid_option = true;
					System.out.println("TODO");
					menu.close();
					break;
				default:
					System.out.println(">>No such option!");
			}
		}
	}
}
