<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ page import="com.findabed.modeles.Annonce" %>
<html lang="en">
<head>
<!-- Le contenu du head
    ================================================== -->
	<%@ include file="head.jsp"%>
	
	<script src="jquery-ui/js/jquery-1.10.2.js"></script>
	<script src="jquery-ui/js/jquery-ui-1.10.4.custom.min.js"></script>
	<script src="jquery-ui/js/jquery-ui-1.10.4.custom.js"></script>
	<script>
	function confirmation(){
		var x;
		var r = confirm("Vous êtes sur le point de supprimer votre annonce, voulez vous continuer ?");
		return r;
	}
	</script>	   
  </head>

  <body> 

<!-- La barre de menus
    ================================================== -->
	<%@ include file="menu.jsp"%>
 
  <div class="page-header bg-primary">
      	<div class="container">
       		 <h3>Mes annonces...</h3>
     	</div>
      </div>
       	<!-- Le message d'avertissement
    ================================================== -->
    <br/><br/>
	<%@ include file="message.jsp"%>   
	
	<c:if test="${!empty requestScope.listeAnnonces}">
	
	<div class="container">
	<c:set scope="page" var="position" value="0" />
	<jsp:useBean id="now" class="java.util.Date" scope="page" />
	<c:forEach var="contenu" items="${requestScope.listeAnnonces}">
		<fmt:parseDate scope="page" var="dateValid" value="${contenu.valeurT.dateValidite}" pattern="dd/MM/yyyy"/>
 		<c:choose>
	        <c:when test="${position mod 3 == 0}">
	            <div class="row">
      				<div class="content">
      					<div class="col-md-4">
	        </c:when>
	        <c:otherwise>
	            	<div class="col-md-4">
	        </c:otherwise>
	    </c:choose>
			<b>${contenu.valeurS.nom}</b><br/>
			du ${contenu.valeurT.dateCreation} au ${contenu.valeurT.dateValidite}</b>
              <p>
              <c:if test="${contenu.valeurT.getDescription().length() <= 100 }">
              	${contenu.valeurT.description}...
              </c:if>
              <c:if test="${contenu.valeurT.getDescription().length() > 100 }">
              	${contenu.valeurT.description.substring(0,100)}...
              </c:if>
              </p>
              <p>
              <c:if test="${dateValid gt now}">            
              <a class="btn btn-default" href="modifierAnnonce?idAnnonce=${contenu.id}" role="button">Modifier</a>
              </c:if>
              <c:if test="${dateValid lt now}">            
              <span class="label label-warning">Dépassée</span>
              </c:if>
              <a class="btn btn-danger" href="suppressionAnnonce?idAnnonce=${contenu.id}" role="button" onclick="return confirmation()">Supprimer</a>
              </p>
		<c:choose>
	        <c:when test="${(position + 1) mod 3 == 0 || position == listeAnnonces.size()-1}">
	            		</div>
      				</div>
      			</div>
      			<hr/>
	        </c:when>
	        <c:otherwise>
	            	</div>
	        </c:otherwise>
	    </c:choose>
	    <c:set scope="page" var="position" value="${position+1}" />
    </c:forEach>
    </div><!--/.container-->
    </c:if>
    

  
   

			  
		      

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
         <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="bootstrap/js/docs.min.js"></script>
	<script src="jquery-ui/js/jquery-1.10.2.js"></script>
	<script src="jquery-ui/js/jquery-ui-1.10.4.custom.min.js"></script>
	
	
   
	
	
		
  

</body></html>