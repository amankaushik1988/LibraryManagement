package infy.library.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Transaction{
	
	@Id
	//@SequenceGenerator(name="seq_TransId",sequenceName="seq_TransId",initialValue=2005,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer transactionId ;
	private String empId;
	private String bookId;
	@Temporal(TemporalType.DATE)
	private Date issueDate;
	@Temporal(TemporalType.DATE)
	private Date returnDate;
	
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
		
}
