package az.adnsu.model;

import java.util.Date;

public class Items {
	private Long id;
	private String itemName;
	private String itemType;
	private Double itemPrice;
	private Date boughtAt;
	private Boolean isAvailable = Boolean.TRUE;

	public Items() {

	}

	// getters and setters

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemType
	 */
	public String getItemType() {
		return itemType;
	}

	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	/**
	 * @return the itemPrice
	 */
	public Double getItemPrice() {
		return itemPrice;
	}

	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * @return the boughtAt
	 */
	public Date getBoughtAt() {
		return boughtAt;
	}

	/**
	 * @param boughtAt the boughtAt to set
	 */
	public void setBoughtAt(Date boughtAt) {
		this.boughtAt = boughtAt;
	}

	/**
	 * @return the isAvailable
	 */
	public Boolean getIsAvailable() {
		return isAvailable;
	}

	/**
	 * @param isAvailable the isAvailable to set
	 */
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "id=" + id + ", itemName=" + itemName + ", itemType=" + itemType + ", itemPrice=" + itemPrice
				+ ", boughtAt=" + boughtAt + ", isAvailable=" + isAvailable;
	}

}
