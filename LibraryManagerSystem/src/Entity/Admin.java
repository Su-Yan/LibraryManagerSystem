package Entity;

public class Admin extends User {
	private String BookManager;
	private String UserManager;
	public String getBookManager() {
		return BookManager;
	}
	public void setBookManager(String bookManager) {
		BookManager = bookManager;
	}
	public String getUserManager() {
		return UserManager;
	}
	public void setUserManager(String userManager) {
		UserManager = userManager;
	}
	public String getAdminManager() {
		return AdminManager;
	}
	public void setAdminManager(String adminManager) {
		AdminManager = adminManager;
	}
	private String AdminManager;
}
