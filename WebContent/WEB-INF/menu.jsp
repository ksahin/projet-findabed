
    
    <div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
      <div class="container">
        
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <div class="navbar-brand"><a href="index.html">Find A Bed</a></div>
        
        
        <div class="collapse navbar-collapse">
        <c:if test="${not empty sessionScope.connecte}">
          <ul class="nav navbar-nav">
            <li><a href="publication">Publier annonce</a></li>
            <li><a href="recherche">Rechercher annonce</a></li>
			<li><a href="Profil">Profil</a></li>
			<li><a href="gestionAnnonces">Gérer mes annonces</a></li>
			<li><a href="gestionReservations">Gérer mes réservations</a></li>
          </ul>
		</c:if>
		  <form class="navbar-form navbar-right" method="POST" action="index.html">
            <c:if test="${not empty sessionScope.connecte}">
            <a href="Profil" class="btn btn-info">Bonjour, ${sessionScope.nom}	${sessionScope.prenom}</a>
			<a href="deconnexion" class="btn btn-info">Deconnection</a>
			</c:if>
          </form>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
    </div><!-- /.navbar -->
	