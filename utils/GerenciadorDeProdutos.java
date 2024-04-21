package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.Produto;
import models.Usuario;

public class GerenciadorDeProdutos {
	private static final String arquivo = "Produtos.txt";

	public void verificar(String arquivo) {
		File nomeArquivo = new File(arquivo);

		if (nomeArquivo.exists()) {
			System.out.println("Banco de Produtos funcionando!");
		} else {
			try {
				nomeArquivo.createNewFile();
				System.out.println("Arquivo Criado.");
			} catch (IOException e) {
				System.out.println("Ocorreu um erro ao criar arquivo." + e.getMessage());
			}
		}

	}

	public void addProduct(Produto produto) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
			bw.write(produto.toString());
			bw.newLine();
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
		}
	}

	public List<Produto> readerProduct() {
		List<Produto> produtos = new ArrayList<Produto>();

		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
			String linha;

			while ((linha = br.readLine()) != null) {
				String[] partes = linha.split(";");
				produtos.add(new Produto(Long.parseLong(partes[0]), partes[1], Double.parseDouble(partes[2]),
						Integer.parseInt(partes[3])));
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao ler arquivo: " + e.getMessage());
		}
		return produtos;
	}

	public void listarProduto() {
		List<Produto> produtos = readerProduct();

		if (produtos.isEmpty()) {
			System.out.println("Nenhum produto cadastrado.");
		} else {
			System.out.println("Lista de produtos:");
			for (Produto produto : produtos) {
				System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome() + ", Preço: "
						+ produto.getPreco() + ", Quantidade: " + produto.getQuantidade());
			}

		}

	}

	public void reescreverArquivo(List<Produto> produtos) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
			for (Produto produto : produtos) {
				bw.write(produto.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao reescrever o arquivo: " + e.getMessage());
		}

	}

	public void updateProduct(long id, String novoNome, double novoPreco, int novaQuantidade) {
		List<Produto> produto = readerProduct();
		boolean encontrado = false;

		for (Produto prod : produto) {
			if (prod.getId() == id) {
				prod.setNome(novoNome);
				prod.setPreco(novoPreco);
				prod.setQuantidade(novaQuantidade);
				encontrado = true;
				break;
			}
		}

		if (encontrado) {
			reescreverArquivo(produto);
			System.out.println("Produto editado com sucesso.");
		} else {
			System.out.println("Produto não encontrado.");
		}

	}

	public void listarEspecifico(int id) {

		List<Produto> produtos = readerProduct();

		for (Produto produto : produtos) {

			if (produto.getId() == id) {
				System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome() + ", Preço: "
						+ produto.getPreco() + ", Quantidade: " + produto.getQuantidade());
				break;
			} else {
				System.out.println("Produto não encontrado.");
			}
		}
	}

	public void deletProducts(long id) {

		List<Produto> produtos = readerProduct();

		// removeIf => é um loop, um forEach simplificado
		// o usuario ele vai de linha em linha até ser igual ao que o usuario digi
		if (produtos.removeIf(produto -> produto.getId() == id)) {
			reescreverArquivo(produtos);
			System.out.println("Produto deletado com sucesso.");
		} else {
			System.out.println("Produto não encontrado.");
		}
	}

	public void somarPrecos() {
		List<Produto> produtos = readerProduct();

		for (Produto produto : produtos) {
			double[] soma = { produto.getPreco() };
			for (int i = 0; i < soma.length; i++) {
				System.out.println("Somando tudo: " + soma);

			}

		}

	}

	public void contarProdutos() {
		List<Produto> produtos = readerProduct();

	}

	public void trocarSenha() {

	}
}
