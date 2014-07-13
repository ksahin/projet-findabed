<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		var r = confirm("Vous êtes sur le point de supprimer votre reservation, voulez vous continuer ?");
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
       		 <h3>Mes réservations</h3>
     	</div>
      </div>
       	<!-- Le message d'avertissement
    ================================================== -->
    <br/><br/>
	<%@ include file="message.jsp"%>   
	
	<c:if test="${!empty requestScope.listeContenuReservation}">
	<div class="container">
	<c:set scope="page" var="position" value="0" />
	<c:forEach var="couple" items="${requestScope.listeContenuReservation}">
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
			<b>${couple.valeurS.getNom()}</b><br/>
			du ${couple.valeurT.dateCreation} au ${couple.valeurT.dateValidite}</b>
              <p>
              <c:if test="${couple.valeurT.getDescription().length() <= 100 }">
              	${couple.valeurT.description}...
              </c:if>
              <c:if test="${couple.valeurT.getDescription().length() > 100 }">
              	${couple.valeurT.description.substring(0,100)}...
              </c:if>
              </p>            
              <p>
              <a class="btn btn-sm btn-danger" href="suppressionReservation?idReservation=${couple.id}" role="button" onclick="return confirmation()">Supprimer</span></a>
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