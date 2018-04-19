package by.grsu.romanovskij.DataTransferObject;

import by.grsu.romanovskij.constraint.FieldMatch;

import javax.validation.constraints.*;

@FieldMatch.List({
		@FieldMatch(first = "userPassword", second = "userConfirmPassword", message = "Пароли не совпадают"),
})
public class UserRegistrationDto {

	@NotEmpty
	private String userFirstName;

	@NotEmpty
	private String userLastName;

	@NotEmpty
	private String userPassword;

	@NotEmpty
	private String userConfirmPassword;

	@Email
	@NotEmpty
	private String userEmail;

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserConfirmPassword() {
		return userConfirmPassword;
	}

	public void setUserConfirmPassword(String userConfirmPassword) {
		this.userConfirmPassword = userConfirmPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
