package service;

import java.util.List;
import java.util.Scanner;

import models.Produto;
import models.Usuario;
import utils.GerenciadorDeProdutos;

public class MenuDeProduto {
	Scanner sc = new Scanner(System.in);

	GerenciadorDeProdutos gp = new GerenciadorDeProdutos();

	public MenuDeProduto() {
		gp.verificar("Produtos.txt");
	}

	private long getNextLong() {
		List<Produto> produtos = gp.readerProduct();
		long maxId = 0;
		// for => forEach
		for (Produto produto : produtos) {
			long id = produto.getId();
			// 1
			if (id > maxId) {
				// logica para descobrir ultimo id
				maxId = id;
				// 10
			}

		}
		return maxId + 1;
	}

	public void cadastrar() {
		System.out.println("Digite o nome do produto: ");
		String nome = sc.next();

		System.out.println("Digite o preço: ");
		double preco = sc.nextDouble();

		System.out.println("Digite a quantidade: ");
		int quantidade = sc.nextInt();

		long id = getNextLong();

		Produto prod = new Produto(id, nome, preco, quantidade);
		gp.addProduct(prod);
		System.out.println("Produto cadastrado com sucesso.");
		System.out.println();
	}

	public void ler() {
		gp.listarProduto();
	}

	public void atualizar() {
		System.out.println("Digite o ID do Produto: ");
		long id = sc.nextLong();
		
		System.out.println("Digite o novo nome: ");
		String nome = sc.next();
		
		System.out.println("Digite um novo preço: ");
		double preco = sc.nextDouble();
		
		System.out.println("Digite a nova quantidade: ");
		int quantidade = sc.nextInt();
		
		gp.updateProduct(id, nome, preco, quantidade);
	}

	public void deletar() {
		System.out.println("Digite o ID do Produto a ser deletado: ");
		long id = sc.nextLong();
		gp.deletProducts(id);
	}

	public void listarEspecifico() {
		System.out.println("Digite o ID do Produto a ser encontrado: ");
		int id = sc.nextInt();
		gp.listarEspecifico(id);

	}
	
	
	public void somarTudo() {
		gp.somarPrecos();
	}
	
	
}
