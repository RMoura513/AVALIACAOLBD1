package model;

public class Conteudo {

	private int codigo;
	private int disciplinaCodigo;
	private String descricao;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getDisciplinaCodigo() {
		return disciplinaCodigo;
	}

	public void setDisciplinaCodigo(int disciplinaCodigo) {
		this.disciplinaCodigo = disciplinaCodigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Conteudo [codigo=" + codigo + ", disciplinaCodigo=" + disciplinaCodigo + ", descricao=" + descricao
				+ "]";
	}

}
