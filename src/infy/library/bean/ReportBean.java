package infy.library.bean;

import infy.library.entity.Transaction;
import infy.library.service.LibraryService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReportBean {
	private List<String>bookTypes;
	private List<Transaction>transactionDetails;
	private String message;
	public List<String> getBookTypes() {
		return bookTypes;
	}
	public void setBookTypes(List<String> bookTypes) {
		this.bookTypes = bookTypes;
	}
	public List<Transaction> getTransactionDetails() {
		return transactionDetails;
	}
	public void setTransactionDetails(List<Transaction> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String generateTransactionDetails()
	{
		LibraryService libraryService=new LibraryService();
		transactionDetails=new ArrayList<Transaction>();
		try 
		{
			List<Transaction> list=libraryService.getTransactionDetails(this.getBookTypes());
			System.out.println("siss***::"+list.size());
			for(int i=0;i<list.size();i++){
				transactionDetails.add(list.get(i));
			}/*
			Iterator<Transaction> iterator=list.iterator();
			while (iterator.hasNext()) {
				transactionDetails.add(iterator.next());
			}*/
			System.out.println("*****deta inbean"+transactionDetails.size());
			return "success";
		} catch (Exception e) {
			this.message= e.getMessage();
			e.printStackTrace();
			return "failure";
		}
		
	}
}
