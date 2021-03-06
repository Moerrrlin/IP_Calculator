package calc;

public class IPv6_Address{
	private String[] addressHex = new String[8];
	private Binary[] addressBin = new Binary[8];

	public void setAddressHex(String[] addr){
		addressHex = addr;
	}

	public void setAddressHex(String element, int i){
		addressHex[i] = element;
	}

	public void setAddressBin(Binary[] addr){
		addressBin = addr;
	}

	public void setAddressBin(Binary element, int i){
		addressBin[i] = element;
	}

	public String[] getAddressHex(){
		return addressHex;
	}

	public String getAddressHex(int i){
		return addressHex[i];
	}

	public Binary[] getAddressBin(){
		return addressBin;
	}

	public Binary getAddressBin(int i){
		return addressBin[i];
	}

	public String toStringHex(){
		String string = "";
		for(int i = 0; i < 8; i++){
			string += getAddressHex(i);
			if(i < 8 - 1){
				string += ":";
			}
		}
		return string;
	}

	public void displayHex(){
		System.out.println(toStringHex());
	}

	public String toStringBin(){
		String string = "";
		for(int i = 0; i < 8; i++){
			string += getAddressBin(i).getValue();
		}
		return string;
	}

	public void displayBin(){
		System.out.println(toStringBin());
	}

	public void toBinary(){
		String hex = "0123456789abcdef";
		Binary[] addrBin = new Binary[8];
		//run through all elements of the IPv6 address in hexadecimal form
		for(int i = 0; i < 8; i++){
			//grab current hexadecimal address element
			String addrElem = this.getAddressHex(i).toLowerCase();
			//initialize an invalid binary number to fill in the next step
			Binary addrElemBin = new Binary("");
			//run through all four digits of the hexadecimal address element
			for(int j = 0; j < 4; j++){
				char addrElemChar = addrElem.charAt(j);
				//convert the digit into binary form, adding leading zeros if needed
				Binary addressElementCharBinary = new Binary(Integer.toBinaryString(hex.indexOf(addrElemChar)), 4);
				addrElemBin.setValue(addrElemBin.getValue().concat(addressElementCharBinary.getValue()));
			}
			addrBin[i] = addrElemBin;
		}
		this.setAddressBin(addrBin);
	}

	public void toHexadecimal(){
		String[] addrHex = new String[8];
		//run through all elements of the IPv6 address in binary form
		for(int i = 0; i < 8; i++){
			//grab current binary address element
			String addrElem = this.getAddressBin(i).getValue();
			String addrElemHex = "";
			//split the binary string into four bit segments and convert them into hexadecimal form
			for(int j = 0; j < 16; j = j + 4){
				String addrElemSeg = addrElem.substring(j, j + 4);
				//binary to hexadecimal conversion
				String addrElemSegHex = Integer.toString(Integer.parseInt(addrElemSeg, 2), 16);
				addrElemHex = addrElemHex.concat(addrElemSegHex);
			}
			addrHex[i] = addrElemHex;
		}
		this.setAddressHex(addrHex);
	}

	public IPv6_Address(String[] addr){
		addressHex = addr;
		this.toBinary();
	}

	public IPv6_Address(Binary[] addr){
		addressBin = addr;
		this.toHexadecimal();
	}
}
