package calc;

public class IPv4_Header {
	private int version;
	private int ihl; // IP header length
	private int tos; // type of service
	private int total_length;
	private int id; // identification
	private String flag = "000";
	private int fragment_offset;
	private int ttl;
	private int protocol;
	private String source_ip; // source IP address
	private String destination_ip; // destination IP address

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		if (version == 4 || version == 6) {
			this.version = version;
		}	
		else {
			throw new RuntimeException("Nur 4 oder 6 gültig");
		}
	}

	public void setVersion(String input) {
		int v = Integer.parseInt(input);
		setVersion(v);
	}

	public int getIhl() {
		return ihl;
	}

	public void setIhl(int ihl) {
		if (ihl >= 5 && ihl <= 15) { // IHL is only allowed between 5 (20 bytes) and 15 (60 bytes)
			this.ihl = ihl;
		} else {
			throw new RuntimeException("Wert ist außerhalb der gültigen Headersize.\n");
		}
	}
	
	public void setIhl(String input) {
		int ihl = Integer.parseInt(input);
		setIhl(ihl);
	}

	public int getTos() {
		return tos;
	}

	public void setTos(int tos) {
		this.tos = tos;
	}
	public void setTos(String input) {
		int tos = Integer.parseInt(input);
		setTos(tos);
	}

	public int getTotal_length() {
		return total_length;
	}

	public void setTotal_length(int total_length) {
		this.total_length = total_length;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setId(String input) {
		int id = Integer.parseInt(input);
		setId(id);
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getFragment_offset() {
		return fragment_offset;
	}

	public void setFragment_offset(int fragment_offset) {
		this.fragment_offset = fragment_offset;
	}
	
	public void setFragment_offset(String input) {
		int offset = Integer.parseInt(input);
		setFragment_offset(offset);
	}

	public int getTtl() {
		return ttl;
	}

	public void setTtl(int ttl) {
		this.ttl = ttl;
	}
	
	public void setTtl(String input) {
		int ttl = Integer.parseInt(input);
		setTtl(ttl);
	}

	public int getProtocol() {
		return protocol;
	}

	public void setProtocol(int protocol) {
		this.protocol = protocol;
	}

	public String getSource_ip() {
		return source_ip;
	}

	public void setSource_ip(String source_ip) {
		this.source_ip = source_ip;
	}

	public String getDestination_ip() {
		return destination_ip;
	}

	public void setDestination_ip(String destination_ip) {
		this.destination_ip = destination_ip;
	}

}
