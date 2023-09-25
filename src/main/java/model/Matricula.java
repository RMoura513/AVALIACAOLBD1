package model;

public class Matricula {

	private int c;
	private int codigo;
	private int alunoRA;
	private int cursoCodigo;
	private int disciplinaCodigo;
	private String situacao;
	private String diaSemana;
	private int horarioCodigo;

	public int getHorarioCodigo() {
		return horarioCodigo;
	}

	public void setHorarioCodigo(int horarioCodigo) {
		this.horarioCodigo = horarioCodigo;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getAlunoRA() {
		return alunoRA;
	}

	public void setAlunoRA(int alunoRA) {
		this.alunoRA = alunoRA;
	}

	public int getCursoCodigo() {
		return cursoCodigo;
	}

	public void setCursoCodigo(int cursoCodigo) {
		this.cursoCodigo = cursoCodigo;
	}

	public int getDisciplinaCodigo() {
		return disciplinaCodigo;
	}

	public void setDisciplinaCodigo(int disciplinaCodigo) {
		this.disciplinaCodigo = disciplinaCodigo;
	}

	@Override
	public String toString() {
		return "Matricula [c=" + c + ", codigo=" + codigo + ", alunoRA=" + alunoRA + ", cursoCodigo=" + cursoCodigo
				+ ", disciplinaCodigo=" + disciplinaCodigo + ", situacao=" + situacao + ", diaSemana=" + diaSemana
				+ ", horarioCodigo=" + horarioCodigo + ", getHorarioCodigo()=" + getHorarioCodigo()
				+ ", getDiaSemana()=" + getDiaSemana() + ", getSituacao()=" + getSituacao() + ", getC()=" + getC()
				+ ", getCodigo()=" + getCodigo() + ", getAlunoRA()=" + getAlunoRA() + ", getCursoCodigo()="
				+ getCursoCodigo() + ", getDisciplinaCodigo()=" + getDisciplinaCodigo() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
