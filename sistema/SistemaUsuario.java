package sistema;

import java.util.Scanner;

import service.HandleMenu;

public class SistemaUsuario {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		HandleMenu hm = new HandleMenu();
		int opcao = 0;

		do {
			// \n => pula linha
			System.out.print("1 - Criar \n2 - Editar \n3 - Deletar "
					+ "\n4 - Listar \n5 - Lista Especifico \n6 - Logar na conta \n7 - Voltar para Menu Principal \n9 - Sair\n");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1: {
				hm.criar();
				break;
			}
			case 2: {
				hm.editar();
				break;
			}
			case 3: {
				hm.deletar();
				break;
			}
			case 4: {
				hm.listar();
				break;
			}
			case 5: {
				hm.listarEspecifico();
				break;
			}
			case 6: {
				hm.login();
			}
			case 7: {
				Main.main(args);
			}
			case 9: {
				System.out.println("Você saiu do sistema");
				System.out.println("Obrigado, volte sempre.");
				System.exit(0);
				break;
			}
			default:
				System.out.println("Opção inválida.");
				break;
			}
		} while (opcao != 9);
		sc.close();
	}

}
