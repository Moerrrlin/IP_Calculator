package calc;

public class IPv6_Header {
    private int versionDec;
    private Binary versionBin;
	private int trafficClassDec;
    private Binary trafficClassBin;
	private int flowLabelDec;
    private Binary flowLabelBin;
	private int payloadLengthDec;
    private Binary payloadLengthBin;
	private int nextHeaderDec;
	private Binary nextHeaderBin;
	private int hopLimitDec;
	private Binary hopLimitBin;
    private IPv6_Address sourceAddress;
	private IPv6_Address destinationAddress;

	public void setVersion(int version){
		this.versionDec = version;
		this.versionBin = new Binary(Integer.toBinaryString(version), 4);
	}

	public void setVersion(Binary version){
		this.versionDec = Integer.parseInt(version.getValue(), 2);
		this.versionBin = version;
	}

	public void setTrafficClass(int trafficClass){
		this.trafficClassDec = trafficClass;
		this.trafficClassBin = new Binary(Integer.toBinaryString(trafficClass), 8);
	}

	public void setTrafficClass(Binary trafficClass){
		this.trafficClassDec = Integer.parseInt(trafficClass.getValue(), 2);
		this.trafficClassBin = trafficClass;
	}

	public void setFlowLabel(int flowLabel){
		this.flowLabelDec = flowLabel;
		this.flowLabelBin = new Binary(Integer.toBinaryString(flowLabel), 20);
	}

	public void setFlowLabel(Binary flowLabel){
		this.flowLabelDec = Integer.parseInt(flowLabel.getValue(), 2);
		this.flowLabelBin = flowLabel;
	}

	public void setPayloadLength(int payloadLength){
		this.payloadLengthDec = payloadLength;
		this.payloadLengthBin = new Binary(Integer.toBinaryString(payloadLength), 16);
	}

	public void setPayloadLength(Binary payloadLength){
		this.payloadLengthDec = Integer.parseInt(payloadLength.getValue(), 2);
		this.payloadLengthBin = payloadLength;
	}

	public void setNextHeader(int nextHeader){
		this.nextHeaderDec = nextHeader;
		this.nextHeaderBin = new Binary(Integer.toBinaryString(nextHeader), 8);
	}

	public void setNextHeader(Binary nextHeader){
		this.nextHeaderDec = Integer.parseInt(nextHeader.getValue(), 2);
		this.nextHeaderBin = nextHeader;
	}

	public void setHopLimit(int hopLimit){
		this.hopLimitDec = hopLimit;
		this.hopLimitBin = new Binary(Integer.toBinaryString(hopLimit), 8);
	}

	public void setHopLimit(Binary hopLimit){
		this.hopLimitDec = Integer.parseInt(hopLimit.getValue(), 2);
		this.hopLimitBin = hopLimit;
	}

	public void setSourceAddr(IPv6_Address sourceAddr){
		this.sourceAddress = sourceAddr;
	}

	public void setDestinationAddr(IPv6_Address destinationAddr){
		this.destinationAddress = destinationAddr;
	}

	public void displayDec(){
		System.out.println(this.versionDec);
		System.out.println(this.trafficClassDec);
		System.out.println(this.flowLabelDec);
		System.out.println(this.payloadLengthDec);
		System.out.println(this.nextHeaderDec);
		System.out.println(this.hopLimitDec);
		this.sourceAddress.displayHex();
		this.destinationAddress.displayHex();
	}

	public void displayBin(){
		System.out.println(this.versionBin.getValue());
		System.out.println(this.trafficClassBin.getValue());
		System.out.println(this.flowLabelBin.getValue());
		System.out.println(this.payloadLengthBin.getValue());
		System.out.println(this.nextHeaderBin.getValue());
		System.out.println(this.hopLimitBin.getValue());
		this.sourceAddress.displayBin();
		this.destinationAddress.displayBin();
	}

	public IPv6_Header(int version, int trafficClass, int flowLabel, int payloadLength, int nextHeader, int hopLimit, IPv6_Address sourceAddr, IPv6_Address destinationAddr){
		this.setVersion(version);
		this.setTrafficClass(trafficClass);
		this.setFlowLabel(flowLabel);
		this.setPayloadLength(payloadLength);
		this.setNextHeader(nextHeader);
		this.setHopLimit(hopLimit);
		this.setSourceAddr(sourceAddr);
		this.setDestinationAddr(destinationAddr);
	}

	public IPv6_Header(Binary version, Binary trafficClass, Binary flowLabel, Binary payloadLength, Binary nextHeader, Binary hopLimit, IPv6_Address sourceAddr, IPv6_Address destinationAddr){
		this.setVersion(version);
		this.setTrafficClass(trafficClass);
		this.setFlowLabel(flowLabel);
		this.setPayloadLength(payloadLength);
		this.setNextHeader(nextHeader);
		this.setHopLimit(hopLimit);
		this.setSourceAddr(sourceAddr);
		this.setDestinationAddr(destinationAddr);
	}
}