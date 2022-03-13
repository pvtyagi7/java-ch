package cafeProject;

public class Cafe {
	private Integer cafeId;
	private String cafeName;
	private String cafeAddress;
	
	public Cafe() {}
	public Cafe(Integer cafeId, String cafeName, String cafeAddress) {
		super();
		this.cafeId = cafeId;
		this.cafeName = cafeName;
		this.cafeAddress = cafeAddress;
	}
	public Integer getCafeId() {
		return cafeId;
	}
	public String getCafeName() {
		return cafeName;
	}
	public String getCafeAddress() {
		return cafeAddress;
	}
	
}
