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
    	// FIXME
    	// TODO how to do this properly
    	String[] ipPartsSourceIP = header.getSource_ip().split("\\.");
    	
		String v = "";
    	v =leadingZero(header.getVersion(), 4) + leadingZero(header.getIhl(), 4) + leadingZero(header.getTos(),	8)
    		+ leadingZero(header.getTotal_length(), 16) + leadingZero(header.getId(), 16) + header.getFlag()
    		+ leadingZero(header.getFragment_offset(), 13) + leadingZero(header.getTtl(), 8) 
    		+ leadingZero(header.getProtocol(), 8) // + leadingZero(header.getChecksum(), 16)
    		+ leadingZero(s, length);
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
