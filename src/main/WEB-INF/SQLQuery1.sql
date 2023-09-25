CREATE DATABASE avaliacaolbd
GO
USE avaliacaolbd
GO
CREATE TABLE curso (
codigo					INT						NOT NULL,
nome					VARCHAR(100)			NOT NULL,
cargaHoraria			INT						NOT NULL,
siglaInterna			VARCHAR(10)				NOT NULL,
ultimaNotaEnade			INT						NOT NULL
PRIMARY KEY (codigo)
)
GO
CREATE TABLE aluno (
RA						INT						NOT NULL,
cursoCodigo				INT						NOT NULL,
turno					VARCHAR(10)				NOT NULL,
CPF						VARCHAR(11)				NOT NULL,
nome					VARCHAR(100)			NOT NULL,
nomeSocial				VARCHAR(100)			NULL,
dataNascimento			DATE					NOT NULL,
tel						INT						NOT NULL,
emailPes				VARCHAR(100)			NOT NULL,
emailCor				VARCHAR(100)			NOT NULL,
dataConclusaoSeg		DATE					NOT NULL,
instituicaoConclusaoSeg	VARCHAR(100)			NOT NULL,
pontuacaoVestibular		FLOAT					NOT NULL,
posicaoVestibular		INT						NOT NULL,
dataIngresso			DATE					NOT NULL,
semestreAnoIngresso		VARCHAR(10)				NOT NULL,
semestreAnoLimiteGrad	VARCHAR(10)				NOT NULL
PRIMARY KEY (RA)
FOREIGN KEY (cursoCodigo) REFERENCES curso (codigo)
)
GO
CREATE TABLE horario (
codigo					INT						NOT NULL,
horaInicio				VARCHAR(5)				NOT NULL,
horaFim					VARCHAR(5)				NOT NULL,
qtdAula					INT						NOT NULL
PRIMARY KEY (codigo)
)
GO
CREATE TABLE disciplina (
codigo					INT						NOT NULL,
nome					VARCHAR(100)			NOT NULL,
cursoCodigo				INT						NOT NULL,
horarioCodigo			INT						NOT NULL,
qtdHorasSemanais		INT						NOT NULL
PRIMARY KEY (codigo)
FOREIGN KEY (horarioCodigo) REFERENCES horario (codigo)
)
GO
CREATE TABLE matricula (
c						INT						NOT NULL,
codigo					INT						NOT NULL,
cursoCodigo				INT						NOT NULL,
disciplinaCodigo		INT						NOT NULL,
alunoRA					INT						NOT NULL,
horarioCodigo			INT						NOT NULL,
situacao				VARCHAR(100)			NOT NULL,
diaSemana				VARCHAR(15)				NOT NULL
PRIMARY KEY (c, codigo)
FOREIGN KEY (alunoRA) REFERENCES aluno (RA),
FOREIGN KEY (cursoCodigo) REFERENCES curso (codigo),
FOREIGN KEY (disciplinaCodigo) REFERENCES disciplina (codigo),
FOREIGN KEY (horarioCodigo) REFERENCES horario (codigo)
)
GO
CREATE TABLE conteudo (
codigo					INT						NOT NULL,
disciplinaCodigo		INT						NOT NULL,
descricao				VARCHAR(100)			NOT NULL
PRIMARY KEY (codigo)
FOREIGN KEY (disciplinaCodigo) REFERENCES disciplina (codigo)
)

use master
DROP DATABASE avaliacaolbd



-------------------------------------GERA CURSOS PARA PREENCHIMENTO DA TABELA-------------------------------------
DECLARE @codigo INT,
		@nome VARCHAR(100),
		@cargaHoraria INT,
		@siglaInterna VARCHAR(10),
		@notaEnade INT

SET @codigo = 0

WHILE @codigo <= 100
BEGIN
    SET @nome = 'Curso ' + CAST(@codigo AS VARCHAR(3))
    SET @cargaHoraria = CAST(RAND() * 2000 AS INT)
    SET @siglaInterna = 'SIG' + CAST(@codigo AS VARCHAR(3))
    SET @notaEnade = CAST(RAND() * 5 AS INT)

    INSERT INTO curso (codigo, nome, cargaHoraria, siglaInterna, ultimaNotaEnade)
    VALUES (@codigo, @nome, @cargaHoraria, @siglaInterna, @notaEnade)

    SET @codigo = @codigo + 1
END

SELECT * FROM curso


