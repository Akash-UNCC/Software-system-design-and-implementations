import java.util.Date;

public class UserBean {
	
      private String username;
      private String password;
      private String firstName;
      private String lastName;
      private String amount;
      private String account;
      private String from;
      private String to;
      
      public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		 this.from= from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String date_to) {
		this.to = date_to;
	}

	public boolean valid;
	
	
      public String getFirstName() {
         return firstName;
	 }

      public void setFirstName(String newFirstName) {
         firstName = newFirstName;
	 }

	
      public String getLastName() {
         return lastName;
			}

      public void setLastName(String newLastName) {
         lastName = newLastName;
			}
			

      public String getPassword() {
         return password;
	}

      public void setPassword(String newPassword) {
         password = newPassword;
	}
	
			
      public String getUsername() {
         return username;
			}

      public void setUserName(String newUsername) {
         username = newUsername;
			}

				
      public boolean isValid() {
         return valid;
	}

      public void setValid(boolean newValid) {
         valid = newValid;
	}

	public void setAmount(String newAmount) {
		 amount = newAmount;
		
	}	
	
	public void setAccount(String newAccount) {
         account = newAccount;
		
	}


	public String getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}

	public String getAccount() {
		// TODO Auto-generated method stub
		return account;
	}
	
}
