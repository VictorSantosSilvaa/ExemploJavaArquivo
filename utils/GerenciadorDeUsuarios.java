package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.management.OperationsException;

import models.Usuario;

public class GerenciadorDeUsuarios {

	// Private => variavel privada, não da para ser acessada
	// Static => ""
	// final => não pode ser alterada
	private static final String NOME_ARQUIVO = "usuarios.txt";

	// verificar a existencia do nosso banco de dados e criar caso não exista
	public void verificaECria(String nomeArquivo) {

		// file => arquivo
		File arquivo = new File(nomeArquivo);

		// Verificar se o arquivo existe
		// Verificação sem "!"
		if (arquivo.exists()) {
			System.out.println("Banco funcionando!");
		} else {
			// tente criar, caso de erro, exibe o erro
			try {
				arquivo.createNewFile();
				System.out.println("Arquivo criado com sucesso!");
			} catch (IOException e) {
				System.out.println("ocorreu um erro ao criar o arquivo: " + e.getMessage());
			}
		}

	}

	public void adicionarUsuario(Usuario usuario) {
		// Duas formas para escrever no txt
		// Writer => Escrever
		// BuffereWriter, FileWriter
		// BuffereWriter, proporciona uma eficiente escrita
		// FileWriter, escreve dentro do arquivo

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
			bw.write(usuario.toString()); // 1;victor;123456
			bw.newLine();// nova linha no arquivo txt
			System.out.println("Usuario adicionado com sucesso!");
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
		}

	}

	public List<Usuario> lerUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		// Buffer, File, Reader
		try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
			String linha; // linha =>1;nome;senha

			// percorrer todas as linhas enquanto seja siferente de vazio
			while ((linha = br.readLine()) != null) {
				// Split => vai dividir em tres partes, vai cortar o ";".
				String[] partes = linha.split(";");
				usuarios.add(new Usuario(Integer.parseInt(partes[0]), partes[1], partes[2]));
			}

		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao ler arquivo: " + e.getMessage());
		}
		return usuarios;
	}

	public void reescreverArquivo(List<Usuario> usuarios) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
			for (Usuario usuario : usuarios) {
				bw.write(usuario.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao reescrever o arquivo: " + e.getMessage());
		}

	}

	public void editarUsuario(int id, String novoNome, String novaSenha) {
		List<Usuario> usuarios = lerUsuarios();
		boolean encontrado = false;

		for (Usuario usuario : usuarios) {
			if (usuario.getId() == id) {
				usuario.setNome(novoNome);
				;
				usuario.setSenha(novaSenha);
				encontrado = true;
				break;
			}
		}

		if (encontrado) {
			reescreverArquivo(usuarios);
			System.out.println("Usuario editado com sucesso.");
		} else {
			System.out.println("usuario não encontrado.");
		}

	}

	public void listarUsuario() {
		List<Usuario> usuarios = lerUsuarios();

		if (usuarios.isEmpty()) {
			System.out.println("Nenhum usuario cadastrado.");
		} else {
			System.out.println("Lista de usuarios.");
			for (Usuario usuario : usuarios) {
				System.out.println(
						"ID: " + usuario.getId() + ", Nome: " + usuario.getNome() + ", Senha: " + usuario.getSenha());
			}

		}

	}

	public void listarEspecifico(int id) {

		List<Usuario> usuarios = lerUsuarios();

		for (Usuario usuario : usuarios) {

			if (usuario.getId() == id) {
				System.out.println(
						"ID: " + usuario.getId() + "Nome: " + usuario.getNome() + "Senha: " + usuario.getSenha());
				break;
			} else {
				System.out.println("Usuario não encontrado.");
			}
		}
	}

	public void deletarUsuario(int id) {
		List<Usuario> usuarios = lerUsuarios();

		// removeIf => é um loop, um forEach simplificado
		// o usuario ele vai de linha em linha até ser igual ao que o usuario digi
		if (usuarios.removeIf(usuario -> usuario.getId() == id)) {
			reescreverArquivo(usuarios);
			System.out.println("Usuario deletado com sucesso.");
		} else {
			System.out.println("Usuario não encontrado.");
		}
	}

	public void logar(String login, String senha) {
		List<Usuario> usuarios = lerUsuarios();
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equals(login) && usuario.getSenha().equals(senha)) {
				System.out.println("Bem-Vindo ao sistema.");
			} else {
				System.out.println("login ou senha incorreta.");
			}
		}
	}
}