-------------------------------------PREENCHE HORÁRIOS---------------------------------------
SELECT * FROM horario

INSERT INTO horario VALUES
(1, '13:00', '16:30', 4),
(2, '13:00', '14:40', 2),
(3, '14:50', '18:20', 4),
(4, '14:50', '16:30', 2),
(5, '16:40', '18:20', 2)




-------------------------------------GERA DISCIPLINAS PARA PREENCHIMENTO DA TABELA-------------------------------------
DECLARE @contador INT, 
		@codigo1 INT,
		@cursoCodigo INT,
		@horarioCodigo INT,
		@nome1 VARCHAR(100),
		@qtdHorasSemanais INT

	SET @codigo1 = 0

SET @cursoCodigo = 0
WHILE @cursoCodigo <= 100 
BEGIN
    DECLARE @qtdDisciplinas INT
    SET @qtdDisciplinas = CAST(RAND() * 11 + 40 AS INT)

    SET @contador = 0
    WHILE @contador < @qtdDisciplinas
    BEGIN
        SET @horarioCodigo = CAST(RAND() * 5 + 1 AS INT)
        SET @nome1 = 'Disciplina ' + CAST(@codigo1 AS VARCHAR(3))
        SET @qtdHorasSemanais = CAST(RAND() * 10 + 4 AS INT)

        INSERT INTO disciplina (codigo, cursoCodigo, horarioCodigo, nome, qtdHorasSemanais)
        VALUES (@codigo1, @cursoCodigo, @horarioCodigo, @nome1, @qtdHorasSemanais)

        SET @contador = @contador + 1
		SET @codigo1 = @codigo1 + 1
    END

    SET @cursoCodigo = @cursoCodigo + 1
END

--DELETE disciplina

SELECT * FROM disciplina



-------------------------------------GERA CONTEÚDO PARA PREENCHIMENTO DA TABELA-------------------------------------
DECLARE @contador1 INT,
		@codigoDisciplina INT,
		@codigoConteudo INT,
		@descricao VARCHAR(100)

SET @codigoConteudo = 0
SET @codigoDisciplina = 0
WHILE @codigoDisciplina <= 50
BEGIN
    DECLARE @qtdConteudos INT
    SET @qtdConteudos = CAST(RAND() * 11 + 5 AS INT)

    SET @contador1 = 0
    WHILE @contador1 < @qtdConteudos
    BEGIN
        SET @descricao = 'Conteúdo ' + CAST(@contador1 AS VARCHAR(3)) + ' da Disciplina ' + CAST(@codigoDisciplina AS VARCHAR(3))

        INSERT INTO conteudo (codigo, disciplinaCodigo, descricao)
        VALUES (@codigoConteudo, @codigoDisciplina, @descricao)

		SET @contador1 = @contador1 +1
        SET @codigoConteudo = @codigoConteudo + 1
    END

    SET @codigoDisciplina = @codigoDisciplina + 1
END

SELECT * FROM conteudo
--DELETE conteudo





