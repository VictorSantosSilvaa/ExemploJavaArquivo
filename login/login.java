package login;

import java.util.Scanner;

import service.HandleMenu;
import utils.GerenciadorDeUsuarios;

public class login {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		HandleMenu hm = new HandleMenu();

		do {
			System.out.println("Login do Netflix.");
			hm.login();

		} while (true);

	}
}
