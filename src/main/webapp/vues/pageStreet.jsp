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
    <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-dark bg-dark">
  <a class="navbar-brand" routerLink="/">New Tech</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    <li class="nav-item ">
        <a class="nav-link"href="./">Accueil</a>
      </li>
      <li class="nav-item ">
        <a class="nav-link" href="./country">Pays</a>
      </li>
      <li class="nav-item ">
        <a class="nav-link"href="./area">Région</a>
      </li>
      <li class="nav-item ">
        <a class="nav-link"href="./city">Ville</a>
      </li>
      <li class="nav-item active ">
        <a class="nav-link"href="./street">Rue</a>
      </li>



    </ul>
  </div>
</nav>
    
    
    	<div class="container spacer">
  			<div class="card">
                <div class="card-header bg-warning"> Rue</div>
            <div class="  spacer">
		    	<form:form  method="GET" action="area" >
		    	<div class="input-group col-sm-5">
		          <input name="motCle" type="text" class="form-control " placeholder="Recherche par nom de la rue"/>
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
		                    <th> Rue</th><th> Ville</th><th>CP</th> <th>Région</th> <th>Langue</th> <th>Pays</th>
		                </tr>
		            </thead>
		            <tbody>
		                 <c:forEach items="${listStreet}" var="street">
		                    	<td><c:out value="${street.streetNameLabel}"/></td>
		                        <td><c:out value="${street.streetCity.cityName}"/></td>
		                        <td><c:out value="${street.streetCity.idZip}"/></td>
		                        <td><c:out value="${street.streetCity.cityArea.areaLabel}"/></td>
		                        <td><c:out value="${street.streetCity.cityArea.areaLanguage.languageName}"/></td>
		                        <td><c:out value="${street.streetCity.cityArea.areaCountry.codeIso}"/></td>
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