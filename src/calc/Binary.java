public class Binary {
    private String value;

    public void setValue(String s) {
        value = s;
    }
    public void setValue(int i){
        value = Integer.ToBinaryString(i);
    }
    public String getValue() {
        return value;
    }
    public void Binary() {
        value = '0';
    }
    public void Binary(String s) {
        value = s;
    }
    public void Binary(int i){
        value = Integer.ToBinaryString(i);
    }
}