-------------------------------------PROCEDURE DE CRUD DE ALUNO-------------------------------------
CREATE PROCEDURE sp_crud_aluno
(
	@acao						VARCHAR(1),
	@RA							INT,
	@cursoCodigo				INT,
	@turno						VARCHAR(10),
	@CPF						VARCHAR(11),
	@nome						VARCHAR(100),
	@nomeSocial					VARCHAR(100),
	@dataNascimento				DATE,
	@tel						INT,
	@emailPes					VARCHAR(100),
	@emailCor					VARCHAR(100),
	@dataConclusaoSeg			DATE,
	@instituicaoConclusaoSeg	VARCHAR(100),
	@pontuacaoVestibular		FLOAT,
	@posicaoVestibular			INT,
	@dataIngresso				DATE,
	@saida						VARCHAR(100) OUTPUT
)
AS
BEGIN
	--Chamada da procedure para validar o CPF
	DECLARE @cpfValido BIT
	EXEC sp_validar_cpf @CPF, @cpfValido OUTPUT

	DECLARE @semestreAnoIngresso VARCHAR(10),
			@anoLimiteGrad INT,
			@semestreAnoLimiteGrad VARCHAR(10),
			@semestreLimiteGrad INT,
			@anoIngresso INT,
			@semestreIngresso INT,
			@saidaRA INT,
			@saidaSemestreAnoIngresso VARCHAR(10),
			@saidaSemestreAnoLimiteGrad VARCHAR(10),
			@saidaSemestreIngresso INT,
			@saidaAnoIngresso INT,
			@idade INT,
			@saidaIdade INT

	EXEC sp_validar_idade @dataNascimento, @saidaIdade OUTPUT
	SET @idade = @saidaIdade
			
	EXEC sp_gerar_data @dataIngresso, @saidaSemestreAnoIngresso OUTPUT, @saidaSemestreAnoLimiteGrad OUTPUT,
						@saidaAnoIngresso OUTPUT, @saidaSemestreIngresso OUTPUT
	SET @semestreAnoIngresso = @saidaSemestreAnoIngresso
	SET @semestreAnoLimiteGrad = @saidaSemestreAnoLimiteGrad
	SET @anoIngresso = @saidaAnoIngresso
	SET @semestreIngresso = @saidaSemestreIngresso


	--'I' para cadastrar o aluno
    IF @acao = 'I'
    BEGIN

		EXEC sp_gerar_ra @anoIngresso, @semestreIngresso, @saidaRA OUTPUT
		SET @RA = @saidaRA

		INSERT INTO aluno (RA, cursoCodigo, turno, CPF, nome, nomeSocial, dataNascimento, tel, emailPes, emailCor, dataConclusaoSeg,
							instituicaoConclusaoSeg, pontuacaoVestibular, posicaoVestibular, dataIngresso, semestreAnoIngresso, 
							semestreAnoLimiteGrad)
		VALUES (@RA, @cursoCodigo, @turno, @CPF, @nome, @nomeSocial, @dataNascimento, @tel, @emailPes, @emailCor, @dataConclusaoSeg,
				@instituicaoConclusaoSeg, @pontuacaoVestibular, @posicaoVestibular, @dataIngresso, @semestreAnoIngresso, 
				@semestreAnoLimiteGrad)
		SET @saida = 'Aluno inserido com sucesso'	
		EXEC sp_matricular_alunos 
		IF @cpfValido = 0
		BEGIN
			SET @saida = 'CPF inválido'
		END
		IF @idade < 16
		BEGIN
			SET @saida = 'Idade inválida'
		END
    END

	--'U' para atualizar o aluno
    IF @acao = 'U'
    BEGIN
		IF @cpfValido = 1 AND @idade >= 16
		BEGIN

            UPDATE aluno
            SET cursoCodigo = @cursoCodigo, turno = @turno, CPF = @CPF, nome = @nome, nomeSocial = @nomeSocial, dataNascimento = @dataNascimento, tel = @tel, 
			emailPes = @emailPes, emailCor = @emailCor, dataConclusaoSeg = @dataConclusaoSeg, instituicaoConclusaoSeg = @instituicaoConclusaoSeg, 
			pontuacaoVestibular = @pontuacaoVestibular, posicaoVestibular = @posicaoVestibular, dataIngresso = @dataIngresso,
			semestreAnoIngresso = @semestreAnoIngresso, semestreAnoLimiteGrad = @semestreAnoLimiteGrad
            WHERE RA = @RA
			SET @saida = 'Aluno alterado com sucesso'

		END
		ELSE
		BEGIN
			SET @saida = 'CPF inválido'
		END
    END

	--'D' para excluir o aluno
    IF @acao = 'D'
    BEGIN
        DELETE aluno WHERE RA = @RA
		SET @saida = 'Aluno excluído com sucesso'
    END
END


--Teste para cadastrar aluno--
DECLARE @out1 VARCHAR(100)
EXEC sp_crud_aluno 'i', 1, 9, 'Tarde', 53514974845, 'abreu', 'djonga', '09-09-2002', 1111111, 'mudar@mudar', 'mudar@mudar', '09-09-2020', 'wilfredo',
					9.0, 6, '09-09-2022', @out1 OUTPUT 
PRINT @out1

--Teste para atualizar o aluno--
DECLARE @out2 VARCHAR(100)
EXEC sp_crud_aluno 'u', 1, 1, 'Tarde', 202228884, 11111111111, 'abreio', 'djonga', '09-09-2002', 1111111, 'mudar@mudar', 'mudar@mudar', '09-09-2020', 'wilfredo',
					9.0, 6, '09-09-2021', @out2 OUTPUT 
PRINT @out2


SELECT * FROM aluno
DROP PROCEDURE sp_crud_aluno
DELETE aluno




