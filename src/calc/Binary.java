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
    public String leadingZero(String s, int b) {
		while (s.length() < b) {
			s = '0' + s;
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
}
