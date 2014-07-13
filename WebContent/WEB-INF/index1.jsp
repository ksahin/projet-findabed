<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="inscription">
		<fieldset>
			<legend>Inscription</legend>
			<p>Vous pouvez vous inscrire via ce formulaire.</p>
			<label for="mail">Adresse email <span class="requis">*</span></label>
			<input type="text" id="mail" name="mail" value=""	size="20" maxlength="60" />
			<br />
			<label for="motdepasse">Mot de passe <span class="requis">*</span></label>
			<input type="password" id="motdepasse"	name="motdepasse" value="" size="20" maxlength="20" />
			<br />
			<label for="confirmation">Nom <span class="requis">*</span></label>
			<input type="text" id="nom" name="nom" value="" size="20" maxlength="20" />
			<br />
			<label for="nom">Prenom<span class="requis">*</span></label> 
			<input type="text" id="prenom" name="prenom" value=""	size="20" maxlength="20" />
			<br />
			<input type="submit" value="Inscription" class="sansLabel" />
			<br />
		</fieldset>
	</form>
	${message}
	<br/>
	<br/>
	</body>
</html>