<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
	<!-- Le contenu du head
    ================================================== -->
	<%@ include file="head.jsp"%>
</head>

  <body> 

 
	
	
 	<!-- Le jumbotron
    ================================================== -->
	<c:if test="${empty sessionScope.connecte}">
		 <div class="page-header  bg-primary">
			<div class="container">
				<h1>Bienvenue sur FindABed</h1>
			</div> <!-- /container -->
		</div>
	</c:if>
	<c:if test="${!empty sessionScope.connecte}">
		 <div class="page-header  bg-primary">
			<div class="container">
				<h2>Bienvenue, <b>${sessionScope.nom}	${sessionScope.prenom}</b></h2>
				<h2>Naviguez sur notre site et faites vivre la communauté FindABed</h2>
			</div> <!-- /container -->
		</div>
	</c:if>
	<!-- Le message d'avertissement
    ================================================== -->
	
	<%@ include file="message.jsp"%> 
	<!-- Les featurettes
    ================================================== -->
    <c:if test="${empty sessionScope.connecte}">
	 <div class="container">
	 <div class="row">
	 <div class="content col-md-7">
	  <div class="panel panel-default">
	  	<div class="panel-body text-justify">
	  	<div class="lead">
		  Cherchez votre prochain logement ou proposez un endroit douillet où dormir aux voyageurs du monde!
		  Rejoignez vite notre communauté et profitez de l'entraide de tous les FindABeders.
		</div>
		
		<div class="text-center">
			<img src="fab.png" class="img-responsive center-block" alt="Responsive image">
		</div>
	  	</div>
	  	</div>
	 
	 </div>
	 
	  <div class="content col-md-5">
	  <div class="panel panel-default">
	  	<div class="panel-body">
		  <form class="form-signin" role="form" method="POST" action="index.html">
	        <h2 class="form-signin-heading">Identifiez vous</h2>
	        <input type="email" name="mail" class="form-control" placeholder="Adresse mail" required autofocus>
	        <input type="password" name="motdepasse" class="form-control" placeholder="Mot de passe" required>
	        <button class="btn btn-lg btn-primary btn-block" type="submit">Entrer</button>
	      </form>
	     </div>
      </div>
       <div class="panel panel-default">
	  	<div class="panel-body">
	  		<form class="form-signin" role="form">
	        <h2 class="form-signin-heading">Participez au site</h2>
	        	<a href="inscription" class="btn btn-lg btn-primary btn-block">Inscription</a>
	        </form>
	     </div>
      </div>
	 </div>
	 </div>
	 
	 
	 
	 </div>
	 
	 
	 
	 </c:if>
	 
	  <!-- Marketing messaging 
    ================================================== -->
    <c:if test="${!empty sessionScope.connecte}">

    <div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="col-lg-4">
          
          <img class="img-circle" src="stylo.jpg" alt="Generic placeholder image">
          <h2>Poster une annonce</h2>
          <p><a class="btn btn-default" href="publication" role="button">Poster &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          
          <img class="img-circle" src="loupe.jpg" alt="Generic placeholder image">
          <h2>Rechercher des annonces</h2>
          <p><a class="btn btn-default" href="recherche" role="button">Rechercher &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          
          <img class="img-circle" src="profil.jpg" alt="Generic placeholder image">
          <h2>Gérer mon profil</h2>
          <p><a class="btn btn-default" href="Profil" role="button">Profil &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->
      <hr>
       <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="col-lg-4">
          
          <img class="img-circle" src="liste.jpg" alt="Generic placeholder image">
          <h2>Gérer mes annonces</h2>
          <p><a class="btn btn-default" href="gestionAnnonces" role="button">Annonces &raquo;</a></p>
        </div> <!--/.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src="reservation.jpg" alt="Generic placeholder image">
          <h2>Gérer mes réservations</h2>
          <p><a class="btn btn-default" href="gestionReservations" role="button">Reservations &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
          
          <div class="col-lg-4">
          <img class="img-circle" src="sortie.jpg"  alt="Generic placeholder image">
          <h2>Deconnexion</h2>
          <p><a class="btn btn-default" href="deconnexion" role="button">Deconnexion &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
     </c:if>

     <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="bootstrap/js/docs.min.js"></script>

  

</body>
</html>