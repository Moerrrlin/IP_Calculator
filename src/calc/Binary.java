package calc;

public class Binary {
    private String value;

    public void setValue(String s, int b) {
        value = leadingZero(s, b);
    }
    public void setValue(int i, int b){
        value = leadingZero(Integer.toBinaryString(i), b);
    }
    
    public void setValue(IPv4_Header header) {
    	try {
	    	String[] ipPartsSourceIP = header.getSourceIP().split("\\.");
	    	//32 bit word
	    	String ipPartsSourceIPInBinary =
	    			leadingZero(Integer.toBinaryString(Integer.parseInt(ipPartsSourceIP[0])), 8)
	    			+ leadingZero(Integer.toBinaryString(Integer.parseInt(ipPartsSourceIP[1])), 8)
	    			+ leadingZero(Integer.toBinaryString(Integer.parseInt(ipPartsSourceIP[2])), 8)
	    			+ leadingZero(Integer.toBinaryString(Integer.parseInt(ipPartsSourceIP[3])), 8);
	    	
	    	String[] ipPartsDestinationIP = header.getDestinationIP().split("\\.");
	    	//32 bit word
	    	String ipPartsDestinationIPInBinary = 
	    			leadingZero(Integer.toBinaryString(Integer.parseInt(ipPartsDestinationIP[0])), 8)
	    			+ leadingZero(Integer.toBinaryString(Integer.parseInt(ipPartsDestinationIP[1])), 8)
	    			+ leadingZero(Integer.toBinaryString(Integer.parseInt(ipPartsDestinationIP[2])), 8)
	    			+ leadingZero(Integer.toBinaryString(Integer.parseInt(ipPartsDestinationIP[3])), 8);
	    	char seperator = ' ';
	    	value = leadingZero(header.getVersion(), 4) + seperator;
			value += leadingZero(header.getIhl(), 4) + seperator;
			value += leadingZero(header.getTos(),8) + seperator;
			value += leadingZero(header.getTotalLength(), 16) + seperator; 
			value += leadingZero(header.getId(), 16) + seperator; 
			value += header.getFlag() + seperator;
			value +=  leadingZero(header.getFragment_offset(), 13) + seperator;
			value +=  leadingZero(header.getTtl(), 8) + seperator;
			value += leadingZero(header.getProtocol(), 8) + seperator;
			value +=  leadingZero(header.getChecksum(), 16) + seperator;
			value += ipPartsSourceIPInBinary + seperator;
			value += ipPartsDestinationIPInBinary;
    	} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public String getValue() {
        return value;
    }
    
    public Boolean isBinary(String s){
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case '0':   break;
                case '1':   break;
                default:    return false;
            }
        }
        return true;
    }
    
    public String leadingZero(String s, int length) {
		while (s.length() < length) {
			s = '0' + s;
		}
		return s;
	}
    
    public String leadingZero(int i, int length) {
    	String s  = Integer.toBinaryString(i);
    	while  (s.length() < length) {
    		s = "0" + s;
    	}
    	return s;
    }
    
    public Binary() {
        value = "0";
    }
    public Binary(String s) {
        value = s;
    }
    public Binary(int i){
        value = Integer.toBinaryString(i);
    }
    
	private String removeWhitespace(Binary b) {
		String s = b.getValue().replaceAll("\\s","");
		if(isBinary(s)) {
			return s;
		} else {
			throw new RuntimeException("The input is not in binary notation!");
		}
	}
	
	public String toDecimalHeaderString() {
		try {
			String output = "";
			String sHeader = this.getValue();
			if (!sHeader.matches("\\S+")) {
				String[] bHeaderArray = sHeader.split("\\s");
				char seperator = '-';
				for (int i = 0; i < (bHeaderArray.length); i++) {
					int temp = Integer.parseInt(bHeaderArray[i],2);
					if (i == (bHeaderArray.length -1)) {
						output += Integer.toString(temp);
					} else {
						output += Integer.toString(temp) + seperator;
					}
				}
				return output;
			} else if (isBinary(sHeader)) {
				output = "";
				//TODO process binary string
				return output;
			} else {
				throw new RuntimeException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}