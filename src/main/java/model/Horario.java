package model;

public class Horario {

	private int codigo;
	private int horaInicio;
	private int horaFim;
	private int qtdAula;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(int horaFim) {
		this.horaFim = horaFim;
	}

	public int getQtdAula() {
		return qtdAula;
	}

	public void setQtdAula(int qtdAula) {
		this.qtdAula = qtdAula;
	}

	@Override
	public String toString() {
		return "Horaria [codigo=" + codigo + ", horaInicio=" + horaInicio + ", horaFim=" + horaFim + ", qtdAula="
				+ qtdAula + "]";
	}

}
