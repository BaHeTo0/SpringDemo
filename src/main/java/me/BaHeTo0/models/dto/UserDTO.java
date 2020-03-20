package me.BaHeTo0.models.dto;

public class UserDTO {

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	private String username;
	private String password;
	
	public UserDTO(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
