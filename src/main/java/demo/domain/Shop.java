package demo.domain;

/**
 * @author Deepak Sangvikar
 *
 *This is POJO to hold shop information and address details
 */
public class Shop {
 
	private String shopName;
	
	private ShopAddress shopAddress;
	
	private double shopLongitude;
	
	private double shopLattitude;

	/**
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * @return the shopAddress
	 */
	public ShopAddress getShopAddress() {
		return shopAddress;
	}

	/**
	 * @param shopAddress the shopAddress to set
	 */
	public void setShopAddress(ShopAddress shopAddress) {
		this.shopAddress = shopAddress;
	}

	/**
	 * @return the shopLongitude
	 */
	public double getShopLongitude() {
		return shopLongitude;
	}

	/**
	 * @param shopLongitude the shopLongitude to set
	 */
	public void setShopLongitude(double shopLongitude) {
		this.shopLongitude = shopLongitude;
	}

	/**
	 * @return the shopLattitude
	 */
	public double getShopLattitude() {
		return shopLattitude;
	}

	/**
	 * @param shopLattitude the shopLattitude to set
	 */
	public void setShopLattitude(double shopLattitude) {
		this.shopLattitude = shopLattitude;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Shop [shopName=" + shopName + ", shopAddress=" + shopAddress + ", shopLongitude=" + shopLongitude
				+ ", shopLattitude=" + shopLattitude + "]";
	}
	
	
	
}