-------------------------------------PROCEDURE PARA VALIDAR CPF-------------------------------------
CREATE PROCEDURE sp_validar_cpf
(
    @CPF VARCHAR(11),
    @valido BIT OUTPUT
)
AS
BEGIN
    DECLARE @soma1 INT,
			@soma2 INT,
			@verificador1 INT,
			@verificador2 INT,
			@i INT,
			@digito INT,
			@cpfInv VARCHAR(100)

    SET @valido = 0

    --Verificar se o CPF possui 11 dígitos numéricos
    IF LEN(@CPF) <> 11 OR @CPF NOT LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'
    BEGIN
        SET @valido = 0
		SET @cpfInv = 'CPF inválido'
    END
    ELSE
    BEGIN
        --Calcular o primeiro dígito verificador
        SET @soma1 = 0
        SET @i = 1
        WHILE @i <= 9
        BEGIN
            SET @digito = CAST(SUBSTRING(@CPF, @i, 1) AS INT)
            SET @soma1 = @soma1 + (@digito * (11 - @i))
            SET @i = @i + 1
        END

        SET @verificador1 = (11 - (@soma1 % 11)) % 10

        --Calcular o segundo dígito verificador
        SET @soma2 = 0
        SET @i = 1
        WHILE @i <= 10
        BEGIN
            SET @digito = CAST(SUBSTRING(@CPF, @i, 1) AS INT)
            SET @soma2 = @soma2 + (@digito * (12 - @i))
            SET @i = @i + 1
        END

        SET @verificador2 = (11 - (@soma2 % 11)) % 10

        --Verificar se os dígitos verificadores são válidos
        IF @verificador1 = CAST(SUBSTRING(@CPF, 10, 1) AS INT) AND @verificador2 = CAST(SUBSTRING(@CPF, 11, 1) AS INT)
        BEGIN
            SET @valido = 1
        END
		ELSE
		BEGIN
			SET @cpfInv = 'CPF inválido'
		END
    END
END

--DROP PROCEDURE sp_validar_cpf

--DECLARE @out3 BIT
--EXEC sp_validar_cpf '11111111111', @out3 OUTPUT
--PRINT @out3


-------------------------------------PROCEDURE PARA GERAR RA-------------------------------------

CREATE PROCEDURE sp_gerar_ra (
	@anoIngresso		INT,
	@semestreIngresso	INT,
	@RA					INT OUTPUT
)
AS
BEGIN
	--Gere 4 números aleatórios entre 1000 e 9999
	DECLARE @aleatorio INT = CAST(RAND() * (9999 - 1000 + 1) + 1000 AS INT)

	--Concatena o anoIngresso, semestreIngresso e números aleatórios para criar o RA
	SET @RA = CAST(@anoIngresso AS VARCHAR(4)) + CAST(@semestreIngresso AS VARCHAR(1)) 
						+ CAST(@aleatorio AS VARCHAR(4))
END

--DROP PROCEDURE sp_gerar_ra





-------------------------------------PROCEDURE PARA GERAR SEMESTRE E ANO-------------------------------------


CREATE PROCEDURE sp_gerar_data(
	@dataIngresso	DATE,
	@saidaSemestreAnoIngresso VARCHAR(10) OUTPUT,
	@saidaSemestreAnoLimiteGrad VARCHAR(10) OUTPUT,
	@SaidaAnoIngresso INT OUTPUT,
	@saidaSemestreIngresso INT OUTPUT
)
AS
BEGIN
	DECLARE @semestreLimiteGrad INT,
			@anoLimiteGrad INT

	SET @saidaAnoIngresso = YEAR(@dataIngresso)

	SET @saidaSemestreIngresso = DATEPART(MONTH, @dataIngresso)
	IF (@saidaSemestreIngresso BETWEEN 1 AND 6)
	BEGIN
		SET @saidaSemestreIngresso = 1
	END
	ELSE
	BEGIN
		SET @saidaSemestreIngresso = 2
	END

	SET @saidaSemestreAnoIngresso = CAST(@saidaSemestreIngresso AS VARCHAR(1)) + '/' + CAST(@SaidaAnoIngresso AS VARCHAR(4))

	SET @semestreLimiteGrad = @saidaSemestreIngresso

	SET @anoLimiteGrad = @saidaAnoIngresso + 5

	SET @saidaSemestreAnoLimiteGrad = CAST(@saidaSemestreIngresso AS VARCHAR(1)) + '/' + CAST(@anoLimiteGrad AS VARCHAR(4))

END

