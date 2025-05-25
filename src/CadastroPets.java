package src;

import java.io.*;
import java.util.Scanner;

public class CadastroPets {
    public static void Cadastrar() throws FileNotFoundException {
        String path = "C:\\Users\\wasle\\OneDrive\\Documentos\\GitHub\\CadastroPets\\src\\data\\formulario.txt";
        String pets = "C:\\Users\\wasle\\OneDrive\\Documentos\\GitHub\\CadastroPets\\src\\pets\\pets.txt";
        try (BufferedReader lerArq = new BufferedReader(new FileReader(path));
             BufferedWriter escreveArq = new BufferedWriter(new FileWriter(pets,true));
             Scanner scanner = new Scanner(System.in)
        ) {
            String linha;
            StringBuilder reportsPets = new StringBuilder();
            while ((linha = lerArq.readLine()) != null) {
                System.out.printf("%s\n", linha);
                System.out.println("Informe as Informações: ");
                String resposta = scanner.nextLine();
                escreveArq.write((resposta.isEmpty() ? "Não Informado" : resposta) + " | " );
            }

            escreveArq.write(reportsPets.toString());
            escreveArq.newLine(); // Cada pet está em uma linha no pets.txt
            System.out.println("Informações Salvas com Sucesso");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
