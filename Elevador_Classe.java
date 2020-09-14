package Exe_2P;

public class Elevador_Classe {

	private int idElevador;
	private boolean ligado;
	private boolean prioridade;
	private int andarAtual;
	
	public Elevador_Classe() {
		
	}
	
	public Elevador_Classe(int idElevador) {
		this.idElevador = idElevador;
		this.ligado = false;
		this.prioridade = false;
		this.andarAtual = 0;
	}
	
	public Elevador_Classe(int idElevador, boolean ligado, boolean prioridade, int andarAtual) {
		this.idElevador = idElevador;
		this.ligado = ligado;
		this.prioridade = prioridade;
		this.andarAtual = andarAtual;
	}

	public int getIdElevador() {
		return idElevador;
	}

	public void setIdElevador(int idElevador) {
		this.idElevador = idElevador;
	}

	public boolean isLigado() {
		return ligado;
	}

	public boolean isPrioridade() {
		return prioridade;
	}

	public int getAndarAtual() {
		return andarAtual;
	}

	public void setAndarAtual(int andarAtual) {
		this.andarAtual = andarAtual;
	}	

	public void ligarDesligar() {
		ligado = !(ligado);
	}
	
	public void ativarPrioridade() {
		prioridade = true;
	}

	public void desativarPrioridade() {
		prioridade = false;
	}
	
	public float calcularEsforco(int andarDestino) {
		float esforco = 0;
		if (andarDestino > andarAtual) {
			esforco = 1.25f * (andarDestino - andarAtual);
		} else  {
			esforco = andarDestino - andarAtual;
		}
		return esforco;
	}

	public String toString() {
		return idElevador +
				" " +
				ligado +
				" " +
				prioridade;
	}
	
	
}
