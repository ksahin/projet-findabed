<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Find a bed</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="Bootstrap,%20from%20Twitter_fichiers/bootstrap.css" rel="stylesheet">
    <link href="Bootstrap,%20from%20Twitter_fichiers/bootstrap-responsive.css" rel="stylesheet">
    <link href="style.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="http://getbootstrap.com/2.3.2/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="http://getbootstrap.com/2.3.2/assets/ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="http://getbootstrap.com/2.3.2/assets/ico/apple-touch-icon-72-precomposed.png">
                    <link rel="apple-touch-icon-precomposed" href="http://getbootstrap.com/2.3.2/assets/ico/apple-touch-icon-57-precomposed.png">
                                   <link rel="shortcut icon" href="http://getbootstrap.com/2.3.2/assets/ico/favicon.png">
  </head>

  <body> 

	<!-- La barre de menus
    ================================================== -->
	<%@ include file="menu.jsp"%>  



<div class="content">
    <form  method="POST" action="inscription" class="form-horizontal">
		<div class="control-group">
			<label class="control-label" for="mail">Email</label>
				<div class="controls">
				<input type="email" name="mail" id="mail" placeholder="Email" required>
				</div>
				</div>
				<div class="control-group">
				<label class="control-label" for="motDepasse">Mot de passe</label>
				<div class="controls">
				<input type="password" name="motdepasse" id="motDePasse" placeholder="Mot de passe" required>
				</div>
				</div>
				<div class="control-group">
				<label class="control-label" for="nom">Nom</label>
				<div class="controls">
				<input type="text" name="nom" id="nom" placeholder="nom" required>
				</div>
				</div>
				<div class="control-group">
				<label class="control-label" for="prenom">Prénom</label>
				<div class="controls">
				<input type="text" name="prenom" id="prenom" placeholder="prenom" required><br/><br/>
			<button type="submit" class="btn btn-success">Inscription</button>
			<a class="btn btn-danger" href="javascript:history.go(-1)">Retour</a>
			</div>
		</div>
    </form>				 
</div> 
   
	<!-- Le message d'avertissement
    ================================================== -->
	<%@ include file="message.jsp"%>   
   
   

			  
		      

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="Bootstrap,%20from%20Twitter_fichiers/jquery.js"></script>
    <script src="Bootstrap,%20from%20Twitter_fichiers/bootstrap-transition.js"></script>
    <script src="Bootstrap,%20from%20Twitter_fichiers/bootstrap-alert.js"></script>
    <script src="Bootstrap,%20from%20Twitter_fichiers/bootstrap-modal.js"></script>
    <script src="Bootstrap,%20from%20Twitter_fichiers/bootstrap-dropdown.js"></script>
    <script src="Bootstrap,%20from%20Twitter_fichiers/bootstrap-scrollspy.js"></script>
    <script src="Bootstrap,%20from%20Twitter_fichiers/bootstrap-tab.js"></script>
    <script src="Bootstrap,%20from%20Twitter_fichiers/bootstrap-tooltip.js"></script>
    <script src="Bootstrap,%20from%20Twitter_fichiers/bootstrap-popover.js"></script>
    <script src="Bootstrap,%20from%20Twitter_fichiers/bootstrap-button.js"></script>
    <script src="Bootstrap,%20from%20Twitter_fichiers/bootstrap-collapse.js"></script>
    <script src="Bootstrap,%20from%20Twitter_fichiers/bootstrap-carousel.js"></script>
    <script src="Bootstrap,%20from%20Twitter_fichiers/bootstrap-typeahead.js"></script>

  

</body></html>