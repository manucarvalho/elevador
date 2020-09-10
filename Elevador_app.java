package Exe_2P;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Elevador_app {
	
	static Scanner ler = new Scanner(System.in);	
	static List<Elevador_Classe> elevadores =  new ArrayList<>();
	
	public static void main(String[] args) {
		
		//cadastrar elevador
		System.out.println("Cadastrar elevador");
		int idElevador = 0;
		for (int i=0; i<2; i++) {
			System.out.printf("Identificação do %dº elevador: ", i+1);
			idElevador = ler.nextInt();
			elevadores.add(new Elevador_Classe(idElevador));
		}
		
		//ligar/desligar
		System.out.println("Ligar/Desligar elevador");
		System.out.print("Identificação do elevador: ");
		idElevador = ler.nextInt();
		for (Elevador_Classe elevador : elevadores) {
			if (elevador.getIdElevador() == idElevador) {
				elevador.ligarDesligar();
			} else {
				System.out.println("Elevador não cadastrado.");
			}
		}
		
		//priorizar elevador
		System.out.println("Priorizar elevador");
		System.out.print("Identificação do elevador: ");
		idElevador = ler.nextInt();
		for (Elevador_Classe elevador : elevadores) {
			if (elevador.getIdElevador() == idElevador) {
					elevador.ativarPrioridade();				
			} else {
				System.out.println("Elevador não cadastrado.");
			}
		}
		
		

		ler.close();
	}

}
