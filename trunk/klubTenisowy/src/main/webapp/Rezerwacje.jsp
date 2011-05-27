<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Krakowskie Stowarzyszenie OÅwiatowe Pro edukatione - o
	nas</title>
<script type="text/javascript" src="autoiframe.js"></script>
<link href="styl.css" rel="stylesheet" type="text/css" />
<link href="../styl.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.styl1 {
	font-size: 14px
}
-->
</style>
<%@ page import="java.util.*"%>
<%@ page import="com.agh.klubTenisowy.model.*"%>

</head>

<body class="tabela_ogloszenia_srodek">

	<%
List<Rezerwacja> rezerwacje = (List)request.getAttribute("Rezerwacje");
/* Iterator it = styles.iterator();
while(it.hasNext()) {
out.print(""“<br>try: “ + it.next());
}
 */
%>

	<p class="tytul styl1">Rezerwacja kortow</p>

	<form name="account_login" class="account_login" action="KlubTenisowy"
		method="post">
		<table border="1">
			<input name="Akcja" type="hidden" value="Rezerwacja" />
			<tr>
				<td>Id</td>
				<td>Kort</td>
				<td>Dzien</td>
				<td>Zakres</td>
				<td>Dostepnosc</td>
			</tr>
			<% for (Rezerwacja rezerwacja : rezerwacje) { %>

			<tr>
				<td><%= rezerwacja.getId() %></td>
				<td><%= rezerwacja.getKort() %></td>
				<td><%= rezerwacja.dajDzienString() %></td>
				<td><%= rezerwacja.dajZakresString() %></td>
				<%-- 					<%if(rezerwacja.getDostepna() == true) { %>
					<td>
					<input type="hidden" name="IdRezerwacji" value=<%rezerwacja.getId(); %>/>
					<input type="submit" value="Zarezerwuj"/></td>
					<%} else {%>
					<td>rezerwacja</td>
					<%} %>
 --%>
				<%if(rezerwacja.getDostepna() == true) { %>
				<td>dostepny</td>
				<%} else {%>
				<td>zajety</td>
				<%} %>

			</tr>
			<% } %>
			<tr>

			</tr>


		</table>
		<p>
			Wypelnij ponizszy formularz i i&nbsp;wcisnij <strong>Zarezerwuj</strong>
		</p>
		<table>
			<tr>
				<td>Id:</td>
				<td><input name="IdRezerwacji" type="text" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input name="Email" type="text" />
				</td>
			</tr>
			<tr>
				<td>Haslo:</td>
				<td><input name="Haslo" type="text" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Zarezerwuj" />
				</td>
			</tr>
		</table>

	</form>
	<script type="text/javascript">
		//          
		autoiframe(null, 200);
		//
	</script>
</body>
</html>
