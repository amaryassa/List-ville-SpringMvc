<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
		<title><spring:message code="pays.page.titre"/></title>
    </head>
    <body>
    	<p><a href="?language=en">English</a>|<a href="?language=fr">Français</a></p>
    	<a href="index.jsp"><spring:message code="lien.retour.accueil"/></a>
    	<h3><spring:message code="pays.liste.titre"/> </h3>
        <table border="1">
            <thead>
                <tr>
                        <th> Rue</th><th> Ville</th><th>CP</th> <th>Région</th> <th>Langue</th> <th>Pays</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listStreet}" var="street">
                    <tr>
                        <td><c:out value="${street.streetNameLabel}"/></td>
                         <td><c:out value="${street.streetCity.cityName}"/></td>
			            <td><c:out value="${street.streetCity.idZip}"/></td>
			            <td><c:out value="${street.streetCity.cityArea.areaLabel}"/></td>
			            <td><c:out value="${street.streetCity.cityArea.areaLanguage.languageName}"/></td>
			            <td><c:out value="${street.streetCity.cityArea.areaCountry.codeIso}"/></td>
                    </tr>
                </c:forEach>
                
                <c:out value="${listStreet.size()}"/>
          
                
                
                
                
            </tbody>
        </table>
    </body>
</html>