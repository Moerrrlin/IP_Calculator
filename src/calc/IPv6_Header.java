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

	public int getVersionDec(){
		return this.versionDec;
	}

	public void setTrafficClass(int trafficClass){
		this.trafficClassDec = trafficClass;
		this.trafficClassBin = new Binary(Integer.toBinaryString(trafficClass), 8);
	}

	public void setTrafficClass(Binary trafficClass){
		this.trafficClassDec = Integer.parseInt(trafficClass.getValue(), 2);
		this.trafficClassBin = trafficClass;
	}

	public int getTrafficClassDec(){
		return this.trafficClassDec;
	}

	public void setFlowLabel(int flowLabel){
		this.flowLabelDec = flowLabel;
		this.flowLabelBin = new Binary(Integer.toBinaryString(flowLabel), 20);
	}

	public void setFlowLabel(Binary flowLabel){
		this.flowLabelDec = Integer.parseInt(flowLabel.getValue(), 2);
		this.flowLabelBin = flowLabel;
	}

	public int getFlowLabelDec(){
		return this.flowLabelDec;
	}

	public void setPayloadLength(int payloadLength){
		this.payloadLengthDec = payloadLength;
		this.payloadLengthBin = new Binary(Integer.toBinaryString(payloadLength), 16);
	}

	public void setPayloadLength(Binary payloadLength){
		this.payloadLengthDec = Integer.parseInt(payloadLength.getValue(), 2);
		this.payloadLengthBin = payloadLength;
	}

	public int getPayloadLengthDec(){
		return this.payloadLengthDec;
	}

	public void setNextHeader(int nextHeader){
		this.nextHeaderDec = nextHeader;
		this.nextHeaderBin = new Binary(Integer.toBinaryString(nextHeader), 8);
	}

	public void setNextHeader(Binary nextHeader){
		this.nextHeaderDec = Integer.parseInt(nextHeader.getValue(), 2);
		this.nextHeaderBin = nextHeader;
	}

	public int getNextHeaderDec(){
		return this.nextHeaderDec;
	}

	public void setHopLimit(int hopLimit){
		this.hopLimitDec = hopLimit;
		this.hopLimitBin = new Binary(Integer.toBinaryString(hopLimit), 8);
	}

	public void setHopLimit(Binary hopLimit){
		this.hopLimitDec = Integer.parseInt(hopLimit.getValue(), 2);
		this.hopLimitBin = hopLimit;
	}

	public int getHopLimitDec(){
		return this.hopLimitDec;
	}

	public void setSourceAddr(IPv6_Address sourceAddr){
		this.sourceAddress = sourceAddr;
	}

	public IPv6_Address getSourceAddr(){
		return this.sourceAddress;
	}

	public void setDestinationAddr(IPv6_Address destinationAddr){
		this.destinationAddress = destinationAddr;
	}

	public IPv6_Address getDestinationAddr(){
		return this.destinationAddress;
	}

	public void displayDec(){
		char seperator = '-';
		System.out.print(this.versionDec);
		System.out.print(seperator);
		System.out.print(this.trafficClassDec);
		System.out.print(seperator);
		System.out.print(this.flowLabelDec);
		System.out.print(seperator);
		System.out.print(this.payloadLengthDec);
		System.out.print(seperator);
		System.out.print(this.nextHeaderDec);
		System.out.print(seperator);
		System.out.print(this.hopLimitDec);
		System.out.print(seperator);
		this.sourceAddress.displayHex();
		System.out.print(seperator);
		this.destinationAddress.displayHex();
	}

	public void displayBin(){
		char seperator = ' ';
		System.out.print(this.versionBin.getValue());
		System.out.print(seperator);
		System.out.print(this.trafficClassBin.getValue());
		System.out.print(seperator);
		System.out.print(this.flowLabelBin.getValue());
		System.out.print(seperator);
		System.out.print(this.payloadLengthBin.getValue());
		System.out.print(seperator);
		System.out.print(this.nextHeaderBin.getValue());
		System.out.print(seperator);
		System.out.print(this.hopLimitBin.getValue());
		System.out.print(seperator);
		this.sourceAddress.displayBin();
		System.out.print(seperator);
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