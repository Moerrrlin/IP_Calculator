package calc;

public class IP_Calculator {

	public static void main(String[] args) {
		IPv4_Header header = new IPv4_Header();
		
		header.setHeader(); // set the header via user input
		
		header.printStr(); // print the header information

		header.toBinary(); // print the header in binary format
	}

}
