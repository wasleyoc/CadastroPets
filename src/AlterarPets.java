package src;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlterarPets {
    public static void Alterar() throws IOException {
        String petsPath = "C:\\Users\\wasle\\OneDrive\\Documentos\\GitHub\\CadastroPets\\src\\pets\\pets.txt";
        List<String> lines = new ArrayList<>();

        // Lê todas as linhas
        try (BufferedReader reader = new BufferedReader(new FileReader(petsPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        // Conferir se o arquivo está vazio
        if (lines.isEmpty()) {
            System.out.println("Arquivo está vazio. ");
            return;
        }

        // Exibe as linhas numeradas
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ": " + lines.get(i));
        }

        // Pegando o número da linha que o usuário quer alterar.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número da linha (pet) que deseja alterar: ");
        int linhaEscolhida = scanner.nextInt();
        scanner.nextLine();

        if (linhaEscolhida < 1 || linhaEscolhida > lines.size()) {
            System.out.println("Linha Inválida");
            return;
        }

        // Edita o campos da linha escolhida
        String[] campos = lines.get(linhaEscolhida - 1).split("\\|");
        for (int i = 0; i < campos.length; i++) {
            System.out.println("Campo: " + (i + 1) + ": " + campos[i].trim());
            String newValue = scanner.nextLine();
            if (!newValue.isEmpty()) {
                campos[i] = newValue;
            }
        }

        // Atualiza a linha escolhida e coloca o delimitado para separar novamente as informações
        lines.set(linhaEscolhida - 1, String.join(" | ", campos));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(petsPath))) {
            for (String l : lines) {
                writer.write(l);
                writer.newLine();
            }
        }

        System.out.println("Alteração realizada com sucesso!");
    }
}
