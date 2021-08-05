package infy.library.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Book{
	
	@Id
	private String bookId ;
	private String bookName;
	private String bookType;
	private String bookStatus;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	
	
	
	
}
