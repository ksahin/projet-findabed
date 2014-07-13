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
<!-- La barre de menus
    ================================================== -->
	<%@ include file="menu.jsp"%>
	
<!-- Le jumbotron
    ================================================== -->
    <div class="page-header  bg-primary">
      	<div class="container">
       		 <h3>Modifier votre profil.</h3>
     	</div>
      </div>


<div class="container">
	<div class="content col-md-4">
		<form  method="POST" action="Profil" class="form-horizontal">
		
				<div class="control-group">
				<label class="control-label" for="nom">Nom</label>
				<div class="controls">
				<input type="text" name="nom" id="nom" value="${requestScope.user.nom}" class="form-control" required>
				</div>
				</div>
				<div class="control-group">
				<label class="control-label" for="prenom">Prénom</label>
				<div class="controls">
				<input type="text" name="prenom" id="prenom" value="${requestScope.user.prenom}" class="form-control" required>
				 </div>
				 </div>
				<div class="control-group">
				<label class="control-label" for="mail">Email</label>
				<div class="controls">
				<input type="email" name="mail" id="mail" value="${requestScope.user.mail}" class="form-control" required>
				</div>
				</div>
				<input type="hidden" id="ville" name="idville" value="${requestScope.ville.idville}">
				<input type="hidden" id="user" name="iduser" value="${requestScope.user.id}">
				<div class="control-group">
				<label class="control-label" for="motDepasse">Mot de passe</label>
				<div class="controls">
				<input type="password" name="motdepasse" id="motDePasse"  class="form-control">
				Remplissez ce champ si vous souhaitez modifier votre mot de passe
				</div>
				</div>
				<div class="control-group">
				<label class="control-label" for="adresse">Adresse</label>
				<div class="controls">
				<input class="form-control" type="text" name="adresse" id="adresse" value="${requestScope.user.adresse}" required>
				</div>
				</div>
				 <div class="control-group">
				<label class="control-label" for="adresse">Ville</label>
				<div class="controls">
				<input class="form-control" type="text" name="nomVille" pattern="[A-Z0-9\s]* - [0-9]{5}" id="nomVille" value="${requestScope.ville.nom} - ${requestScope.ville.codepostal}" required>
				</div>
				</div>
				<div class="control-group">
				<label class="control-label" for="telephone">Téléphone</label>
				<div class="controls">
				<input class="form-control" type="tel" name ="telephone" id="telephone" value="${requestScope.user.telephone}" maxlength = "15" required><br/><br/>
				<button type="submit" class="btn btn-success">Modifier</button>
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