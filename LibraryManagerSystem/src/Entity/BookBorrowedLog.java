package Entity;

import java.sql.Date;

public class BookBorrowedLog {
	private String BookID;
	private String BorrowerAccount;
	private Date BorrowDate;
	private Date ReturnDateDeadLine;
	private Date ReturnDateInFact;
	public String getBookID() {
		return BookID;
	}
	public void setBookID(String bookID) {
		BookID = bookID;
	}
	public String getBorrowerAccount() {
		return BorrowerAccount;
	}
	public void setBorrowerAccount(String borrowerAccount) {
		BorrowerAccount = borrowerAccount;
	}
	public Date getBorrowDate() {
		return BorrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		BorrowDate = borrowDate;
	}
	public Date getReturnDateDeadLine() {
		return ReturnDateDeadLine;
	}
	public void setReturnDateDeadLine(Date returnDateDeadLine) {
		ReturnDateDeadLine = returnDateDeadLine;
	}
	public Date getReturnDateInFact() {
		return ReturnDateInFact;
	}
	public void setReturnDateInFact(Date returnDateInFact) {
		ReturnDateInFact = returnDateInFact;
	}
}
