package calc;

import java.util.Scanner;

public class IP_Calculator {

	public static void main(String[] args) {
		Scanner menu = new Scanner(System.in);
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
		System.out.print("Enter option: ");
				
		int option = menu.nextInt();
		if (option == 1){
				menu.close();
				IPv4_Header header = new IPv4_Header();
				Validator valD = new Validator(header);
				
				// fetch user input for header information
				valD.setVersion();
				
				valD.setIhl();
				
				valD.setTos();
				
				valD.setID();
				
				valD.setFlag();

				valD.setFragment_offset();
				
				valD.setTtl();
				
				valD.setProtocol();

//				valD.setChecksum();
				
				valD.setSourceIp();
				
				valD.setDestinationIp();
				
//				header.print();
//				header.toBinary();
				
		} else if (option == 2) {
			menu.close();
			Binary header = new Binary();
//			BinaryValidator bVal = new BinaryValidator(header);
		}
		
		/*
		header.setHeader(); // set the header via user input

		header.printDecimal(); // print the header information

		header.printBinary(); // print the header in binary format
		*/
	}

}
