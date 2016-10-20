package calc;

public class Binary {
    private String value;

    public void setValue(String s, int b) {
        value = leadingZero(s, b);
    }
    public void setValue(int i, int b){
        value = leadingZero(Integer.toBinaryString(i), b);
    }
    public String getValue() {
        return value;
    }
    public Boolean ifBinary(String s){
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
    	String s  = "";
    	while  (s.length() < length) {
    		s = '0' + Integer.toBinaryString(i);
    	}
    	return s;
    }
    
    public void toBinary(IPv4_Header header) {
    	String[] ipPartsSourceIP = header.getSourceIP().split("\\.");
    	String[] ipPartsSourceIPInBinary = {
    			Integer.toBinaryString(Integer.parseInt(ipPartsSourceIP[0])), Integer.toBinaryString(Integer.parseInt(ipPartsSourceIP[1])),
    			Integer.toBinaryString(Integer.parseInt(ipPartsSourceIP[2])), Integer.toBinaryString(Integer.parseInt(ipPartsSourceIP[3]))
    	};
    	
    	String[] ipPartsDestinationIP = header.getDestinationIP().split("\\.");
    	String[] ipPartsDestinationIPInBinary = {
    			Integer.toBinaryString(Integer.parseInt(ipPartsDestinationIP[0])), Integer.toBinaryString(Integer.parseInt(ipPartsDestinationIP[1])),
    			Integer.toBinaryString(Integer.parseInt(ipPartsDestinationIP[2])), Integer.toBinaryString(Integer.parseInt(ipPartsDestinationIP[3]))
    	};
    	
    	value =leadingZero(header.getVersion(), 4) + leadingZero(header.getIhl(), 4) + leadingZero(header.getTos(),	8)
    		+ leadingZero(header.getTotalLength(), 16) + leadingZero(header.getId(), 16) + header.getFlag()
    		+ leadingZero(header.getFragment_offset(), 13) + leadingZero(header.getTtl(), 8) 
    		+ leadingZero(header.getProtocol(), 8) // + leadingZero(header.getChecksum(), 16)
    		+ leadingZero(ipPartsSourceIPInBinary.toString(), 32) + leadingZero(ipPartsDestinationIPInBinary.toString(), 32);
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
	
}
