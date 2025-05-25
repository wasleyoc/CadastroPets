package src.main;

import src.AlterarPets;
import src.CadastroPets;
import src.ManipuladorArquivos;

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
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    entrada.close();
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        } catch (InputMismatchException e){
            System.out.println("Por Favor digite os números");

        }
    }
}