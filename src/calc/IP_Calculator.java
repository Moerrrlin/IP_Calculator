package calc;

public class IP_Calculator {

	public static void main(String[] args) {
		IPv4_Header header = new IPv4_Header();
		
		header.setHeader(); // set the header
		
		header.printStr();
	}

}
