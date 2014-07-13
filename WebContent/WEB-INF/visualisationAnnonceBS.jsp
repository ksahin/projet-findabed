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
       		 <h3>Voici le contenu de votre annonce.</h3>
     	</div>
      </div>


<div class="container">
	<div class="content col-md-4">
		    <form class="form-horizontal">
			<div class="control-group">
			<label class="control-label" for="adresse">Ville</label>
			<div class="controls">
			<input class="form-control" type="text" name="ville" id="ville"  value="${requestScope.ville.nom}(${requestScope.ville.codepostal})" disabled>
			</div>
			</div>
			<div class="control-group">
			<label class="control-label" for="adresse">Adresse</label>
			<div class="controls">
			
			<input class="form-control" type="text" name="adresse" id="adresse" value="${requestScope.annonce.adresse}" disabled>
			</div>
			</div>
			<div class="control-group"> 
			<label class="control-label" for="dateCreation">Date de début</label>
			<div class="controls">
			<input class="form-control" type="text" name="dateCreation" id="dateCreation" value="${requestScope.annonce.dateCreation}" disabled>
			</div>
			</div>
			<div class="control-group"> 
			<label class="control-label" for="dateValidite">Date de fin</label>
			<div class="controls">
			<input class="form-control" type="text" name="dateValidite" id="dateValidite" value="${requestScope.annonce.dateValidite}" disabled>
			</div>
			</div>
			<div class="control-group">
			<label class="control-label" for="Description">Description</label>
			<div class="controls">
			<textarea class="form-control" name="description" id="description" disabled rows="10" >${requestScope.annonce.description}</textarea>
			</div>
			</div>			
			<div class="control-group">
			<label class="control-label" for="telephone">Téléphone</label>
			<div class="controls">
			<input class="form-control" type="text" name ="telephone" id="telephone" value="${requestScope.annonce.telephone}" disabled><br/><br/>
			</div>
			</div>
	    </form>	
    </div>			 
</div>
   
   
   	<!-- Le message d'avertissement
    ================================================== -->
	<%@ include file="message.jsp"%>   
   

			  
		      

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="bootstrap/js/docs.min.js"></script>
	<script src="jquery-ui/js/jquery-ui-1.10.4.custom.js"></script>
   
	
	
		
  

</body></html>