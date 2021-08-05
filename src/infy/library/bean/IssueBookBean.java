package infy.library.bean;

import infy.library.entity.Book;
import infy.library.service.LibraryService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

public class IssueBookBean { 
	private String empId;
	private String bookType;
	private List<SelectItem> empIdList=new ArrayList<SelectItem>();
	private List<SelectItem> bookNameList=new ArrayList<SelectItem>();
	private String bookId;
	private Integer transactionId;
	private String message;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public List<SelectItem> getEmpIdList() {
		return empIdList;
	}
	public void setEmpIdList(List<SelectItem> empIdList) {
		this.empIdList = empIdList;
	}
	public List<SelectItem> getBookNameList() {
		return bookNameList;
	}
	public void setBookNameList(List<SelectItem> bookNameList) {
		this.bookNameList = bookNameList;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
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
	public IssueBookBean()
	{
		LibraryService libraryService=new LibraryService();
		try 
		{
			List<String>list=libraryService.getEpmloyeeList();
			for(String s:list)
			{
				this.empIdList.add(new SelectItem(s));
			}

		} catch (Exception e) {
			
					this.message=e.getMessage();
					
			
		}
		
	}
	public void getBookNames(ValueChangeEvent event)
	{
		LibraryService libraryService=new LibraryService();
		String bookType=(String)event.getNewValue();
		System.out.print("Enter"+event.getNewValue());
		//System.out.println(bookType);
		List<Book> list=null;
		
		try 
		{
			
			bookNameList.clear();
			list=libraryService.getBookList(bookType);
			System.out.println("Ret Size"+list.size());
			//System.out.println("************"+list.size());
			Iterator<Book> iterator=list.iterator();
			while(iterator.hasNext())
			{
				Book book=iterator.next();
				bookNameList.add(new SelectItem(book.getBookId(),book.getBookName()));
				System.out.println("aman"+bookNameList);
			}
			

		} catch (Exception e) {
			
					this.message=e.getMessage();
					e.printStackTrace();
					
					
			
		}
		
	}
	public String issueBook()
	{
		LibraryService libraryService=new LibraryService();
		try 
		{
			this.transactionId=libraryService.issueBook(this.empId, this.bookId);
			System.out.println("transactiond is"+this.transactionId);
			return "success";
		} catch (Exception e) {
			
					this.message=e.getMessage();
					return "failure";
		}
		
	}
	
	
	
}
