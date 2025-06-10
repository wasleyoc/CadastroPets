package src;

import java.io.*;
import java.util.*;

public class DeletarPets {

  public static void deletarPorNome() {
    String petsPath = "C:\\Users\\wasle\\OneDrive\\Documentos\\GitHub\\CadastroPets\\src\\pets\\pets.txt";
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite o nome do pet que deseja deletar: ");
    String nomeParaDeletar = scanner.nextLine().trim();

    List<String> linhasRestantes = new ArrayList<>();
    boolean deletou = false;

    try (BufferedReader lerArq = new BufferedReader(new FileReader(petsPath))) {
      String linha;
      while ((linha = lerArq.readLine()) != null) {
        String[] campos = linha.split("\\|");
        if (campos.length > 0 && campos[0].trim().equalsIgnoreCase(nomeParaDeletar)) {
          deletou = true; // Não adiciona a linha, ou seja, deleta
        } else {
          linhasRestantes.add(linha);
        }
      }
    } catch (IOException e) {
      System.out.println("Erro ao ler o arquivo: " + e.getMessage());
      return;
    }

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(petsPath, false))) {
      for (String l : linhasRestantes) {
        writer.write(l);
        writer.newLine();
      }
    } catch (IOException e) {
      System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
      return;
    }

    if (deletou) {
      System.out.println("Pet deletado com sucesso!");
    } else {
      System.out.println("Nenhum pet encontrado com esse nome.");
    }
  }
}
