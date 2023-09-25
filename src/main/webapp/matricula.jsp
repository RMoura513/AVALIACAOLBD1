<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<td colspan="3"><input class="input_data" type="number"
						id="alunoRA" name="alunoRA" placeholder="RA"
						value='<c:out value="${matricula.alunoRA }"></c:out>'> <input
						type="submit" id="botao" name="botao" value="Buscar"> <br>
						<br></td>
				</tr>
				<tr>
					<td colspan="4"><select class="input_data" id="situacao"
						name="situacao">
							<option value="em curso"
								<c:if test="${matricula.situacao eq 'em curso'}">selected</c:if>>Matricular</option>
					</select></td>
				</tr>

				<tr>
					<td colspan="4"><input class="input_data" type="number"
						id="disciplinaCodigo" name="disciplinaCodigo"
						placeholder="Código da Disciplina"
						value='<c:out value="${matricula.disciplinaCodigo }"></c:out>'></td>
				</tr>
								<tr>
					<td colspan="4"><input class="input_data" type="text"
						id="diaSemana" name="diaSemana"
						placeholder="Dia da Semana"
						value='<c:out value="${matricula.diaSemana }"></c:out>'></td>
				</tr>
				
				
				
				
				
<!--				<tr>
					<td colspan="4"><select class="input_data" id="diaSemana"
						name="diaSemana">
							<option value="Segunda-feira"
								<c:if test="${matricula.diaSemana eq 'Segunda-feira'}">selected</c:if>>Segunda-feira</option>
							<option value="Terça-feira"
								<c:if test="${matricula.diaSemana eq 'Terça-feira'}">selected</c:if>>Terça-feira</option>
							<option value="Quarta-feira"
								<c:if test="${matricula.diaSemana eq 'Quarta-feira'}">selected</c:if>>Quarta-feira</option>
							<option value="Quinta-feira"
								<c:if test="${matricula.diaSemana eq 'Quinta-feira'}">selected</c:if>>Quinta-feira</option>
							<option value="Sexta-feira"
								<c:if test="${matricula.diaSemana eq 'Sexta-feira'}">selected</c:if>>Sexta-feira</option>
					</select></td>
				</tr>
-->


				<!--
<tr>
    <td colspan="4">
        <select class="input_data" id="codigo" name="codigo">
            <option value="0">Escolha a Disciplina</option>
            <c:forEach var="d" items="${disciplinas}">
                <c:choose>
                    <c:when test="${empty matricula}">
                       
                        <option value="${d.codigo}">
                            <c:out value="${d.nome}" />
                        </option>
                    </c:when>
                    <c:otherwise>
                       
                        <c:forEach var="m" items="${matriculas}">
                            <c:if test="${d.cursoCodigo eq curso.codigo || d.codigo eq m.disciplinaCodigo}">
                                <option value="${d.codigo}" selected="selected">
                                    <c:out value="${d.nome} - ${m.situacao}" />
                                </option>
                            </c:if>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </td>
</tr>

-->



				<tr>
					<td><input type="submit" id="botao" name="botao"
						value="Cadastrar"></td>
			<!--		<td><input type="submit" id="botao" name="botao"
						value="Alterar"></td>
			-->		<td><input type="submit" id="botao" name="botao"
						value="Listar"></td>
				</tr>

			</table>
		</form>
	</div>
	<br />
	<div align="center">
		<c:if test="${not empty erro }">
			<H2>
				<b><c:out value="${erro}" /></b>
			</H2>
		</c:if>
	</div>
	<div align="center">
		<c:if test="${not empty saida }">
			<H3>
				<b><c:out value="${saida}" /></b>
			</H3>
		</c:if>
	</div>
	<br />
	<c:if test="${not empty matriculas }">
<table class="table_round">
    <thead>
        <tr>
            <th>RA do Aluno</th>
            <th>Código da Disciplina</th>
            <th>Horario</th>
            <th>Situação</th>
            <th>Dia da Semana</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="m" items="${matriculas}">
            <tr>
                <td><c:out value="${m.alunoRA}" /></td>
                <td><c:out value="${m.disciplinaCodigo}" /></td>
                <td>
                    <c:choose>
                        <c:when test="${m.horarioCodigo eq 1}">
                            <c:out value="13:00 - 16:30" />
                        </c:when>
                        <c:when test="${m.horarioCodigo eq 2}">
                            <c:out value="13:00 - 14:40" />
                        </c:when>
                        <c:when test="${m.horarioCodigo eq 3}">
                            <c:out value="14:50 - 18:20" />
                        </c:when>
                        <c:when test="${m.horarioCodigo eq 4}">
                            <c:out value="14:50 - 16:30" />
                        </c:when>
                        <c:when test="${m.horarioCodigo eq 5}">
                            <c:out value="16:40 - 18:20" />
                        </c:when>
                        <c:otherwise>
                            <c:out value="OutroHorario" />
                        </c:otherwise>
                    </c:choose>
                </td>
                <td><c:out value="${m.situacao}" /></td>
                <td><c:out value="${m.diaSemana}" /></td>
            </tr>
        </c:forEach>
    </tbody>
</table>



	</c:if>
</body>
</html>