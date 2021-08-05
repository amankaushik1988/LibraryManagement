<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#81BEF7">
<f:view>
<center>
<h3> Return Book </h3><h:form>
		<h:panelGrid border="1" columns="3">
			<h:outputText value="Enter Date"></h:outputText>
			<h:inputText id="transDate" 
			 required="true" requiredMessage="Date is Mandatory" 
			 valueChangeListener="#{returnBookBean.generateTranactionDetails}" onchange="submit()">
			<f:convertDateTime pattern="dd-MMM-yyyy"/>
			<f:validator validatorId="dateValidation"/>
			</h:inputText>
			<h:message for="transDate"></h:message>
		</h:panelGrid>
		<h:panelGrid border="1" columns="3">
		<c:if test="${not empty returnBookBean.transactionList}">	
			<h:outputText value="TransactionId"></h:outputText>
			<h:selectOneMenu id="transId" value="#{returnBookBean.transactionId}">
			<f:selectItems value="#{returnBookBean.transactionList}"/>
			</h:selectOneMenu>
		</c:if>	
		</h:panelGrid>
		<br>
		<h:commandButton type="submit" value="Return Book" action="#{returnBookBean.returnBook}"></h:commandButton>
		</h:form>
		
	
	
	<h4> <h:outputLabel value="#{returnBookBean.message}"></h:outputLabel></h4>
	<br> <h:outputLink value="home.jsp">Home </h:outputLink>
</center>

</f:view>
</body>
</html>