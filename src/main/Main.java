package src.main;

import src.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        int opcoes2 = 0;
        // Verifica se o arquivo de pets existe, se não, cria um novo
        do {
            System.out.println("===============================");
            System.out.println(" SISTEMA DE ADOÇÃO DE PETS ");
            System.out.println("===============================");
            System.out.println("Bem vindo ao sistema de cadastro de adoção de pets!");
            String menu = "C:\\Users\\wasle\\OneDrive\\Documentos\\GitHub\\CadastroPets\\src\\data\\menu.txt";
            ManipuladorArquivos.ler(menu);

            try {
                opcoes2 = entrada.nextInt();
                if (opcoes2 < 1 || opcoes2 > 6) {
                    System.out.println("Opção inválida! Por favor, escolha uma opção entre 1 e 6.");
                    continue; // Volta para o início do loop se a opção for inválida
                }
                entrada.nextLine();
                switch (opcoes2) {
                    case 1:
                        System.out.println("===============================");
                        System.out.println("        CADASTRAR PETS         ");
                        System.out.println("===============================");
                        CadastroPets.Cadastrar(entrada);
                        break;
                    case 2:
                        System.out.println("===============================");
                        System.out.println("          ALTERAR PETS         ");
                        System.out.println("===============================");
                        AlterarPets.Alterar();
                        break;
                    case 3:
                        System.out.println("===============================");
                        System.out.println("          DELETAR PETS         ");
                        System.out.println("===============================");
                        DeletarPets.deletarPorNome();
                        break;
                    case 4:
                        System.out.println("===============================");
                        System.out.println("           LISTAR PETS         ");
                        System.out.println("===============================");
                        ListarPets.Listar();
                        break;
                    case 5:
                        System.out.println("===============================");
                        System.out.println("    LISTAR PETS POR CRITÉRIO   ");
                        System.out.println("===============================");
                        ListarPorCriterio.listPetsByCriterion();
                        break;
                    case 6:
                        entrada.close();
                        break;
                    default:
                        System.out.println("Opção Inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por Favor digite os números!");
                entrada.nextLine(); // Limpa o buffer do scanner
            }
        } while (opcoes2 != 6);
        entrada.close();
    }
}
