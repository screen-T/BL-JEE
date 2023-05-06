<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New subject</title>
</head>
	<body>
	   
	   <br/>
	   Ajouter une matière : <br/>
	   
	   <form method="get" action="Controller">
			<table>
				<tr>
					<td> Intitulé de la matière : </td>
					<td> <input name="intitule" type="text"> </td>
				</tr>
				<tr>
					<td> Nbr d'heures : </td>
					<td> <input name="nbrHeures" type="text"> </td>
				</tr>
				<tr>
					<td> Niveau d'étude : </td>
					<td> <input name="niveau" type="text"> </td>
				</tr>
				<tr>
					<td> Enseignant : </td>
					<td> <input name="enseignant" type="text"> </td>
				</tr>
				<tr>
					<td> Prérequis : </td>
					<td> <input name="prerequis" type="text" maxlength="4" > </td>
				</tr>
				<tr>
					<td> </td>
					<td> <input name="action" value="AjouterMatiere" type="submit"> </td>
				</tr>
			</table>
			
		</form>
	</body>
</html>