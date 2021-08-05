package infy.library.bean;

import infy.library.entity.Transaction;
import infy.library.service.LibraryService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

public class ReturnBookBean {
	
	private Date transactionDate ;
	private List<SelectItem> transactionList;
	private Integer transactionId;
	private String message;
	
/* This is a value change listener method,
 * This will get the date from the ValueCahngeEvent object and invoke getTransactionDetails(date)method 
 * of LibraryService class and create the SelectItem object to populate the transactionId drop down list.
 * @param: event:ValueChangeEvent
 * @return: void
 */
	public void generateTranactionDetails(ValueChangeEvent event){
		this.message=null;
		transactionList=null;
		Date date=(Date)event.getNewValue();
		transactionList=new ArrayList<SelectItem>();
		try{
			System.out.println("Date is"+date);
			List<Transaction>transactionDetails=new LibraryService().getTransactionDetails(date);
			for(int index=0;index<transactionDetails.size();index++){
				SelectItem transId=new SelectItem(transactionDetails.get(index).getTransactionId());
				System.out.println("TRANS ID is"+transId);
				transactionList.add(transId);
			}
		}catch(Exception e){
			transactionList=null;
			this.message=e.getMessage();
		}
	}

/* This is an action listener method.
 * This method will invoke the returnBook() method of LibraryService class.
 * @return: String
 */
	public String returnBook(){
		try{
			new LibraryService().returnBook(this.transactionId);
			this.message="Book Rturned Succefully";
			return "success";
		}catch(Exception e){
			this.message=e.getMessage();
			return "failure";
		}
	}
	
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public List<SelectItem> getTransactionList() {
		return transactionList;
	}
	public void setTransactionList(List<SelectItem> transactionList) {
		this.transactionList = transactionList;
	}
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
