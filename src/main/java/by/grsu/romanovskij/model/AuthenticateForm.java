package by.grsu.romanovskij.model;

public class AuthenticateForm {
	private String username;
	private String password;

	private boolean savePass;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean isSavePass() {
		return savePass;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSavePass(boolean savePass) {
		this.savePass = savePass;
	}
}
