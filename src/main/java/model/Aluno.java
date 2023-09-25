package model;

import java.time.LocalDate;

public class Aluno {

	private int RA;
	private int cursoCodigo;
	private String turno;
	private String CPF;
	private String nome;
	private String nomeSocial;
	private LocalDate dataNascimento;
	private int tel;
	private String emailPes;
	private String emailCor;
	private LocalDate dataConclusaoSeg;
	private String instituicaoConclusaoSeg;
	private float pontuacaoVestibular;
	private int posicaoVestibular;
	private LocalDate dataIngresso;
	private String semestreAnoIngresso;
	private String semestreAnoLimiteGrad;

	public int getRA() {
		return RA;
	}

	public void setRA(int rA) {
		RA = rA;
	}

	public int getCursoCodigo() {
		return cursoCodigo;
	}

	public void setCursoCodigo(int cursoCodigo) {
		this.cursoCodigo = cursoCodigo;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getEmailPes() {
		return emailPes;
	}

	public void setEmailPes(String emailPes) {
		this.emailPes = emailPes;
	}

	public String getEmailCor() {
		return emailCor;
	}

	public void setEmailCor(String emailCor) {
		this.emailCor = emailCor;
	}

	public LocalDate getDataConclusaoSeg() {
		return dataConclusaoSeg;
	}

	public void setDataConclusaoSeg(LocalDate dataConclusaoSeg) {
		this.dataConclusaoSeg = dataConclusaoSeg;
	}

	public String getInstituicaoConclusaoSeg() {
		return instituicaoConclusaoSeg;
	}

	public void setInstituicaoConclusaoSeg(String instituicaoConclusaoSeg) {
		this.instituicaoConclusaoSeg = instituicaoConclusaoSeg;
	}

	public float getPontuacaoVestibular() {
		return pontuacaoVestibular;
	}

	public void setPontuacaoVestibular(float pontuacaoVestibular) {
		this.pontuacaoVestibular = pontuacaoVestibular;
	}

	public int getPosicaoVestibular() {
		return posicaoVestibular;
	}

	public void setPosicaoVestibular(int posicaoVestibular) {
		this.posicaoVestibular = posicaoVestibular;
	}

	public LocalDate getDataIngresso() {
		return dataIngresso;
	}

	public void setDataIngresso(LocalDate dataIngresso) {
		this.dataIngresso = dataIngresso;
	}

	public String getSemestreAnoIngresso() {
		return semestreAnoIngresso;
	}

	public void setSemestreAnoIngresso(String semestreAnoIngresso) {
		this.semestreAnoIngresso = semestreAnoIngresso;
	}

	public String getSemestreAnoLimiteGrad() {
		return semestreAnoLimiteGrad;
	}

	public void setSemestreAnoLimiteGrad(String semestreAnoLimiteGrad) {
		this.semestreAnoLimiteGrad = semestreAnoLimiteGrad;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "Aluno [RA=" + RA + ", cursoCodigo=" + cursoCodigo + ", turno=" + turno + ", CPF=" + CPF + ", nome="
				+ nome + ", nomeSocial=" + nomeSocial + ", dataNascimento=" + dataNascimento + ", tel=" + tel
				+ ", emailPes=" + emailPes + ", emailCor=" + emailCor + ", dataConclusaoSeg=" + dataConclusaoSeg
				+ ", instituicaoConclusaoSeg=" + instituicaoConclusaoSeg + ", pontuacaoVestibular="
				+ pontuacaoVestibular + ", posicaoVestibular=" + posicaoVestibular + ", dataIngresso=" + dataIngresso
				+ ", semestreAnoIngresso=" + semestreAnoIngresso + ", semestreAnoLimiteGrad=" + semestreAnoLimiteGrad
				+ ", getRA()=" + getRA() + ", getCursoCodigo()=" + getCursoCodigo() + ", getCPF()=" + getCPF()
				+ ", getNome()=" + getNome() + ", getNomeSocial()=" + getNomeSocial() + ", getDataNascimento()="
				+ getDataNascimento() + ", getTel()=" + getTel() + ", getEmailPes()=" + getEmailPes()
				+ ", getEmailCor()=" + getEmailCor() + ", getDataConclusaoSeg()=" + getDataConclusaoSeg()
				+ ", getInstituicaoConclusaoSeg()=" + getInstituicaoConclusaoSeg() + ", getPontuacaoVestibular()="
				+ getPontuacaoVestibular() + ", getPosicaoVestibular()=" + getPosicaoVestibular()
				+ ", getDataIngresso()=" + getDataIngresso() + ", getSemestreAnoIngresso()=" + getSemestreAnoIngresso()
				+ ", getSemestreAnoLimiteGrad()=" + getSemestreAnoLimiteGrad() + ", getTurno()=" + getTurno()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
