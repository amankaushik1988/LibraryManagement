
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
<body bgcolor="red">
<f:view>

	<h:form>
	<center>
	<h3>ISSUE BOOK</h3>
		<h:panelGrid border="1" columns="2">
			<h:outputText value="Employee Id" ></h:outputText>
			<h:selectOneMenu value="#{issueBookBean.empId}">
			<f:selectItem itemLabel="-select-" itemValue="0"/>
			<f:selectItems value="#{issueBookBean.empIdList}" />
			</h:selectOneMenu>
			
			<h:outputText value="Book Type"></h:outputText>
			<h:selectOneRadio  onclick="submit();" valueChangeListener="#{issueBookBean.getBookNames}">
		    <f:selectItem itemLabel="Computer Science" itemValue="C"/>
		    <f:selectItem itemLabel="Electronics" itemValue="E"/>
		    <f:selectItem itemLabel="Mathematics" itemValue="M"/>
		    </h:selectOneRadio>
		 </h:panelGrid>
		 <c:if test="${not empty issueBookBean.bookNameList}">
		 <h:panelGrid border="1" columns="2">
		 <h:outputText value="Book Name"></h:outputText>
		 <h:selectOneMenu value="#{issueBookBean.bookId}">
		 <f:selectItem itemLabel="-select-" itemValue="0"/>
		 <f:selectItems value="#{issueBookBean.bookNameList}"/>
		 </h:selectOneMenu>
		 </h:panelGrid>
			<h:commandButton value="Issue Book" type="submit" action="#{issueBookBean.issueBook}"></h:commandButton><br>
			<h:outputLink value="home.jsp">Home</h:outputLink><br>
			<h:outputText value="#{issueBookBean.message}"></h:outputText>
		</c:if>
	 
	</center>
		
	</h:form>
</f:view>
</body>
</html>
