package infy.library.service;

import infy.library.entity.Book;
import infy.library.entity.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class LibraryService {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Library");
	EntityManager em=null;
	/* This method will persist the transaction details(issue book details) to Transaction table.
	 * Also update the book status to 'I' in book table.
	 * @param: empId:String, bookId:String
	 * @return: transactionId : Integer
	 * @throws: Exception
	 */
	public Integer issueBook(String empId, String bookId) throws Exception {
	
		Transaction t=new Transaction();
		try {
			
			em=emf.createEntityManager();
			em.getTransaction().begin();
			
			Book b=em.find(Book.class, bookId);
			if(b.getBookStatus().equals("I")){
				throw new Exception("Book is already issued");
			}
			t.setEmpId(empId);
			t.setIssueDate(new Date());
			t.setBookId(bookId);
			em.persist(t);
			b.setBookStatus("I");
			em.getTransaction().commit();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(em!=null) {
				em.close();
			}
		}
		
		return t.getTransactionId();
	}

	/* This Method will query the Employee table and get all emplyeeIds.  
	 * @return:List<String> - List of EmployeeIds
	 * @throws: Exception	
	 */
	public List<String> getEpmloyeeList() throws Exception {
		
		List<String> empList=null;
		try {
			em=emf.createEntityManager();
			Query query=em.createQuery("select p.empId from Employee p");
			empList=query.getResultList();
			if(empList.isEmpty()) {
				throw new Exception("No Employees found");
			}
		}
		finally {
			if(em!=null) {
				em.close();
			}
		}
		return empList;
	}
	
	/* This method will get all books available under the given bookType.
	 * @param: bookType:String
	 * @return: List<Book> - return list of Book entity objects
	 * @throws: Exception
	 */
	
	public List<Book> getBookList(String bookType) throws Exception {
		
		List<Book> bookList=new ArrayList<Book>();
		try {
			em=emf.createEntityManager();
			Query query=em.createQuery("select p from Book p where p.bookType=?1 and p.bookStatus='A'");
			query.setParameter(1,bookType);
			//query.setParameter(2,"A");
			bookList =query.getResultList();
				
			if(bookList.isEmpty()) {
				throw new Exception("No Books found for selected type/ All books are issued");
			}
		}
		finally {
			if(em!=null) {
				em.close();
			}
		}
		System.out.println("Size :"+bookList.size());
		
		return bookList;
	}

	/* This method will return the transaction details for all books under given book types.
	 * @param: List<String> - List of book types 
	 * @return: List<Transaction> - List of Transaction onjects
	 * @throws: Exception 
	 */
	public List<Transaction> getTransactionDetails(List<String> bookTypes) throws Exception {
	
		List<Transaction> transactionList=new ArrayList<Transaction>();
		try {
			em=emf.createEntityManager();
			List<String>bookIds=null;
		
			for(int i=0;i<bookTypes.size();i++){
				Query query1=em.createQuery("select t.bookId from Book t where t.bookType=?1");
				query1.setParameter(1, bookTypes.get(i));
				bookIds=query1.getResultList();
		
				for(int k=0;k<bookIds.size();k++){
					Query query2=em.createQuery("select t from Transaction t where t.bookId=?1");
					query2.setParameter(1, bookIds.get(k));
					List<Transaction>TransList=query2.getResultList();
				
					for(int j=0;j<TransList.size();j++){
						transactionList.add(TransList.get(j));
					}
				}
		
			}
		System.out.println("*********List size in tras"+transactionList.size());
			if(transactionList.isEmpty()) {
				throw new Exception("No Transaction details found for the selected type");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
		finally {
			if(em!=null) {
				em.close();
			}
		}
		return transactionList;
	}
	

	/* This method will return the transaction details whose issue date is less than equal to given date and 
	 * return date is null.
	 * @param: date:Date 
	 * @return: List<Transaction> - List of Transaction onjects
	 * @throws: Exception 
	 */
	public List<Transaction> getTransactionDetails(Date date) throws Exception {
	
		List<Transaction> transactionList=null;
		try {
			em=emf.createEntityManager();
			Query query=em.createQuery("select t from Transaction t where t.issueDate<=?1 and t.returnDate is null");
			query.setParameter(1,date);
			transactionList=query.getResultList();
			System.out.println("Transaction list is"+transactionList);
			if(transactionList.isEmpty()) {
				throw new Exception("No Transaction details found for the given date");
			}
		}
		finally {
			if(em!=null) {
				em.close();
			}
		}
		return transactionList;
	}

/* This method update the return date of Transaction table with current date 
 * and also update the book status to 'A'
 * @param: tranctionId: Integer
 * @return: void
 * @throws: Exception
 */
	public void returnBook(Integer transactionId) throws Exception {

		try {
		
			em=emf.createEntityManager();
			em.getTransaction().begin();
			Transaction t=em.find(Transaction.class,transactionId);
			if(t==null){
				throw new Exception("No transaction found");
			}
			else{
				t.setReturnDate(new Date());
				Book b=em.find(Book.class,t.getBookId());
				b.setBookStatus("A");
		}
		
		em.getTransaction().commit();
		}
		finally {
			if(em!=null) {
				em.close();
			}
		}
	}
}
