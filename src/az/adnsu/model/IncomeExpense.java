package az.adnsu.model;

public class IncomeExpense {
	private Long id;
	private Double income;
	private Double expense;
	private Double result;
	private String incomeExpenseMonth;
	private Integer resultPercentage;

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
	public String getIncomeExpenseMonth() {
		return incomeExpenseMonth;
	}

	/**
	 * @param incomeExpenseMonth the incomeExpenseMonth to set
	 */
	public void setIncomeExpenseMonth(String incomeExpenseMonth) {
		this.incomeExpenseMonth = incomeExpenseMonth;
	}

	/**
	 * @return the resultPercentage
	 */
	public Integer getResultPercentage() {
		return resultPercentage;
	}

	/**
	 * @param resultPercentage the resultPercentage to set
	 */
	public void setResultPercentage(Integer resultPercentage) {
		this.resultPercentage = resultPercentage;
	}

}
