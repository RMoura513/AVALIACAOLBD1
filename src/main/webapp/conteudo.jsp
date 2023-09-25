<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Conteúdo</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<br />
	<div align="center" class="container">
		<form action="conteudo" method="post">
		<p class="title">
			<b>Conteúdo</b>
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
	<c:if test="${not empty conteudos }">
		<table class="table_round">
			<thead>
				<tr>
					<th>codigo</th>
					<th>Código do Conteúdo</th>
					<th>Descrição</th>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach var="c" items="${conteudos }">
					<tr>
						<td><c:out value="${c.codigo}" /></td>
						<td><c:out value="${c.disciplinaCodigo}" /></td>
						<td><c:out value="${c.descricao}" /></td>
					</tr>
		
				</c:forEach>
				
			</tbody>
		</table>
	</c:if>
</body>
</html>