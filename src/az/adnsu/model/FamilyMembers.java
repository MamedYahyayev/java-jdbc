package az.adnsu.model;

import az.adnsu.enums.FamilyRole;
import az.adnsu.enums.Gender;

public class FamilyMembers {
	private Long id;
	private String name;
	private String surname;
	private int age;
	private Gender gender;
	private Double salary;
	private FamilyRole role;

	public FamilyMembers() {

	}

	public FamilyMembers(String name, String surname, Double salary) {
		this.name = name;
		this.surname = surname;
		this.salary = salary;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender.getValue();
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		if (gender.equals("m") || gender.equals("male"))
			this.gender = Enum.valueOf(Gender.class, Gender.MALE.name());
		else if (gender.equals("f") || gender.equals("female"))
			this.gender = Enum.valueOf(Gender.class, Gender.FEMALE.name());
	}

	/**
	 * @return the salary
	 */
	public Double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role.name();
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = Enum.valueOf(FamilyRole.class, role);
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", gender=" + gender
				+ ", salary=" + salary + ", role=" + role;
	}

}
