<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- on utilise html5 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css" >
</head>
<body>

<div>
<!-- l'action du fomulaie sert a appeler la servlet. on lui donne le name du file xml -->
	<form action="cs.php" method ="post">
		<input type="hidden" name ="id" value="${model.personne.idPersonne }"/>
		<table>
			<tr>
				<td>NOM: </td>
				<td><input type="text" name ="nom" value="${model.personne.nom }"/></td>
				<td></td>
			</tr>
			<tr>
				<td>PRENOM: </td>
				<td><input type="text" name ="prenom" value="${model.personne.prenom }"/></td>
				<td></td>
			</tr>
			<tr>
				<td>SEXE: </td>
				<td><input type="text" name ="sexe" value="${model.personne.sexe }"/></td>
				<td></td>
			</tr>
			<tr>
				<td>SITUATION MARITALE: </td>
				<td><input type="text" name ="situationMaritale" value="${model.personne.situationMaritale }"/></td>
				<td></td>
				<tr>
				<td>NUMERO RUE: </td>
				<td><input type="text" name ="numRue" value="${model.personne.numRue }"/></td>
				<td></td>
			</tr>
			<tr>
				<td>NOM RUE: </td>
				<td><input type="text" name ="nomRue" value="${model.personne.nomRue }"/></td>
				<td></td>
			</tr>
			<tr>
				<td>CODE POSTAL: </td>
				<td><input type="text" name ="codePostal" value="${model.personne.codePostal }"/></td>
				<td></td>
				<tr>
				<td>VILLE: </td>
				<td><input type="text" name ="ville" value="${model.personne.ville }"/></td>
				<td></td>
			</tr>
			<tr>
				<td>PAYS: </td>
				<td><input type="text" name ="pays" value="${model.personne.pays }"/></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" name = "action" value="save"/></td>
				<td><input type="submit" name = "action" value="update"/></td>
			</tr>
		</table>
	</form>
</div>
<!-- div pour envoyer une requete vers le sevlet -->
<div>
<!-- l'action du fomulaie sert a appeler la servlet. on lui donne le name du file xml -->
	<form action="cs.php" method ="post">
		<table>
			<tr>
				<td>Mot Clé </td>
				<td><input type="text" name ="motcle" value="${model.motCle }"/></td>
				<td><input type="submit" value="Recherche" name="action"/></td>
			</tr>
		</table>
	</form>
</div>

<!-- div pour afficher le resultat de la requete -->
<div>
	<table>
		<tr>
			<th>NOM</th> <th>PRENOM</th> <th>SEXE</th> <th>SITUATION MARITALE</th>
			<th>N°RUE</th> <th>NOM RUE</th> <th>CODE POSTAL</th> <th>VILLE</th> <th>PAYS</th>
		</tr>
		<!-- on faire une boucle pour parcourir les poduits en utilisant jstl ki est dans tomcat-->
		<c:forEach items="${model.listpesonne}" var="p">
		<tr>
			<td>${p.nom}</td>
			<td>${p.prenom}</td>
			<td>${p.sexe}</td>
			<td>${p.situationMaritale}</td>
			<td>${p.numRue}</td>
			<td>${p.nomRue}</td>
			<td>${p.codePostal}</td>
			<td>${p.ville}</td>
			<td>${p.pays}</td>
			<td><a href="cs.php?action=delete&ref=${p.idPersonne }">Supprimer</a></td>
			<td><a href="cs.php?action=edit&id=${p.idPersonne }">Editer</a></td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>