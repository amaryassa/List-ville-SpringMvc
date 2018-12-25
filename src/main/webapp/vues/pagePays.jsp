<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<spring:url value="/resources/styles/bootstrap.min.css" var="bootstrapCSS" />
<link href="${bootstrapCSS}" rel="stylesheet" /> 
 <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">
<spring:url value="/resources/styles/style.css" var="style" />
<link href="${style}" rel="stylesheet" /> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
		<title><spring:message code="pays.page.titre"/></title>
    </head>
    <body>
    	<a href="index.jsp"><spring:message code="lien.retour.accueil"/></a>
    	<div class="container spacer">
  			<div class="card">
                <div class="card-header bg-info"> Pays</div>
            <div class="  spacer">
		    	<form:form  method="GET" action="country" >
		    	<div class="input-group col-sm-5">
		          <input name="motCle" type="text" class="form-control " placeholder="Recherche par code ISO"/>
		          <div class="input-group-append">
		            <button class="btn btn-secondary" type="submit">
		              <i class="fa fa-search"></i>
		            </button>
		          </div>
		         </div>
		        </form:form >
		      </div>
		       <div class="card-body">
		          <table class="table table-striped">
		            <thead>
		                <tr>
		                    <th><spring:message code="pays.liste.identifiant"/></th>
		                    <th><spring:message code="pays.liste.codeISO"/></th>
		                </tr>
		            </thead>
		            <tbody>
		                <c:forEach items="${listCountry}" var="country">
		                    <tr>
		                        <td><c:out value="${country.idCountry}"/></td>
		                        <td><c:out value="${country.codeIso}"/></td>
		                    </tr>
		                </c:forEach>
		            </tbody>
		            <tfoot> 
		         <c:if test="${lastPage>0}">
		             <nav aria-label="Page navigation example spacer">
				        <ul class="pagination">
				            <li class="numberPagination"><c:out value="${currentPage+1}"/>/<c:out value="${lastPage+1}"/> </li>
				          
				           <li  class="page-item  <c:if test='${currentPage <= 0}'> disabled </c:if> " >
				            	<a href="?motCle=${motCle}&page=${currentPage-1}" class="page-link " >  Prev </a>
				            </li>
				            <li  class="page-item  <c:if test='${currentPage == lastPage}'> disabled </c:if> " >
				            	<a href="?motCle=${motCle}&page=${currentPage+1}" class="page-link " >  Next </a>
				            </li>
				          </ul>
				      </nav>
				 </c:if>
		            </tfoot>
		        </table>
		        </div>
		    </div>
		</div>



    </body>
</html>