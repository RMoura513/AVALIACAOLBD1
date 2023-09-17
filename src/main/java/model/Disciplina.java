package model;

public class Disciplina {

	private int codigo;
	private int cursoCodigo;
	private int matriculaCodigo;
	private int horarioCodigo;
	private String nome;
	private int qtdHorasSemanais;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCursoCodigo() {
		return cursoCodigo;
	}

	public void setCursoCodigo(int cursoCodigo) {
		this.cursoCodigo = cursoCodigo;
	}

	public int getMatriculaCodigo() {
		return matriculaCodigo;
	}

	public void setMatriculaCodigo(int matriculaCodigo) {
		this.matriculaCodigo = matriculaCodigo;
	}

	public int getHorarioCodigo() {
		return horarioCodigo;
	}

	public void setHorarioCodigo(int horarioCodigo) {
		this.horarioCodigo = horarioCodigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdHorasSemanais() {
		return qtdHorasSemanais;
	}

	public void setQtdHorasSemanais(int qtdHorasSemanais) {
		this.qtdHorasSemanais = qtdHorasSemanais;
	}

	@Override
	public String toString() {
		return "Disciplina [codigo=" + codigo + ", cursoCodigo=" + cursoCodigo + ", matriculaCodigo=" + matriculaCodigo
				+ ", horarioCodigo=" + horarioCodigo + ", nome=" + nome + ", qtdHorasSemanais=" + qtdHorasSemanais
				+ "]";
	}

}
