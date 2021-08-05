<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %> 
<%@ page import="java.io.File" %> 
 <%@ page import="org.apache.commons.fileupload.servlet.*"%>  

<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<center><table border="2">        
<tr> <td><h1>Your files  uploaded </h1> </td></tr>   
<%
out.println("hello");
boolean isMultipart = ServletFileUpload.isMultipartContent(request);
if (!isMultipart) { }
  else {          
   FileItemFactory factory = new DiskFileItemFactory(); 
   ServletFileUpload upload = new ServletFileUpload(factory); 
    List items = null;         
      try {                  
       items = upload.parseRequest(request);  
       out.println("1");
                } 
     catch (FileUploadException e)
      {                  
       e.printStackTrace();        
          }           
          Iterator itr = items.iterator();   
         
while (itr.hasNext())
{           FileItem item = (FileItem) itr.next(); 
			 out.println("2");
           if (item.isFormField())
            {          
             }
             else {                 
               try {          
                String itemName = item.getName();   
                 out.println("3");
                                       
      // File savedFile = new File(config.getServletContext().getRealPath("/")+"uploadedFiles"+itemName);  
      File savedFile = new File("D:\\"+"uploadedFiles"+itemName);
         item.write(savedFile);     
          out.println("4");                                             
         out.println("<tr><td><b>Your file has been saved at the loaction:</b></td></tr><tr><td><b>"+config.getServletContext().getRealPath("/")+"uploadedFiles"+"\\"+itemName+"</td></tr>"); 
             }
          catch (Exception e) 
       {                         
             e.printStackTrace();     
              }        
                    }      
                                                                           
                     }
                     } 
            %> 
                  </table>  
                   </center>
                   
