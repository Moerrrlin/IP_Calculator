package calc;

public class IP_Calculator {

	public static void main(String[] args) {
		Deprecated_IPv4_Header header = new Deprecated_IPv4_Header();

		header.setHeader(); // set the header via user input

		header.printDecimal(); // print the header information

		header.printBinary(); // print the header in binary format
	}

}
