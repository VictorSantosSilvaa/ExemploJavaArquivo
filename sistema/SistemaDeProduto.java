package sistema;

import java.util.Scanner;

import service.MenuDeProduto;

public class SistemaDeProduto {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		MenuDeProduto menu = new MenuDeProduto();
		int opcao;
		System.out.println();
		System.out.println("Seja bem vindo ao Sistema de Produtos.");
		do {
			System.out.println();
			System.out.println("Escolha as opções abaixo: ");
			System.out.println(
					"1 - Cadastrar \n2 - Ler \n3 - Atualizar \n4 - Deletar \n5 - Especificar produto \n6 - Voltar para o Menu Principal \n9 - Sair do programa. ");
			System.out.print("Digite um numero: ");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1: {
				System.out.println("Vamos cadastrar produto. ");
				menu.cadastrar();
				continue;
			}

			case 2: {
				System.out.println();
				System.out.println("Vamos ler produto. ");
				menu.ler();
				continue;
			}

			case 3: {
				System.out.println();
				System.out.println("Vamos atualizar produto.");
				menu.atualizar();
				continue;
			}

			case 4: {
				System.out.println("Vamos deletar produto.");
				System.out.println();
				menu.deletar();
				continue;
			}
			case 5: {
				System.out.println();
				System.out.println("Vamos especificar produto.");
				menu.listarEspecifico();
				continue;
			}
			case 6: {
				Main.main(args);
			}

			case 9: {
				
				System.out.println("Você saiu do sistema");
				System.out.println("Obrigado, volte sempre.");
				System.exit(0);
				break;
			}

			default:
				System.err.println("Tente novamente. Escreva o que está na lista.");
			}

		} while (opcao != 9);
	}

}
