package calc;

public class IPv6_Address{
    private String[] addressHex = new String[8];
    private Binary[] addressBin = new Binary[8];

    public void setAddressHex(String[] addr){
        addressHex = addr;
    }

    public void setAddressBin(Binary[] addr){
        addressBin = addr;
    }

    public String[] getAddressHex(){
        return addressHex;
    }

    public String getAddressHex(int i){
        return addressHex[i];
    }

    public Binary getAddressBin(){
        return addressBin;
    }
    
    public Binary getAddressBin(int i){
        return addressBin[i];
    }

    public void toStringHex(){
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

    public void toStringBin(){
        String string = "";
        for(int i = 0; i < 8; i++){
            string += getAddressBin(i);
        }
        return string;
    }
    
    public void displayBin(){
        System.out.println(toStringBin());
    }

    public String toBinary(){
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

    public string toHexadecimal(){
        String addressHexadecimal = "";

        return addressHexadecimal;
    }

    public IPv6_Address(String[] addr){
        addressHex = addr;
        addressBin = addr.toBinary();
    }
    
    public IPv6_Address(Binary[] addr){
        addressBin = addr;
        addressHex = addr.toHexadecimal();
    }
}
