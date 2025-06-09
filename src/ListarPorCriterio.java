package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ListarPorCriterio {

  public static void listPetsByCriterion() {
    String[] perguntas = { "Nome", "Tipo", "Sexo", "Endereço", "Cidade", "Idade", "Peso", "Raça" };
    String pets = "C:\\Users\\wasle\\OneDrive\\Documentos\\GitHub\\CadastroPets\\src\\pets\\pets.txt";

    Scanner scanner = new Scanner(System.in);
    System.out.println("Filtrar por: 1-Nome  2-Tipo  3-Raça");
    System.out.print("Escolha o critério (1/2/3): ");
    int criterio = scanner.nextInt();
    scanner.nextLine(); // consumir quebra de linha

    String busca = "";
    int indice = 0;
    switch (criterio) {
      case 1:
        System.out.print("Digite o nome do pet: ");
        busca = scanner.nextLine().trim();
        indice = 0;
        break;
      case 2:
        System.out.print("Digite o tipo do pet: ");
        busca = scanner.nextLine().trim();
        indice = 1;
        break;
      case 3:
        System.out.print("Digite a raça do pet: ");
        busca = scanner.nextLine().trim();
        indice = 7;
        break;
      default:
        System.out.println("Critério inválido.");
        return;
    }

    try (BufferedReader lerArq = new BufferedReader(new FileReader(pets))) {
      String linha;
      int count = 1;
      boolean encontrou = false;
      while ((linha = lerArq.readLine()) != null) {
        String[] respostas = linha.split("\\|");
        for (int i = 0; i < respostas.length; i++) {
          respostas[i] = respostas[i].trim();
        }

        boolean match = false;
        if (criterio == 1 && respostas.length > 0 && respostas[0].equalsIgnoreCase(busca)) {
          match = true; // Nome
        } else if (criterio == 2 && respostas.length > 1 && respostas[1].equalsIgnoreCase(busca)) {
          match = true; // Tipo
        } else if (criterio == 3 && respostas.length > 0 && respostas[respostas.length - 1].equalsIgnoreCase(busca)) {
          match = true; // Raça (último campo)
        }

        if (match) {
          encontrou = true;
          System.out.println("Pet #" + count++);
          for (int i = 0; i < respostas.length; i++) {
            System.out.println((i < perguntas.length ? perguntas[i] : "Campo " + (i + 1)) + ": " + respostas[i]);
          }
          System.out.println("----------------------");
        }
      }
      if (!encontrou) {
        System.out.println("Nenhum pet encontrado com o critério informado.");
      }
    } catch (IOException e) {
      System.out.println("Erro ao ler o arquivo de pets: " + e.getMessage());
    }
  }
}
