<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Matrícula</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<br />
	<div align="center" class="container">
		<form action="matricula" method="post">
		<p class="title">
			<b>Matrícula</b>
		</p>
		<table>
			<tr>
				<td colspan="3">
					<input class="input_data" type="number" id="codigo" name="codigo" placeholder="Código"
					 value='<c:out value="${matricula.codigo }"></c:out>'>
				</td>
  			<td>
				<input type="submit" id="botao" name="botao" value="Buscar">
			</td>
			</tr>
			<tr>
				<td colspan="4">
					<input class="input_data" type="number" id="alunoRA" name="alunoRA" placeholder="RA do Aluno"
					 value='<c:out value="${matricula.alunoRA }"></c:out>'>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input class="input_data" type="number" id="semestre" name="semestre" placeholder="Semestre"
					 value='<c:out value="${matricula.semestre }"></c:out>'>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input class="input_data" type="number" id="ano" name="ano" placeholder="Ano"
					value='<c:out value="${matricula.ano }"></c:out>'>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input class="input_data" type="text" id="situacao" name="situacao" placeholder="Situação"
					value='<c:out value="${matricula.situacao }"></c:out>'>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input class="input_data" type="text" id="turno" name="turno" placeholder="Turno"
					value='<c:out value="${matricula.turno }"></c:out>'>
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
	<c:if test="${not empty matriculas }">
		<table class="table_round">
			<thead>
				<tr>
					<th>Código</th>
					<th>RA do Aluno</th>
					<th>semestre</th>
					<th>Ano</th>
					<th>Situação</th>
					<th>Turno</th>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach var="m" items="${matriculas }">
					<tr>
						<td><c:out value="${h.codigo}" /></td>
						<td><c:out value="${h.alunoRA}" /></td>
						<td><c:out value="${h.semestre}" /></td>
						<td><c:out value="${h.ano}" /></td>
						<td><c:out value="${h.situacao}" /></td>
						<td><c:out value="${h.turno}" /></td>
					</tr>
		
				</c:forEach>
				
			</tbody>
		</table>
	</c:if>
</body>
</html>