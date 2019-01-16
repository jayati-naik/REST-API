package main.com.rest.bean;

import java.net.Authenticator;

public class MyAuthenticator extends Authenticator {
	 private String username, password;

	    public MyAuthenticator(String user, String pass) {
	      this.setUsername(user);
	      this.setPassword(pass);
	    }

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}
}
