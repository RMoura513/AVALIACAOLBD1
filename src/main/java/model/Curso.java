package model;

public class Curso {

	private int codigo;
	private int alunoRa;
	private String nome;
	private int cargaHoraria;
	private String siglaInterna;
	private int ultimaNotaEnade;

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getSiglaInterna() {
		return siglaInterna;
	}

	public void setSiglaInterna(String siglaInterna) {
		this.siglaInterna = siglaInterna;
	}

	public int getUltimaNotaEnade() {
		return ultimaNotaEnade;
	}

	public void setUltimaNotaEnade(int ultimaNotaEnade) {
		this.ultimaNotaEnade = ultimaNotaEnade;
	}

	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", alunoRa=" + alunoRa + ", nome=" + nome + ", cargaHoraria=" + cargaHoraria
				+ ", siglaInterna=" + siglaInterna + ", ultimaNotaEnade=" + ultimaNotaEnade + "]";
	}

}
