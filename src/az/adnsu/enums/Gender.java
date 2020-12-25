package az.adnsu.enums;

public enum Gender {
	MALE("m"), FEMALE("f");

	private String value;

	private Gender(String gender) {
		this.value = gender;
	}

	public String getValue() {
		return value;
	}
}
