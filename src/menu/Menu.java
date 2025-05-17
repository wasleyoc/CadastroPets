package menu;

import java.io.File;
import java.util.Scanner;

public class Menu {
    public void Menu() {
        try{
            System.out.println("Bem-vindo ao sistema de cadastro de pets!");
            System.out.println("1. Cadastrar pet");
            System.out.println("2. Listar pets cadastrados");
            System.out.println("3. Deletar um pet cadastrado");
            System.out.println("4. Listar todos os pets cadastrados");
            System.out.println("5. Listar Pets por algum critério (Idade, Raça, Nome)");
            System.out.println("6. Sair");
            Scanner sc = new Scanner(System.in);
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar pet");
                    break;
                case 2:
                    System.out.println("Listar pets cadastrados");
                    break;
                case 3:
                    System.out.println("Deletar um pet cadastrado");
                    break;
                case 4:
                    System.out.println("Listar todos os pets cadastrados");
                    break;
                case 5:
                    System.out.println("Listar Pets por algum critério (Idade, Raça, Nome)");
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
