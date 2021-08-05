<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

<script type="text/javascript" language="javascript">
function checkfile() {
     var validExts = new Array(".xlsx", ".xls");
     var isValidFile = false;
    var fileExt;
    var file1=document.getElementById("file1").value;
    var file2=document.getElementById("file2");
    if(file1.value!=null){
    
    fileExt=file1.value;
    fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
    }
    else if(file2.value!=null){
    fileExt=file2.value;
    fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
    }
      for (var i=0; i<validExts.length; i++)

      { 
        if (fileExt==validExts[i]) 
        {
            isValidFile=true;

            break;
        }
      } 
      if(isValidFile==false){
      alert("Invalid File Selected, valid File types are: "+validExts.toString());
      }         
}
</script>
</head>
<body>
     <f:view>
  <form  ENCTYPE="multipart/form-data" ACTION="def.jsp" METHOD="POST">
     <center>   
      <h2 class="heading">Comparing Excel Sheets</h2>
      <h:panelGrid border="1" columns="2">
            <h:outputText value="Upload first ExcelSheet"></h:outputText>
           
<input type="file" name="Browse" id="file1" />

<h:outputText value="Upload Second ExcelSheet"></h:outputText>
     <input type="file" name="Browse" id="file2" />  
           </h:panelGrid>
     
     
      <input type="submit" name="submit" value="Upload" onclick="checkfile()">
      
      </center>
   </form>
      </f:view>
</body>
</html>
