package calc;

public class IPv6_Address{
    private String[] address = new String[8];

    public void setAddress(String[] addr){
        address = addr;
    }

    public String[] getAddress(){
        return address;
    }

    public String getAddress(int i){
        return address[i];
    }

    public String toString(){
        String string = "";
        for(int i = 0; i < 8; i++){
            string += getAddress(i);
        }
        return string;
    }

    public void display(){
        String string = "";
        for(int i = 0; i < 8; i++){
            string += getAddress(i);
            if(i < 8 - 1){
                string += ":";
            }
        }
        System.out.println(string);
    }

    public String toBinaryString(){
        String hex = "0123456789ABCDEF";
        String addressBinary = "";
        for(int i = 0; i < 8; i++){
            String addressElement = this.getAddress(i).toUpperCase();
            for(int j = 0; j < 4; j++){
                char addressElementChar = addressElement.charAt(j);
                Binary addressElementBinary = new Binary(Integer.toBinaryString(hex.indexOf(addressElementChar)));

                addressBinary += Binary.leadingZero(addressElementBinary.getValue(), 4);
            }
        }
        return addressBinary;
    }

    public IPv6_Address(String[] addr){
        address = addr;
    }
}
