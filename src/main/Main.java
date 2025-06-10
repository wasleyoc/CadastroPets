package src.main;

import src.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String menu = "C:\\Users\\wasle\\OneDrive\\Documentos\\GitHub\\CadastroPets\\src\\data\\menu.txt";
        ManipuladorArquivos.ler(menu);

        Scanner entrada = new Scanner(System.in);

        try {
            int opcoes2 = entrada.nextInt();
            switch (opcoes2) {
                case 1:
                    System.out.println("Cadastro de Pets");
                    CadastroPets.Cadastrar();
                    break;
                case 2:
                    System.out.println("Alterar Pets");
                    AlterarPets.Alterar();
                    break;
                case 3:
                    System.out.println("Deletar Pets");
                    DeletarPets.deletarPorNome();
                    break;
                case 4:
                    System.out.println("Listar Pets");
                    ListarPets.Listar();
                    break;
                case 5:
                    System.out.println("Listar Pets por critério");
                    ListarPorCriterio.listPetsByCriterion();
                    break;
                case 6:
                    entrada.close();
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Por Favor digite os números");

        }
    }
}