--DROP PROCEDURE sp_gerar_data




-------------------------------------PROCEDURE PARA VALIDAR IDADE-------------------------------------
CREATE PROCEDURE sp_validar_idade (
	@dataNascimento	DATE,
	@saidaIdade INT OUTPUT
)
AS
BEGIN
	
	DECLARE @saidaInv VARCHAR(100)

	SET @saidaIdade = DATEDIFF(YEAR, @dataNascimento, GETDATE())
	IF @saidaIdade < 16
	BEGIN
		SET @saidaInv = 'Idade deve ser igual ou superior a 16 anos'
		PRINT @saidaInv
	END
END


--DROP PROCEDURE sp_validar_idade




CREATE PROCEDURE sp_fazer_matricula
    @acao VARCHAR(1),
    @alunoRA INT,
    @disciplinaCodigo INT,
    @situacao VARCHAR(100),
    @diaSemana VARCHAR(15),
    @saida VARCHAR(100) OUTPUT
AS
BEGIN
    DECLARE @c INT,
			@codigo INT,
			@cursoCodigo INT,
			@horarioCodigo INT

    -- Gerar um código c (número inteiro único)
    SET @c = (SELECT MAX(c) FROM matricula) + 1;

    -- Verificar se já existe um código para esse alunoRA
    SELECT @codigo = codigo FROM matricula WHERE alunoRA = @alunoRA;

    -- Se não existe código, gerar um novo
    IF @codigo IS NULL
    BEGIN
        SELECT @codigo = ISNULL(MAX(codigo), 0) + 1 FROM matricula;
    END

    -- Verificar se a matrícula já existe para o mesmo aluno e disciplina
    DECLARE @existe INT;
    SET @existe = 0;
    SELECT @existe = COUNT(*) FROM matricula WHERE disciplinaCodigo = @disciplinaCodigo AND alunoRA = @alunoRA;

    -- Inserir ou atualizar na tabela matricula
    IF @acao = 'I'
    BEGIN
        IF @existe != 0
        BEGIN
			SET @horarioCodigo = (SELECT h.codigo FROM horario h, disciplina di, curso cr WHERE h.codigo = di.horarioCodigo AND di.codigo = @disciplinaCodigo
																												AND di.cursoCodigo = cr.codigo)
            SET @situacao = 'Em curso';
            SET @cursoCodigo = (SELECT cursoCodigo FROM disciplina WHERE codigo = @disciplinaCodigo);
            INSERT INTO matricula (c, codigo, alunoRA, cursoCodigo, disciplinaCodigo, situacao, diaSemana, horarioCodigo) 
            VALUES (@c, @codigo, @alunoRA, @cursoCodigo, @disciplinaCodigo, @situacao, @diaSemana, @horarioCodigo);
            SET @saida = 'Matrícula cadastrada com sucesso';
			DELETE matricula WHERE diaSemana = 'não consta' AND disciplinaCodigo = @disciplinaCodigo

        END
        ELSE
        BEGIN
            SET @saida = 'Matrícula já realizada para essa matéria';
        END
    END
    
END





DROP PROCEDURE sp_fazer_matricula


/*

CREATE PROCEDURE sp_fazer_matricula
    @acao NVARCHAR(1),
    @alunoRA INT,
    @disciplinaCodigo INT,
    @situacao NVARCHAR(100),
    @saida VARCHAR(100) OUTPUT
AS
BEGIN
    DECLARE @c INT
    DECLARE @codigo INT
    DECLARE @cursoCodigo INT
    DECLARE @horarioDisciplinaAtual INT

    -- Gerar um código c (número inteiro único)
    SET @c = (SELECT MAX(c) FROM matricula) + 1

    -- Verificar se já existe um código para esse alunoRA
    SELECT @codigo = codigo FROM matricula WHERE alunoRA = @alunoRA

    -- Se não existe código, gerar um novo
    IF @codigo IS NULL
    BEGIN
        SELECT @codigo = ISNULL(MAX(codigo), 0) + 1 FROM matricula
    END

    -- Obter o horário da disciplina a ser matriculada
    SELECT @horarioDisciplinaAtual = d.horarioCodigo
    FROM disciplina d
    WHERE d.codigo = @disciplinaCodigo

    -- Verificar se há conflito de horário
    IF @acao = 'I'
    BEGIN
        IF EXISTS (
            SELECT 1
            FROM matricula m
            JOIN disciplina d ON m.disciplinaCodigo = d.codigo
            WHERE m.alunoRA = @alunoRA
            AND m.situacao = 'Em curso'
            AND d.horarioCodigo = @horarioDisciplinaAtual
        )
        BEGIN
            -- Existe conflito de horário
            SET @saida = 'Conflito de horário com outra disciplina em curso'
        END
        ELSE
        BEGIN
            -- Não existe conflito de horário, pode matricular
            SET @situacao = 'Em curso'
            SET @cursoCodigo = (SELECT cursoCodigo FROM aluno WHERE RA = @alunoRA)
            INSERT INTO matricula (c, codigo, alunoRA, cursoCodigo, disciplinaCodigo, situacao)
            VALUES (@c, @codigo, @alunoRA, @cursoCodigo, @disciplinaCodigo, @situacao)
            SET @saida = 'Matrícula cadastrada com sucesso'
        END
    END

    -- 'U' para atualizar
    IF @acao = 'U'
    BEGIN
        SET @situacao = 'Em curso'
        UPDATE matricula
        SET situacao = @situacao
        WHERE alunoRA = @alunoRA AND disciplinaCodigo = @disciplinaCodigo
    END
END

*/





