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
<body>
<f:view>
<center>
	<h:form>
	<h3>Transaction Report</h3>
	<h:panelGrid border="1" columns="2">
			<h:outputText value="Book Type"></h:outputText>
			<h:selectManyCheckbox value="#{reportBean.bookTypes}">
			<f:selectItem itemLabel="ComputerScience" itemValue="C"/>
			<f:selectItem itemLabel="Electronics" itemValue="E"/>
			<f:selectItem itemLabel="Mathematics" itemValue="M"/>
			</h:selectManyCheckbox>
	</h:panelGrid>
		<h:commandButton value="Generate" type="submit" action="#{reportBean.generateTransactionDetails}"></h:commandButton>


<c:if test="${not empty reportBean.transactionDetails}">
		<h:dataTable border="1" value="#{reportBean.transactionDetails}" var="transaction">
			<h:column id="TId">
				<f:facet name="header">
					<h:outputText value="TransactionId"></h:outputText>
				</f:facet>
				<h:outputText value="#{transaction.transactionId}"></h:outputText>
			</h:column>
			<h:column id="EId">
				<f:facet name="header">
					<h:outputText value="EmpId"></h:outputText>
				</f:facet>
				<h:outputText value="#{transaction.empId}"></h:outputText>
			</h:column>
		
			<h:column id="BId">
				<f:facet name="header">
					<h:outputText value="BookID"></h:outputText>
				</f:facet>
				<h:outputText value="#{transaction.bookId}"></h:outputText>
			</h:column>
			
			<h:column id="IDate">
				<f:facet name="header">
					<h:outputText value="IssueDate"></h:outputText>
				</f:facet>
				<h:outputText value="#{transaction.issueDate}">
				<f:convertDateTime pattern="dd-MMM-yyyy"/>
				</h:outputText>
			</h:column>
			
			<h:column id="RDate">
				<f:facet name="header">
					<h:outputText value="ReturnDate"></h:outputText>
				</f:facet>
				<h:outputText value="#{transaction.returnDate}">
				<f:convertDateTime pattern="dd-MMM-yyyy"/>
				</h:outputText>
			</h:column>
		</h:dataTable>
	</c:if><br>
	<h:outputLink value="home.jsp">Home</h:outputLink><br>
	<h:outputText value="#{reportBean.message}"></h:outputText>
</h:form>
</center>
</f:view>
</body>
</html>