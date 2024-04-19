package sistema;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		do {

			System.out.println("Bem vindo ao sistema. ");
			System.out.println("Escolha 1 para Sistema de Produto.");
			System.out.println("Escolha 2 para Sistema de Usuario.");
			System.out.println("Escolha 3 para Sair do Sistema.");

			opcao = sc.nextInt();
			switch (opcao) {
			case 1: {
				SistemaDeProduto.main(args);
				break;
			}
			case 2: {
				SistemaUsuario.main(args);
				break;
			}
			case 3: {
				System.out.println("Você saiu do sistema");
				System.out.println("Obrigado, volte sempre.");
				break;
			}
			default:
				System.out.println("Tente Novamente.");
				break;
			}
		} while (opcao != 3);
	}

}
