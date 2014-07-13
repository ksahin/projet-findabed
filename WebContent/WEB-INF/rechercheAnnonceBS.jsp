<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
<!-- Le contenu du head
    ================================================== -->
	<%@ include file="head.jsp"%>
	
	<script src="jquery-ui/js/jquery-1.10.2.js"></script>
	<script src="jquery-ui/js/jquery-ui-1.10.4.custom.min.js"></script>
	<script src="jquery-ui/js/jquery-ui-1.10.4.custom.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$('#date').datepicker({dateFormat:'dd/mm/yy',minDate: 0});
			
		});	
		
		
		</script>
    
  </head>

  <body> 

<!-- La barre de menus
    ================================================== -->
	<%@ include file="menu.jsp"%>
 
  <div class="page-header bg-primary">
      	<div class="container">
       		 <h3>Rechercher des annonces...</h3>
     	</div>
      </div>
 <div class="container">
	<div class="content">
	
	<form class="form-inline" method="post" action="recherche">
	    	
		  <div class="form-group">
			<c:choose>
				<c:when test="${!empty requestScope.ville}">
						<input class="form-control" type="text" name="nomVille"  value="${requestScope.ville}" id="nomVille"  required>
				 </c:when>
				 <c:otherwise>
					<input class="form-control" type="text" name="nomVille"  id="nomVille" placeholder="Ville" required>
				</c:otherwise>
			</c:choose>
		</div>		
		
	<div class="form-group">
		<c:choose>
			<c:when test="${!empty requestScope.date}">
			 <input type="text" class="form-control" name="date" id="date" value="${date.substring(0,10)}" required>
			 </c:when>
			 <c:otherwise>
			<input type="text" class="form-control" name="date" id="date" placeholder="Choisissez une date" required>
			</c:otherwise>
		</c:choose>
	     <button type="submit" class="btn btn-default" name="rechercher">Rechercher</button>
	     </div>
	</form>
	</div>
	</div>
	
    <c:if test="${!empty requestScope.listeAnnonces}">
	
	<div class="container">
	<div class="page-header">
        <h2>Résultat de votre recherche:</h2>
      </div>
	<c:set scope="page" var="position" value="0" />
	<c:forEach var="annonce" items="${requestScope.listeAnnonces}">
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
			<strong>${requestScope.villeId.chercherVilleParId(annonce.idVille).nom}</strong>
			<p>du ${annonce.dateCreation} au ${annonce.dateValidite}</p>
              <p>
              <c:if test="${annonce.getDescription().length() <= 100 }">
              	${annonce.description}...
              </c:if>
              <c:if test="${annonce.getDescription().length() > 100 }">
              	${annonce.description.substring(0,100)}...
              </c:if>
              </p>            
              <p><a class="btn btn-default" href="details?idAnnonce=${annonce.id}"  role="button">Voir les détails</a></p>
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

   	<!-- Le message d'avertissement
    ================================================== -->
    <br/><br/>
	<%@ include file="message.jsp"%>   
   

			  
		      

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