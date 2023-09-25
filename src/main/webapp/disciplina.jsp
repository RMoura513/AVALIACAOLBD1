<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Disciplina</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<br />
	<div align="center" class="container">
		<form action="disciplina" method="post">
		<p class="title">
			<b>Disciplina</b>
		</p>
		<table>
			<tr>
				<td>
					<input type="submit" id="botao" name="botao" value="Listar">
				</td>
			</tr>
			
		</table>
		</form>
	</div>
	<br />
	<div align="center">
		<c:if test="${not empty erro }">
			<H2><b><c:out value="${erro}" /></b></H2>
		</c:if>
	</div>
		<div align="center">
		<c:if test="${not empty saida }">
			<H3><b><c:out value="${saida}" /></b></H3>
		</c:if>
	</div>
	<br />
	<c:if test="${not empty disciplinas }">
		<table class="table_round">
			<thead>
				<tr>
					<th>Código</th>
					<th>Código do Curso</th>
					<th>Código do Horário</th>
					<th>Nome</th>
					<th>Qtd Horas Semanais</th>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach var="d" items="${disciplinas }">
					<tr>
						<td><c:out value="${d.codigo}" /></td>
						<td><c:out value="${d.cursoCodigo}" /></td>
						<td><c:out value="${d.horarioCodigo}" /></td>
						<td><c:out value="${d.nome}" /></td>
						<td><c:out value="${d.qtdHorasSemanais}" /></td>
					</tr>
		
				</c:forEach>
				
			</tbody>
		</table>
	</c:if>
</body>
</html>