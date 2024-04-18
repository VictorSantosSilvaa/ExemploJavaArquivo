package service;

import java.util.List;
import java.util.Scanner;

import models.Usuario;
import utils.GerenciadorDeUsuarios;

public class HandleMenu {
	Scanner sc = new Scanner(System.in);

	// Gerenciador
	GerenciadorDeUsuarios gs = new GerenciadorDeUsuarios();

	// Construtor vazio
	public HandleMenu() {
		// Toda vez que a classe menu, for instanciada, o nosso arquivo sera verificado
		gs.verificaECria("usuarios.txt");
	}

	public void criar() {
		System.out.println("Digite o nome: ");
		String nome = sc.next();

		System.out.println("Digite a senha: ");
		String senha = sc.next();

		int id = getNextId();

		Usuario u = new Usuario(id, nome, senha);
		gs.adicionarUsuario(u);
	}

	public void editar() {
		System.out.println("Digite o ID do usuario: ");
		int id = sc.nextInt();
		
		System.out.println("Digite o novo nome: ");
		String nome = sc.next();
		System.out.println("Digite a nova senha: ");
		String senha = sc.next();
		
		gs.editarUsuario(id, nome, senha);
		
	}

	public void deletar() {
		System.out.println("Digite o ID do usuario a ser deletado: ");
		int id = sc.nextInt();
		gs.deletarUsuario(id);

	}

	public void listar() {

		gs.listarUsuario();
	}

	public void listarEspecifico() {
		System.out.println("Digite o ID do usuario a ser encontrado: ");
		int id = sc.nextInt();
		gs.listarEspecifico(id);
		
	}
	
	private int getNextId() {
		List<Usuario> usuarios = gs.lerUsuarios();
		int maxId = 0;
		// for => forEach
		for (Usuario usuario : usuarios) {
			int id = usuario.getId();
			// 1
			if (id > maxId) {
				// logica para descobrir ultimo id
				maxId = id;
				// 10
			}

		}
		return maxId + 1;
	}

	
	public void login() {
		System.out.println("Login");
		System.out.println("Digite o login: ");
		String login = sc.next();
		System.out.println("Digite a senha: ");
		String senha = sc.next();
		
		gs.logar(login, senha);
	}
}
