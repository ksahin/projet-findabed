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


	<!-- Le jumbotron
    ================================================== -->
	<div class="page-header bg-primary">
		<div class="container">
			<h3>Inscrivez vous pour accéder au site FindABed.</h3>
		</div>
	</div>


	<div class="container">
		<div class="content col-md-4">
			<form method="POST" action="inscription" class="form-horizontal">
				<div class="control-group">
					<label class="control-label" for="nom">Nom</label>
					<div class="controls">
						<input type="text" name="nom" id="nom" placeholder="nom"
							class="form-control" required>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="prenom">Prénom</label>
					<div class="controls">
						<input type="text" name="prenom" id="prenom" placeholder="prenom"
							class="form-control" required>
					</div>
				</div>			
				<div class="control-group">
					<label class="control-label" for="mail">Email</label>
					<div class="controls">
						<input type="email" name="mail" id="mail" placeholder="Email"
							class="form-control" required>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="motDepasse">Mot de passe</label>
					<div class="controls">
						<input type="password" name="motdepasse" id="motDePasse"
							placeholder="Mot de passe" class="form-control" required>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="adresse">Adresse</label>
					<div class="controls">
						<input class="form-control" type="text" name="adresse"
							id="adresse" placeholder="Adresse" required>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="ville">Ville</label>
					<div class="controls">
						<input class="form-control" type="text" name="nomVille"
							pattern="[A-Z0-9\s]* - [0-9]{5}" id="nomVille" placeholder="Ville"
							required> 
						<input type="hidden" id="ville" name="ville" value="">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="telephone">Téléphone</label>
					<div class="controls">
						<input class="form-control" type="tel" name="telephone"
							id="telephone" placeholder="Téléphone" maxlength="15" required><br />
						<br />
						<button type="submit" class="btn btn-success">Inscription</button>
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
       <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="bootstrap/js/docs.min.js"></script>
	<script src="jquery-ui/js/jquery-ui-1.10.4.custom.js"></script>
   
	
	
		
  

</body></html>