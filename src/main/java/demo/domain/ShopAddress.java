package demo.domain;

/**
 * @author Deepak Sangvikar
 *
 */
public class ShopAddress {

	private String number;

	private String postCode;

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ShopAddress [number=" + number + ", postCode=" + postCode + "]";
	}
 
	

}
