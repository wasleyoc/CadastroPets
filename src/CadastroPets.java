package src;

import java.io.*;
import java.util.Scanner;

public class CadastroPets {
    public static void Cadastrar() throws FileNotFoundException {
        String path = "C:\\Users\\wasle\\OneDrive\\Documentos\\GitHub\\CadastroPets\\src\\data\\formulario.txt";
        String pets = "C:\\Users\\wasle\\OneDrive\\Documentos\\GitHub\\CadastroPets\\src\\pets\\pets.txt";
        try (BufferedReader lerArq = new BufferedReader(new FileReader(path));
             BufferedWriter escreveArq = new BufferedWriter(new FileWriter(pets, true));
             Scanner scanner = new Scanner(System.in)
        ) {
            String linha;
            StringBuilder reportsPets = new StringBuilder();
            int pergunta = 0;
            while ((linha = lerArq.readLine()) != null) {
                System.out.printf("%s\n", linha);
                String resposta;

                // Este trecho trata a entrada do usuário para os campos específicos do formulário:
                // Se for a pergunta do tipo do pet, força a escolha entre cachorro ou gato usando enum.
                // Se for a pergunta do sexo do pet, força a escolha entre macho ou fêmea usando enum.
                // Para as demais perguntas, solicita uma resposta livre e preenche "Não Informado" se estiver em branco.
                if (pergunta == 1) {
                    PetsType tipo = null;
                    do {
                        System.out.println("Digite 1 para Cachorro ou 2 para Gato");
                        resposta = scanner.nextLine();
                        if (resposta.equals("1")) {
                             tipo = PetsType.CACHORRO;
                        } else if (resposta.equals("2")) {
                            tipo = PetsType.GATO;
                        } else {
                            System.out.println("Opção inválida, tente novamente.");
                        }
                    } while (tipo == null);
                    resposta = tipo.toString();
                } else if (pergunta == 2) {
                    PetsSex sexo = null;
                    do {
                        System.out.println("Digite 1 para Macho ou 2 para Fêmea");
                        resposta = scanner.nextLine();
                        if (resposta.equals("1")) {
                            sexo = PetsSex.MACHO;
                        } else if (resposta.equals("2")) {
                            sexo = PetsSex.FEMEA;
                        } else {
                            System.out.println("Opção inválida, tente novamente.");
                        }
                    } while (sexo == null);
                    resposta = sexo.toString();
                } else {
                    System.out.println("Informe suas Informações");
                    resposta = scanner.nextLine();
                    if (resposta.isEmpty()) resposta = "Não Informado";
                }
                reportsPets.append(resposta).append(" | ");
                pergunta++;
            }

//            while ((linha = lerArq.readLine()) != null) {
//                System.out.printf("%s\n", linha);
//                System.out.println("Informe as Informações: ");
//                String resposta = scanner.nextLine();
//                escreveArq.write((resposta.isEmpty() ? "Não Informado" : resposta) + " | " );
//            }

            escreveArq.write(reportsPets.toString());
            escreveArq.newLine(); // Cada pet está em uma linha no pets.txt
            System.out.println("Informações Salvas com Sucesso");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
