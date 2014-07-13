<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en"><head>
<!-- Le contenu du head
    ================================================== -->
	<%@ include file="head.jsp"%>
	
	<script src="jquery-ui/js/jquery-1.10.2.js"></script>
	<script src="jquery-ui/js/jquery-ui-1.10.4.custom.min.js"></script>
	<script src="jquery-ui/js/jquery-ui-1.10.4.custom.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$('#dateValidite').datepicker({dateFormat:'dd/mm/yy'});
			
		});	
		
		$(document).ready(function(){
			$('#dateCreation').datepicker({dateFormat:'dd/mm/yy'});
			
		});
		
		$(document).ready(function ()
		{
				$("#nomVille").autocomplete({
				source: function (request, response)
				{
					//-> Requete Ajax
						$.ajax({
							url: "/FindAbed/autocompletion",
							dataType: "json",
							data: {
					            style: "full",
					            maxRows: 10,
					            ville: request.term
					          },
							type: 'POST',
							success: function (data)
							{
								response($.map(data, function (item)
								{
									 return {
										 label : item.name,
										 value : function ()
										{
											 $("#ville").val(item.id);
											 return item.name;
										}
											 
									 };
									 
								}));
								
							}
						});
					},
					minLength: 3,
					delay: 600
				});
			});
	</script>
	  
  </head>

  <body> 

<!-- La barre de menus
    ================================================== -->
	<%@ include file="menu.jsp"%>
   
<div class="page-header jumbotron">
      	<div class="container">
       		 <h3>Remplissez le formulaire pour modifier votre annonce.</h3>
     	</div>
      </div>


<div class="container">
	<div class="content col-md-4">
		    <form method="post" action ="modifierAnnonce" class="form-horizontal">
		    
		    <div class="control-group">
				<label class="control-label" for="adresse">Ville</label>
			    <div class="controls">
					<input class="form-control" type="text" name="nomVille" pattern="[A-Z0-9\s]* - [0-9]{5}" value="${requestScope.ville.nom} - ${requestScope.ville.codepostal}" id="nomVille" placeholder="Ville" required>
					<input type="hidden" id="ville" name="idville" value="${requestScope.ville.idville}">
					<input type="hidden" id="annonce" name="idAnnonce" value="${requestScope.annonce.id}">
				</div>
			</div>
			<div class="control-group">
			<label class="control-label" for="adresse">Adresse</label>
			<div class="controls">
			<input class="form-control" type="text" name="adresse" id="adresse" value="${requestScope.annonce.adresse}" required>
			</div>
			</div>
			<div class="control-group"> 
			<label class="control-label" for="dateCreation">Date de début</label>
			<div class="controls">
			<input class="form-control" type="text" name="dateCreation" id="dateCreation" value="${requestScope.annonce.dateCreation.substring(0,10)}" required>
			</div>
			</div>
			<div class="control-group"> 
			<label class="control-label" for="dateValidite">Date de fin</label>
			<div class="controls">
			<input class="form-control" type="text" name="dateValidite" id="dateValidite" value="${requestScope.annonce.dateValidite.substring(0,10)}" required>
			</div>
			</div>
			<div class="control-group">
			<label class="control-label" for="Description">Description</label>
			<div class="controls">
			<textarea class="form-control" name="description" id="description"  rows="10" required>${requestScope.annonce.description}</textarea>
			</div>
			</div>			
			<div class="control-group">
			<label class="control-label" for="telephone">Téléphone</label>
			<div class="controls">
			<input class="form-control" type="tel" name ="telephone" id="telephone" value="${requestScope.annonce.telephone}" maxlength = "10"  required><br/><br/>
			<button type="submit" name = "validerPublication" class="btn btn-success">Modifier</button>
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