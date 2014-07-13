<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          
            
          <a class="brand" href="index.html">Find a bed</a>
          <c:if test="${not empty sessionScope.connecte}">
		  <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="accueilBS.html">Accueil</a></li>
              <li><a href="rechercheAnnonceBS.html">Rechercher annonce</a></li>
              <li><a href="posteAnnonceBS.html">Poster annonce</a></li>
			  <li><a href="profilBS.html">Profil</a></li>			  
            </ul>
          </div><!--/.nav-collapse -->
          </c:if>
          <!-- TODO
	afficher mail mdp connection inscription si le mec est pas log, s'il est log afficher seulement deconection, mettre le tout dans le bandeau  -->
			

			<div id = "connexion">
					
					<form class="form-inline" method="POST" action="index.html">
					<c:if test="${empty sessionScope.connecte}">
					<input type="email" name="mail" class="input-large" placeholder="Email">
					<input type="password" name="motdepasse" class="input-large" placeholder="Mot de passe">
					<label class="checkbox"></label>
					<button type="submit" class="btn">Connexion</button>
					<a href="inscription" class="btn">S'inscrire</a>
					</c:if> 
					<c:if test="${not empty sessionScope.connecte}">
						<span class="label label-info">Bonjour, ${sessionScope.nom}	${sessionScope.prenom}</span>
					<a href="deconnexion.html" class="btn">Déconnexion</a>
					</c:if>
				</form>
                
			</div>
        </div>
      </div>
    </div>
	