package az.adnsu.model;

public class IncomeExpense {
	private Long id;
	private Double income;
	private Double expense;
	private Double result;
	private Integer incomeExpenseMonth;

	public IncomeExpense() {

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
	 * @return the income
	 */
	public Double getIncome() {
		return income;
	}

	/**
	 * @param income the income to set
	 */
	public void setIncome(Double income) {
		this.income = income;
	}

	/**
	 * @return the expense
	 */
	public Double getExpense() {
		return expense;
	}

	/**
	 * @param expense the expense to set
	 */
	public void setExpense(Double expense) {
		this.expense = expense;
	}

	/**
	 * @return the result
	 */
	public Double getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(Double result) {
		this.result = result;
	}

	/**
	 * @return the incomeExpenseMonth
	 */
	public Integer getIncomeExpenseMonth() {
		return incomeExpenseMonth;
	}

	/**
	 * @param incomeExpenseMonth the incomeExpenseMonth to set
	 */
	public void setIncomeExpenseMonth(Integer incomeExpenseMonth) {
		this.incomeExpenseMonth = incomeExpenseMonth;
	}

	@Override
	public String toString() {
		return "id=" + id + ", income=" + income + ", expense=" + expense + ", result=" + result
				+ ", incomeExpenseMonth=" + incomeExpenseMonth;
	}

}
