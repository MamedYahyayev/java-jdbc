package az.adnsu.model;

public class Tax {
	private Long id;
	private String taxName;

	public Tax() {

	}

	public Tax(Long id, String taxName) {
		this.id = id;
		this.taxName = taxName;
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
	 * @return the taxName
	 */
	public String getTaxName() {
		return taxName;
	}

	/**
	 * @param taxName the taxName to set
	 */
	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	@Override
	public String toString() {
		return "id=" + id + ", taxName=" + taxName;
	}

}
