CREATE DATABASE avaliacaolbd
GO
USE avaliacaolbd
GO
CREATE TABLE aluno (
RA						INT						NOT NULL,
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
semestreIngresso		INT						NOT NULL,
anoIngresso				INT						NOT NULL,
semestreLimiteGrad		INT						NOT NULL,
anoLimiteGrad			INT						NOT NULL
PRIMARY KEY (RA)
)
GO
CREATE TABLE curso (
codigo					INT						NOT NULL,
nome					VARCHAR(100)			NOT NULL,
cargaHoraria			INT						NOT NULL,
siglaInterna			VARCHAR(10)				NOT NULL,
ultimaNotaEnade			INT						NOT NULL,
alunoRA					INT						NOT NULL
PRIMARY KEY (codigo)
FOREIGN KEY (alunoRA) REFERENCES aluno (RA)
)
GO
CREATE TABLE matricula (
codigo					INT						NOT NULL,
alunoRA					INT						NOT NULL,
semestre				INT						NOT NULL,
ano						INT						NOT NULL,
situacao				VARCHAR(100)			NOT NULL,
turno					VARCHAR(100)			NOT NULL
PRIMARY KEY (codigo)
FOREIGN KEY (alunoRA) REFERENCES aluno (RA)
)
GO
CREATE TABLE horario (
codigo					INT						NOT NULL,
horaInicio				INT						NOT NULL,
horaFim					INT						NOT NULL,
qtdAula					INT						NOT NULL
PRIMARY KEY (codigo)
)
GO
CREATE TABLE disciplina (
codigo					INT						NOT NULL,
cursoCodigo				INT						NOT NULL,
matriculaCodigo			INT						NOT NULL,
horarioCodigo			INT						NOT NULL,
nome					VARCHAR(100)			NOT NULL,
qtdHorasSemanais		INT						NOT NULL
PRIMARY KEY (codigo)
FOREIGN KEY (cursoCodigo) REFERENCES curso (codigo),
FOREIGN KEY (matriculaCodigo) REFERENCES matricula (codigo),
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

CREATE PROCEDURE sp_crud_aluno
(
	@acao						VARCHAR(1),
	@RA							INT,
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
	@semestreIngresso			INT,
	@anoIngresso				INT,
	@semestreLimiteGrad			INT,
	@anoLimiteGrad				INT,
	@saida						VARCHAR(100) OUTPUT
)
AS
BEGIN
    IF @acao = 'I'
    BEGIN
		SET @RA = 1
		IF (NOT EXISTS (SELECT 1 FROM aluno WHERE RA = @RA))
			BEGIN
				DECLARE @aleatorio	INT
				SET @aleatorio = RAND() * (9999 - 1000 + 1) + 1000

				SET @RA = CAST(@anoIngresso AS VARCHAR(4)) + CAST(@semestreIngresso AS VARCHAR(1)) 
						+ CAST(@aleatorio AS VARCHAR(4))
			END

            INSERT INTO aluno (RA, CPF, nome, nomeSocial, dataNascimento, tel, emailPes, emailCor, dataConclusaoSeg,
								instituicaoConclusaoSeg, pontuacaoVestibular, posicaoVestibular, semestreIngresso, 
								anoIngresso, semestreLimiteGrad, anoLimiteGrad)
            VALUES (@RA, @CPF, @nome, @nomeSocial, @dataNascimento, @tel, @emailPes, @emailCor, @dataConclusaoSeg,
								@instituicaoConclusaoSeg, @pontuacaoVestibular, @posicaoVestibular, @semestreIngresso, 
								@anoIngresso, @semestreLimiteGrad, @anoLimiteGrad)
			SET @saida = 'Aluno inserido com sucesso'

    END
    IF @acao = 'U'
    BEGIN
            UPDATE aluno
            SET CPF = @CPF, nome = @nome, nomeSocial = @nomeSocial, dataNascimento = @dataNascimento, tel = @tel, 
			emailPes = @emailPes, emailCor =@emailCor, dataConclusaoSeg = @dataConclusaoSeg, instituicaoConclusaoSeg = @instituicaoConclusaoSeg, 
			pontuacaoVestibular = @pontuacaoVestibular, posicaoVestibular = @posicaoVestibular, semestreIngresso = @semestreIngresso, anoIngresso = @anoIngresso, 
			semestreLimiteGrad = @semestreLimiteGrad, anoLimiteGrad = @anoLimiteGrad
            WHERE RA = @RA
			SET @saida = 'Aluno alterado com sucesso'
    END
    IF @acao = 'D'
    BEGIN
        DELETE aluno WHERE RA = @RA
		SET @saida = 'Aluno excluído com sucesso'
    END
END

DECLARE @out1 VARCHAR(100)
EXEC sp_crud_aluno 'i', 1111111, 12332112332, 'eu', null, '07-07-2002', 111111111, 'mudar@eu', 'mudar@eu', '07-07-2023', 'wilfredo',
				9.0, 4, 2, 2013, 2, 2023, @out1 OUTPUT
PRINT @out1


DECLARE @out2 VARCHAR(100)
EXEC sp_crud_aluno 'u', 1111111111, 12332112332, 'eu', agr, '07-07-2002', 111111111, 'mudar@eu', 'mudar@eu', '07-07-2023', 'wilfredo',
				9.0, 4, 2, 2013, 2, @out2 OUTPUT
PRINT @out2

SELECT * FROM aluno
DROP PROCEDURE sp_crud_aluno

use avaliacaolbd
use master
DROP DATABASE avaliacaolbd











