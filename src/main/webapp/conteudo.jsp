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
				<td colspan="3">
					<input class="input_data" type="number" id="codigo" name="codigo" placeholder="Codigo"
					 value='<c:out value="${conteudo.codigo }"></c:out>'>
				</td>
  			<td>
				<input type="submit" id="botao" name="botao" value="Buscar">
			</td>
			</tr>
			<tr>
				<td colspan="4">
					<input class="input_data" type="number" id="disciplinaCodigo" name="disciplinaCodigo" 
					placeholder="Código da Disciplina"
					 value='<c:out value="${conteudo.disciplinaCodigo }"></c:out>'>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input class="input_data" type="text" id="descricao" name="descricao" placeholder="Descrição"
					 value='<c:out value="${conteudo.disciplinaCodigo }"></c:out>'>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" id="botao" name="botao" value="Cadastrar">
				</td>
				<td>
					<input type="submit" id="botao" name="botao" value="Alterar">
				</td>
				<td>
					<input type="submit" id="botao" name="botao" value="Excluir">
				</td>
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
					<th>Código da Disciplina</th>
					<th>Descrição</th>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach var="d" items="${disciplinas }">
					<tr>
						<td><c:out value="${d.codigo}" /></td>
						<td><c:out value="${d.disciplinaCodigo}" /></td>
						<td><c:out value="${d.descricao}" /></td>
					</tr>
		
				</c:forEach>
				
			</tbody>
		</table>
	</c:if>
</body>
</html>