SELECT * FROM matricula

--------------testes------------

DECLARE @testesaida VARCHAR(100)
EXEC sp_fazer_matricula 'i', 202221797, 447, 'Matricular', 'segunda', @testesaida OUTPUT
PRINT @testesaida


SELECT * FROM disciplina
SELECT * FROM horario
/*
SELECT * FROM matricula


INSERT INTO matricula VALUES
(0, 0, 10, 448, 202221339, 'concluído') 

SELECT * FROM matricula
SELECT * FROM aluno
SELECT * FROM disciplina
*/
------------------------------------

--Criar sequência
CREATE SEQUENCE matricula_seq
    START WITH 1
    INCREMENT BY 1;



CREATE PROCEDURE sp_matricular_alunos
AS
BEGIN
    DECLARE @alunoRA INT
    DECLARE @cursoCodigo INT
    DECLARE @disciplinaCodigo INT

    --Criar um cursor para iterar pelos alunos
    DECLARE alunosCursor CURSOR FOR
    SELECT RA, cursoCodigo
    FROM aluno

    --Abrir o cursor
    OPEN alunosCursor

    --Iniciar a iteração pelos alunos
    FETCH NEXT FROM alunosCursor INTO @alunoRA, @cursoCodigo

    WHILE @@FETCH_STATUS = 0
    BEGIN
        --Criar um cursor para iterar pelas disciplinas do curso atual
        DECLARE disciplinasCursor CURSOR FOR
        SELECT codigo
        FROM disciplina
        WHERE cursoCodigo = @cursoCodigo

        --Abrir o cursor das disciplinas
        OPEN disciplinasCursor

        --Iniciar a iteração pelas disciplinas
        FETCH NEXT FROM disciplinasCursor INTO @disciplinaCodigo

        WHILE @@FETCH_STATUS = 0
        BEGIN

			DECLARE @horarioCodigo INT
			SET @horarioCodigo = (SELECT horarioCodigo FROM disciplina WHERE cursoCodigo = @cursoCodigo AND codigo = @disciplinaCodigo)
            --Inserir a matrícula caso não exista
            INSERT INTO matricula (c, codigo, cursoCodigo, disciplinaCodigo, alunoRA, situacao, diaSemana, horarioCodigo)
            SELECT NEXT VALUE FOR matricula_seq AS c, @disciplinaCodigo, @cursoCodigo, @disciplinaCodigo, @alunoRA, 'não cursado', 'não consta', @horarioCodigo
            WHERE NOT EXISTS (
                SELECT 1
                FROM matricula
                WHERE cursoCodigo = @cursoCodigo
                AND disciplinaCodigo = @disciplinaCodigo
                AND alunoRA = @alunoRA
            )

            FETCH NEXT FROM disciplinasCursor INTO @disciplinaCodigo
        END

        --Fechar o cursor das disciplinas
        CLOSE disciplinasCursor
        DEALLOCATE disciplinasCursor

        FETCH NEXT FROM alunosCursor INTO @alunoRA, @cursoCodigo
    END

    --Fechar o cursor dos alunos
    CLOSE alunosCursor
    DEALLOCATE alunosCursor
END

DROP PROCEDURE sp_matricular_alunos
EXEC sp_matricular_alunos

SELECT * FROM matricula


