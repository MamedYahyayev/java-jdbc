package az.adnsu.model;

public class Debt {
	private Long id;
	private String month;
	private Double debt;
	private Boolean isPaid = Boolean.FALSE;
	private Tax tax;

	public Debt() {

	}

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
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return the debt
	 */
	public Double getDebt() {
		return debt;
	}

	/**
	 * @param debt the debt to set
	 */
	public void setDebt(Double debt) {
		this.debt = debt;
	}

	/**
	 * @return the isPaid
	 */
	public Boolean getIsPaid() {
		return isPaid;
	}

	/**
	 * @param isPaid the isPaid to set
	 */
	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}

	/**
	 * @return the tax
	 */
	public Tax getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(Tax tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "id=" + id + ", month=" + month + ", debt=" + debt + ", isPaid=" + isPaid + ", tax=" + tax.getTaxName();
	}

}
