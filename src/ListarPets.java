package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListarPets {
  public static void Listar() {
    String[] perguntas = { "Nome", "Tipo", "Sexo", "Endereço", "Idade", "Peso", "Raça" };
    // System.out.println("Listando todos os pets...");
    String pets = "C:\\Users\\wasle\\OneDrive\\Documentos\\GitHub\\CadastroPets\\src\\pets\\pets.txt";

    try (BufferedReader lerArq = new BufferedReader(new FileReader(pets))) {
      String linha;
      int count = 1;
      boolean encontrou = false;
      while ((linha = lerArq.readLine()) != null) {
        String[] respostas = linha.split("\\|");
        for (int i = 0; i < respostas.length; i++) {
          respostas[i] = respostas[i].trim();
        }
        encontrou = true;
        System.out.println("Pet #" + count++);
        for (int i = 0; i < perguntas.length; i++) {
          String valor = (i < respostas.length) ? respostas[i] : "(não informado)";
          System.out.println(perguntas[i] + ": " + valor);
        }
        System.out.println("----------------------");
      }
      if (!encontrou) {
        System.out.println("Nenhum pet cadastrado.");
      }
    } catch (IOException e) {
      System.out.println("Erro ao ler o arquivo de pets: " + e.getMessage());
    }
  }
}
