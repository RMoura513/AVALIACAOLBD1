<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Horário</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<br />
	<div align="center" class="container">
		<form action="horario" method="post">
		<p class="title">
			<b>Horário</b>
		</p>
		<table>
			<tr>
				<td colspan="3">
					<input class="input_data" type="number" id="codigo" name="codigo" placeholder="Código"
					 value='<c:out value="${horario.codigo }"></c:out>'>
				</td>
  			<td>
				<input type="submit" id="botao" name="botao" value="Buscar">
			</td>
			</tr>
			<tr>
				<td colspan="4">
					<input class="input_data" type="number" id="horaInicio" name="horaInicio" placeholder="Hora de Início"
					 value='<c:out value="${horario.horaInicio }"></c:out>'>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input class="input_data" type="number" id="horaFim" name="horaFim" placeholder="Hora de Término"
					 value='<c:out value="${horario.horaFim }"></c:out>'>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input class="input_data" type="number" id="qtdAula" name="qtdAula" placeholder="Quantidade de Aulas"
					value='<c:out value="${horario.qtdAula }"></c:out>'>
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
	<c:if test="${not empty horario }">
		<table class="table_round">
			<thead>
				<tr>
					<th>Código</th>
					<th>Hora Início</th>
					<th>Hora de Término</th>
					<th>Quantidade de Aulas</th>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach var="h" items="${horarios }">
					<tr>
						<td><c:out value="${h.codigo}" /></td>
						<td><c:out value="${h.horaInicio}" /></td>
						<td><c:out value="${h.horaFim}" /></td>
						<td><c:out value="${h.qtdAula}" /></td>
					</tr>
		
				</c:forEach>
				
			</tbody>
		</table>
	</c:if>
</body>
</html>