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
<html>
<title>Nouvelles Technologies</title>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-dark bg-dark">
  <a class="navbar-brand" routerLink="/">New Tech</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    <li class="nav-item ">
        <a class="nav-link active "href="./">Accueil</a>
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
      <li class="nav-item ">
        <a class="nav-link"href="./street">Rue</a>
      </li>



    </ul>
  </div>
</nav>
<div class=" home">
<h1>
Université de Paris 8 / M2ISE 2018/2019

</h1>
<h2>
  Application pour Examen Nouvelles Technologies
</h2>
<h2>
  encadré par : <b>M. Mohand Boukella</b>
</h2>

<h3>
  Application faite : <br>
 <p> BackEnd:  <b>SpringMVC- Hibernate</b> <br>
  FrontEnd:  <b>Angular 7</b>
</p>
</h3>

  <h3 class="dev">
    développé par :<b> Amar Yassa</b>
  </h3>
   </div>
</body>
</html>
