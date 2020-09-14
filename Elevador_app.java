package Exe_2P;

import java.util.Scanner;

public class Elevador_app {
	
	static Scanner ler = new Scanner(System.in);	
	static Elevador_Classe elevador1;
	static Elevador_Classe elevador2;
	
	public static void main(String[] args) {
		
		int opcao;
		
		do {		
			System.out.println("\n*** Seletor de Op��es ***");
			System.out.println("\n1 - Cadastrar elevador");
			System.out.println("2 - Ligar/Desligar elevador");
			System.out.println("3 - Priorizar elevador");
			System.out.println("4 - Solicitar elevador");
			System.out.println("0 - Fim");
			System.out.print("\nDigite a op��o: ");
		
			opcao = ler.nextInt();
			
			switch (opcao) {
			case 1:
				//cadastrar elevador
				cadastrarElevador();				
				
				break;
			case 2:
				//ligar/desligar
				ligarDesligarElevador();
				
				break;
			case 3:				
				//priorizar elevador
				priorizarElevador();				
				
				break;
			case 4:
				//solicitar elevador
				solicitarElevador();
				
				break;
			case 0:
				System.out.println();
				System.out.println("Opera��o finalizada");
				break;
			default:
				System.out.println();
				System.out.println("Op��o incorreta.");				
			}
			
		} while (opcao != 0);
		
		ler.close();
	}
	
	public static void cadastrarElevador() {
		System.out.println();
		System.out.println("Cadastrar elevador");
		System.out.print("\nIdentifica��o do 1� elevador: ");
		int	idElevador1 = ler.nextInt();
		elevador1 = new Elevador_Classe(idElevador1);
		System.out.println("Elevador cadastrado");
		System.out.print("\nIdentifica��o do 2� elevador: ");
		int	idElevador2 = ler.nextInt();
		if (elevador1.getIdElevador() == idElevador2) {
			System.out.println("N�o foi poss�vel cadastrar o elevador, j� existe elevador com esse id.");								
		} else {
			elevador2 = new Elevador_Classe(idElevador2);
			System.out.println("Elevador cadastrado");								
		}	
		/*System.out.println();
		System.out.println(elevador1.toString());
		System.out.println(elevador2.toString());*/
	}
	
	public static void ligarDesligarElevador() {
		System.out.println();
		System.out.println("Ligar/Desligar elevador");
		System.out.print("Identifica��o do elevador: ");
		int idElevador = ler.nextInt();
		if (elevador1.getIdElevador() == idElevador) {
				elevador1.ligarDesligar();
				if (elevador1.isLigado() == true) {
					System.out.println("Elevador ligado");
					if (elevador2.isLigado() == false) {
						elevador1.ativarPrioridade();
					}
				} else {
					System.out.println("Elevador desligado");
				}
		} 
		if (elevador2.getIdElevador() == idElevador) {
			elevador2.ligarDesligar();
			if (elevador2.isLigado() == true) {
				System.out.println("Elevador ligado");
				if (elevador1.isLigado() == false) {
					elevador2.ativarPrioridade();
				}
			} else {
				System.out.println("Elevador desligado");
			}
		}		
		/*System.out.println();
		System.out.println(elevador1.toString());
		System.out.println(elevador2.toString());*/
	}
	
	public static void priorizarElevador() {
		System.out.println();
		System.out.println("Priorizar elevador");
		System.out.print("Identifica��o do elevador: ");
		int idElevador = ler.nextInt();
		if (elevador1.getIdElevador() == idElevador) {
				elevador1.ativarPrioridade();
				System.out.println("Prioridade ativada");
				elevador2.desativarPrioridade();
		} 
		if (elevador2.getIdElevador() == idElevador) {
			elevador2.ativarPrioridade();
			System.out.println("Prioridade ativada");
			elevador1.desativarPrioridade();				
		} 
		/*System.out.println();
		System.out.println(elevador1.toString());
		System.out.println(elevador2.toString());*/
	}
	public static void solicitarElevador() {
		System.out.println("Solicitar elevador");
		System.out.print("Em qual andar voc� se encontra: ");
		int andarAtual = ler.nextInt();
		elevador1.setAndarAtual(andarAtual);
		elevador2.setAndarAtual(andarAtual);
		System.out.print("Qual o andar de destino: ");
		int andarDestino = ler.nextInt();
		float esforcoElevador1 = elevador1.calcularEsforco(andarDestino);
		float esforcoElevador2 = elevador2.calcularEsforco(andarDestino);
		int elevadorMenorEsforco = 0;
		if (esforcoElevador1 < esforcoElevador2) {
			elevadorMenorEsforco = elevador1.getIdElevador();
			elevador1.setAndarAtual(andarDestino);
		}
		if (esforcoElevador1 > esforcoElevador2) {
			elevadorMenorEsforco = elevador2.getIdElevador();
			elevador2.setAndarAtual(andarDestino);
		} 
		if (esforcoElevador1 == esforcoElevador2){
			if (elevador1.isPrioridade() == true) {
				elevadorMenorEsforco = elevador1.getIdElevador();
				elevador1.setAndarAtual(andarDestino);
			}
			if (elevador2.isPrioridade() == true) {
				elevadorMenorEsforco = elevador2.getIdElevador();
				elevador2.setAndarAtual(andarDestino);
			}
		}	
		System.out.print("\nO elevador que atendeu a solicita��o foi: " + elevadorMenorEsforco);
		System.out.println();
	}
}
