package model;

import java.time.LocalDate;

public class Aluno {

	private int RA;
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
	private int semestreIngresso;
	private int anoIngresso;
	private int semestreLimiteGrad;
	private int anoLimiteGrad;

	public int getRA() {
		return RA;
	}

	public void setRA(int RA) {
		this.RA = RA;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
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

	public int getSemestreIngresso() {
		return semestreIngresso;
	}

	public void setSemestreIngresso(int semestreIngresso) {
		this.semestreIngresso = semestreIngresso;
	}

	public int getAnoIngresso() {
		return anoIngresso;
	}

	public void setAnoIngresso(int anoIngresso) {
		this.anoIngresso = anoIngresso;
	}

	public int getSemestreLimiteGrad() {
		return semestreLimiteGrad;
	}

	public void setSemestreLimiteGrad(int semestreLimiteGrad) {
		this.semestreLimiteGrad = semestreLimiteGrad;
	}

	public int getAnoLimiteGrad() {
		return anoLimiteGrad;
	}

	public void setAnoLimiteGrad(int anoLimiteGrad) {
		this.anoLimiteGrad = anoLimiteGrad;
	}

	@Override
	public String toString() {
		return "Aluno [RA=" + RA + ", CPF=" + CPF + ", nome=" + nome + ", nomeSocial=" + nomeSocial
				+ ", dataNascimento=" + dataNascimento + ", tel=" + tel + ", emailPes=" + emailPes + ", emailCor="
				+ emailCor + ", dataConclusaoSeg=" + dataConclusaoSeg + ", instituicaoConclusaoSeg="
				+ instituicaoConclusaoSeg + ", pontuacaoVestibular=" + pontuacaoVestibular + ", posicaoVestibular="
				+ posicaoVestibular + ", semestreIngresso=" + semestreIngresso + ", anoIngresso=" + anoIngresso
				+ ", semestreLimiteGrad=" + semestreLimiteGrad + ", anoLimiteGrad=" + anoLimiteGrad + "]";
	}
	
}