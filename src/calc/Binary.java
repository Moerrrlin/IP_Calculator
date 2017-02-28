package calc;
import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

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

    public static Boolean isBinary(String s){
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case '0':   break;
                case '1':   break;
                default:    return false;
            }
        }
        return true;
    }

    public static String leadingZero(String s, int length) {
		while (s.length() < length) {
			s = '0' + s;
		}
		return s;
	}

    public static String leadingZero(int i, int length) {
    	String s  = Integer.toBinaryString(i);
    	while  (s.length() < length) {
    		s = "0" + s;
    	}
    	return s;
    }

	public String toDecimalHeaderString() {
		try {
			char seperator = '-';
			char ctr = '.'; //for IP address formatting
			String output = "";
			String sHeader = this.getValue();
			//binary string is entered with whitespace
			if (sHeader.contains(" ")) {
				// "\\s" is regular expression for whitespace
				String[] bHeaderArray = sHeader.split("\\s");
				for (int i = 0; i < (bHeaderArray.length); i++) {
					if (isBinary(bHeaderArray[i])) {
						if (i == 5) {
							output += bHeaderArray[i] + seperator;
						}else if (i == bHeaderArray.length -2) { //source IP location
							String ip1 = "";
							for (int j = 0; j < bHeaderArray[i].length(); j+=8) {
								int dectemp = Integer.parseInt(bHeaderArray[i].substring(j, j+8), 2);
								if (j == 24) {
									ip1 += Integer.toString(dectemp);
									output += ip1 + seperator;
								} else {
									ip1 += Integer.toString(dectemp) + ctr;
								}
							}
						} else if (i == bHeaderArray.length -1) { //destination IP location
							String ip2 = "";
							for (int j = 0; j < bHeaderArray[i].length(); j+=8) {
								int dectemp = Integer.parseInt(bHeaderArray[i].substring(j, j+8), 2);
								if (j == 24) {
									ip2 += Integer.toString(dectemp);
									output += ip2;
								} else {
									ip2 += Integer.toString(dectemp) + ctr;
								}
							}
						} else {
							int temp = Integer.parseInt(bHeaderArray[i],2);
							output += Integer.toString(temp) + seperator;
						}
					} else {
						throw new RuntimeException("The entered string is not in binary notation");
					}
				}
				return output;
			//entered string doesn't contain whitespace
			} else if (isBinary(sHeader)) {
				/* Iterates over list fieldLengths and adds parts
				 * of different lengths (elements of list) of a given string to an array list
				 * string must be binary; conversion to decimal
				 */
				output = "";
				final List<Integer> fieldLengths = asList(
						4, 4, 8, 16, 16, 3, 13, 8, 8, 16,
						8, 8, 8, 8, //Source IP split
						8, 8, 8, 8 // Destination IP split
				);
				int counter = 0;
				ArrayList<Integer> decValues = new ArrayList<Integer>();
				for (Integer field : fieldLengths) {
					//parsing the bit segments per substring function to Integer (radix 2)
					decValues.add(Integer.parseInt(sHeader.substring(counter, counter+field),2));
					counter += field;
				}
				//concatenate the first 5 fields to the output
				for (int i = 0; i <5 ; i++) {
					output += decValues.get(i).toString() + seperator;
				}
				//get Flags from binary input
				output += sHeader.substring(47, 50) + seperator;
				//get next four fields after flags
				for (int i = 6; i <= 9; i++) {
					output += decValues.get(i).toString() + seperator;
				}
				String ip1 = "";
				String ip2 = "";
				for (int i = 10; i < decValues.size(); i++) {
					//get next four fields = source IP
					if (i < 13) {
						ip1 += decValues.get(i).toString() + ctr;
					//last concatenation without dot
					} else if (i == 13) {
						ip1 += decValues.get(i).toString();
					//last concatenation without dot
					} else if (i > 13 && (i == decValues.size() -1)) {
						ip2 += decValues.get(i).toString();
					} else if (i > 13) {
						ip2 += decValues.get(i).toString() + ctr;
					}
				}
				output += ip1 + seperator + ip2;
				return output;
			} else {
				throw new RuntimeException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "An error occured.";
		}
	}
	//not used, can be used. I didn't use it, don't ask why.
	private String removeWhitespace(Binary b) {
		String s = b.getValue().replaceAll("\\s","");
		if(isBinary(s)) {
			return s;
		} else {
			throw new RuntimeException("The input is not in binary notation!");
		}
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
