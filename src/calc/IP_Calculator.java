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
				"*******************************\n");
		while (!valid_option) {
			System.out.print("Enter option: ");
			int option = menu.nextInt();
			if (option == 1){
				valid_option = true;
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
				
				//close the scanner
				menu.close();
			} else if (option == 2) {
				valid_option = true;
				System.out.println(">>Preparing to convert header information.\n"
						+ ">>Please enter a binary header object to proceed:");
				Binary bHeader = new Binary(Validator.fetchUserInput("Input:"));
				System.out.print("\nDecimal header information:\n"
				+ bHeader.toDecimalHeaderString());
				menu.close();
			} else {
				System.out.println(">>No such option!");
			}
		}
	}
}