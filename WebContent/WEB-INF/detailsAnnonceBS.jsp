<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en"><head>
<!-- Le contenu du head
    ================================================== -->
	<%@ include file="head.jsp"%>
	
	<script src="jquery-ui/js/jquery-1.10.2.js"></script>
	<script src="jquery-ui/js/jquery-ui-1.10.4.custom.min.js"></script>
	<script src="jquery-ui/js/jquery-ui-1.10.4.custom.js"></script>
	
	  
  </head>

  <body> 

<!-- La barre de menus
    ================================================== -->
	<%@ include file="menu.jsp"%>
   
<div class="page-header bg-primary">
      	<div class="container">
       		 <h3>Détails de l'annonce sélectionnée.</h3>
     	</div>
      </div>

<div class="container">
	<div class="content">
			<div class="col-md-6 ">
			<div class="panel panel-default">
				<div class="panel-heading">
					 <h2>Annonce</h2>
				</div>
				<div class="panel-body lead">
					<p class="lead">${requestScope.ville.nom} </p>
					<p class="lead">Du  ${requestScope.annonce.dateCreation.substring(0,10)} 
							au ${requestScope.annonce.dateValidite.substring(0,10)}</p>
					<p class="lead"><h3>Description:</h3>${requestScope.annonce.description}</p>
	            </div>
	        </div>
            </div>
            
	        <div class="col-md-6">
		        <div class="panel panel-default">
				  <div class="panel-heading">
				    <h2>Contact</h2>
				  </div>
				  <div class="panel-body lead">
				  	<ul>
				    <li>${requestScope.user.prenom} ${requestScope.user.nom}</li>
					<li>${requestScope.user.mail}</li>
					<li>${requestScope.user.telephone}</li>
					<li>${requestScope.user.adresse}</li>
					<li>${requestScope.ville.codepostal} ${requestScope.ville.nom}</li>
					</ul>
				  </div>
				</div>
            </div>
	</div><!--/content-->
</div>
<div class="container">
	<div class="content">
	<p>
		<a class="btn btn-info" href="reservation?idAnnonce=${annonce.id}">Reserver</a>
	</p>
	</div>
</div>
		      

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="bootstrap/js/docs.min.js"></script>
	<script src="jquery-ui/js/jquery-ui-1.10.4.custom.js"></script>
   
	
	
		
  

</body></html>