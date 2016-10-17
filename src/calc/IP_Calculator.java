package calc;


public class IP_Calculator {

	public static void main(String[] args) {
		
		IPv4_Header header = new IPv4_Header();

		Validator valD = new Validator(header);
		
//		valD.setVersion();
//		
//		valD.setIhl();
//		
//		valD.setTos();
//		
//		valD.setID();
//
//		valD.setFragment_offset();
//		
//		valD.setTtl();
//		
//		valD.setProtocol();
//		
//		valD.setSourceIp();
		
		valD.setDestinationIp();
		header.getDestination_ip();
		/*
		header.setHeader(); // set the header via user input

		header.printDecimal(); // print the header information

		header.printBinary(); // print the header in binary format
		*/
	}

}
