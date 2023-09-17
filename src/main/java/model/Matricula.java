package model;

public class Matricula {

	private int codigo;
	private int alunoRa;
	private int semestre;
	private int ano;
	private String situacao;
	private String turno;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getAlunoRa() {
		return alunoRa;
	}

	public void setAlunoRa(int alunoRa) {
		this.alunoRa = alunoRa;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "Matricula [codigo=" + codigo + ", alunoRa=" + alunoRa + ", semestre=" + semestre + ", ano=" + ano
				+ ", situacao=" + situacao + ", turno=" + turno + "]";
	}

}
