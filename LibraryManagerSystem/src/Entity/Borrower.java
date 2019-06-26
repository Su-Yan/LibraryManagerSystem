package Entity;

public class Borrower extends User {
	private String IdentifyID;
	private String WorkAddress;
	private int BorrowerAmount;
	private float Fine;
	public String getIdentifyID() {
		return IdentifyID;
	}
	public void setIdentifyID(String identifyID) {
		IdentifyID = identifyID;
	}
	public String getWorkAddress() {
		return WorkAddress;
	}
	public void setWorkAddress(String workAddress) {
		WorkAddress = workAddress;
	}
	public int getBorrowerAmount() {
		return BorrowerAmount;
	}
	public void setBorrowerAmount(int borrowerAmount) {
		BorrowerAmount = borrowerAmount;
	}
	public float getFine() {
		return Fine;
	}
	public void setFine(float fine) {
		Fine = fine;
	}
	
}
