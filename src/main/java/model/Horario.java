package model;

public class Horario {

	private int codigo;
	private String horaInicio;
	private String horaFim;
	private int qtdAula;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
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
