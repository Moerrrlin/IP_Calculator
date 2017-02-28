package calc;

public class IPv6_Address{
    private String[] address_hex = new String[8];
    private String address_bin = "";

    public void setAddressHex(String[] addr){
        address_hex = addr;
    }

    public void setAddressBin(String addr){
        address_bin = addr;
    }

    public String[] getAddressHex(){
        return address_hex;
    }

    public String getAddressHex(int i){
        return address_hex[i];
    }

    public String getAddressBin(){
        return address_bin;
    }

    public String toStringHex(){
        String string = "";
        for(int i = 0; i < 8; i++){
            string += getAddressHex(i);
        }
        return string;
    }

    public void displayHex(){
        String string = "";
        for(int i = 0; i < 8; i++){
            string += getAddressHex(i);
            if(i < 8 - 1){
                string += ":";
            }
        }
        System.out.println(string);
    }

    public void displayBin(){
        String string = "";
        for(int i = 0; i < 8; i++){
            string += getAddressBin(i);
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
            String addressElement = this.getAddressHex(i).toUpperCase();
            for(int j = 0; j < 4; j++){
                char addressElementChar = addressElement.charAt(j);
                Binary addressElementBinary = new Binary(Integer.toBinaryString(hex.indexOf(addressElementChar)));

                addressBinary += Binary.leadingZero(addressElementBinary.getValue(), 4);
            }
        }
        return addressBinary;
    }

    public string toHexadecimalString(){
        String addressHexadecimal = "";

        return addressHexadecimal;
    }

    public IPv6_Address(String[] addr){
        address_hex = addr;
    }
}
