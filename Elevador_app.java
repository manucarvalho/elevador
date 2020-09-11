package Exe_2P;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Elevador_app {
	
	static Scanner ler = new Scanner(System.in);	
	static List<Elevador_Classe> elevadores =  new ArrayList<>();
	
	public static void main(String[] args) {
		
		int opcao;
		
		do {		
			System.out.println("\n*** Seletor de Opções ***");
			System.out.println("\n1 - Cadastrar elevador");
			System.out.println("2 - Ligar/Desligar elevador");
			System.out.println("3 - Priorizar elevador");
			System.out.println("4 - Solicitar elevador");
			System.out.println("0 - Fim");
			System.out.print("\nDigite a opção: ");
		
			opcao = ler.nextInt();
			
			switch (opcao) {
			case 1:
				//cadastrar elevador
				System.out.println();
				System.out.println("Cadastrar elevador");
				int idElevador = 0;
				for (int i=0; i<2; i++) {
					System.out.printf("\nIdentificação do %dº elevador: ", i+1);
					idElevador = ler.nextInt();
					if (elevadores.size() != 0) {
						for (Elevador_Classe elevador : elevadores) {
							if (elevador.getIdElevador() == idElevador) {
								System.out.println("Não foi possível cadastrar o elevador, já existe elevador com esse id.");
							} else {
								elevadores.add(new Elevador_Classe(idElevador));
								System.out.println("Elevador cadastrado");
							}					
						}
					} else {
						elevadores.add(new Elevador_Classe(idElevador));
						System.out.println("Elevador cadastrado");
					}
				}
				
				System.out.println();
				for (Elevador_Classe elevador : elevadores) {
					System.out.println(elevador.toString());
				}
				break;
			case 2:
				System.out.println();
				//ligar/desligar
				System.out.println("Ligar/Desligar elevador");
				System.out.print("Identificação do elevador: ");
				idElevador = ler.nextInt();
				for (Elevador_Classe elevador : elevadores) {
					if (elevador.getIdElevador() == idElevador) {
						elevador.ligarDesligar();
						if (elevador.isLigado() == true) {
							System.out.println("Elevador ligado");
						} else {
							System.out.println("Elevador desligado");
						}
					} 
				}
				
				System.out.println();
				for (Elevador_Classe elevador : elevadores) {
					System.out.println(elevador.toString());
				}
				break;
			case 3:
				System.out.println();
				//priorizar elevador
				System.out.println("Priorizar elevador");
				System.out.print("Identificação do elevador: ");
				idElevador = ler.nextInt();
				for (Elevador_Classe elevador : elevadores) {
					if (elevador.getIdElevador() == idElevador) {
							elevador.ativarPrioridade();
							System.out.println("Prioridade ativada");
					} 
				}
				
				for (Elevador_Classe elevador : elevadores) {
					System.out.println(elevador.toString());
				}
				break;
			case 4:
				//solicitar elevador
				/*System.out.println("Solicitar elevador");
				System.out.print("Em qual andar você se encontra: ");
				int andarAtual = ler.nextInt();
				elevadores.setAndarAtual(andarAtual);
				System.out.print("Qual o andar de destino: ");
				int andarDestino = ler.nextInt();
				float menorEsforco = 100;
				int elevadorMenorEsforco = 0;
				for (Elevador_Classe elevador : elevadores) {
					float esforco = elevador.calcularEsforco(andarDestino);
					if (esforco < menorEsforco) {
						menorEsforco = esforco;
						elevadorMenorEsforco = elevador.getIdElevador();
					}
					if (esforco == menorEsforco) {
						for (Elevador_Classe e : elevadores) {
							if (e.isPrioridade() == true) {
								elevadorMenorEsforco = elevador.getIdElevador();
							}
						}
					}
				}
				System.out.print("\nO elevador que atendeu a solicitação foi: " + elevadorMenorEsforco);*/
				break;
			case 0:
				System.out.println();
				System.out.println("Operação finalizada");
				break;
			default:
				System.out.println();
				System.out.println("Opção incorreta.");				
			}
			
		} while (opcao != 0);
		
		ler.close();
	}

}
