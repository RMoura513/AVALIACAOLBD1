<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Curso</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<br />
	<div align="center" class="container">
		<form action="curso" method="post">
		<p class="title">
			<b>Curso</b>
		</p>
		<table>
			<tr>
				<td colspan="3">
					<input class="input_data" type="number" id="codigo" name="codigo" placeholder="Código"
					 value='<c:out value="${curso.codigo }"></c:out>'>
				</td>
  			<td>
				<input type="submit" id="botao" name="botao" value="Buscar">
			</td>
			</tr>
			<tr>
				<td colspan="4">
					<input class="input_data" type="number" id="alunoRA" name="alunoRA" placeholder="RA do Aluno"
					 value='<c:out value="${curso.alunoRA }"></c:out>'>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input class="input_data" type="text" id="nome" name="nome" placeholder="Nome"
					 value='<c:out value="${curso.nome }"></c:out>'>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input class="input_data" type="number" id="cargaHoraria" name="cargaHoraria" placeholder="Carga Horária"
					value='<c:out value="${curso.cargaHoraria }"></c:out>'>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input class="input_data" type="text" id="siglaInterna" name="siglaInterna" placeholder="Sigla Interna"
					value='<c:out value="${curso.siglaInterna }"></c:out>'>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input class="input_data" type="number" id="ultimaNotaEnade" name="ultimaNotaEnade" 
					placeholder="Última nota do Enade"
					value='<c:out value="${curso.ultimaNotaEnade }"></c:out>'>
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
	<c:if test="${not empty cursos }">
		<table class="table_round">
			<thead>
				<tr>
					<th>Código</th>
					<th>RA do Aluno</th>
					<th>Nome</th>
					<th>Carga Horária</th>
					<th>Sigla Interna</th>
					<th>Última Nota Enade</th>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach var="c" items="${cursos }">
					<tr>
						<td><c:out value="${c.codigo}" /></td>
						<td><c:out value="${c.AlunoRA}" /></td>
						<td><c:out value="${c.nome}" /></td>
						<td><c:out value="${c.cargaHoraria}" /></td>
						<td><c:out value="${c.siglaInterna}" /></td>
						<td><c:out value="${c.ultimaNotaEnade}" /></td>
					</tr>
		
				</c:forEach>
				
			</tbody>
		</table>
	</c:if>
</body>
</html>