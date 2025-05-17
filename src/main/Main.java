package main;

import services.Sexo;
import services.Tipos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static final String NAO_INFORMADO = "NÃO INFORMADO";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            try {
                System.out.println("\nBem-vindo ao sistema de cadastro de pets!");
                System.out.println("1. Cadastrar pet");
                System.out.println("2. Listar pets cadastrados");
                System.out.println("3. Deletar um pet cadastrado");
                System.out.println("4. Listar todos os pets cadastrados");
                System.out.println("5. Listar Pets por critério");
                System.out.println("6. Sair");
                System.out.print("Escolha uma opção: ");

                opcao = sc.nextInt();
                sc.nextLine(); // Limpar buffer

                switch (opcao) {
                    case 1:
                        cadastrarPet(sc);
                        break;
                    case 2:
                        listarPetsCadastrados();
                        break;
                    case 3:
                        deletarPet(sc);
                        break;
                    case 4:
                        listarTodosPets();
                        break;
                    case 5:
                        listarPorCriterio(sc);
                        break;
                    case 6:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                sc.nextLine(); // Limpar buffer em caso de erro
                opcao = 0; // Para continuar no loop
            }
        } while (opcao != 6);
        sc.close();
    }

    private static void cadastrarPet(Scanner sc) throws IOException {
        String arquivoPerguntas = "src/data/formulario.txt";
        String arquivoRespostas = "src/pets/respostas.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoPerguntas)); BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoRespostas, true))) {

            System.out.println("\n--- CADASTRO DE PET ---");
            String pergunta;
            int perguntaIndex = 1;

            while ((pergunta = br.readLine()) != null) {
                switch (perguntaIndex) {
                    case 1: // Nome e sobrenome
                        String nomeCompleto;
                        while (true) {
                            System.out.println(pergunta);
                            System.out.print("Resposta: ");
                            nomeCompleto = sc.nextLine().trim();
                            if (nomeCompleto.isEmpty()) {
                                nomeCompleto = NAO_INFORMADO;
                                break;
                            }
                            if (!nomeCompleto.matches("^[A-Za-zÀ-ÿ ]+$")) {
                                System.out.println("Nome inválido. Use apenas letras e espaços.");
                                continue;
                            }
                            String[] partes = nomeCompleto.split(" ");
                            if (partes.length < 2) {
                                System.out.println("Informe nome e sobrenome.");
                                continue;
                            }
                            break;
                        }
                        bw.write(nomeCompleto + "|");
                        break;
                    case 2: // Tipo do pet (ENUM)
                        System.out.println("Escolha o tipo do pet:");
                        for (Tipos tipo : Tipos.values()) {
                            System.out.println("- " + tipo.name() + " (" + tipo.getTipo() + ")");
                        }
                        Tipos tipoValido = null;
                        do {
                            System.out.print("Resposta: ");
                            String tipoEscolhido = sc.nextLine().toUpperCase();
                            try {
                                tipoValido = Tipos.valueOf(tipoEscolhido);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Tipo inválido. Tente novamente.");
                            }
                        } while (tipoValido == null);
                        bw.write(tipoValido.name() + "|");
                        break;
                    case 3: // Sexo do pet (ENUM)
                        System.out.println("Escolha o sexo do pet:");
                        for (Sexo sexo : Sexo.values()) {
                            System.out.println("- " + sexo.name());
                        }
                        Sexo sexoValido = null;
                        do {
                            System.out.print("Resposta: ");
                            String sexoEscolhido = sc.nextLine().toUpperCase();
                            try {
                                sexoValido = Sexo.valueOf(sexoEscolhido);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Sexo inválido. Tente novamente.");
                            }
                        } while (sexoValido == null);
                        bw.write(sexoValido.name() + "|");
                        break;
                    case 4: // Endereço (número, cidade, rua)
                        String numero, cidade, rua;
                        System.out.print("Número da casa: ");
                        numero = sc.nextLine().trim();
                        if (numero.isEmpty() || !numero.matches("\\d+")) numero = NAO_INFORMADO;
                        System.out.print("Cidade: ");
                        cidade = sc.nextLine().trim();
                        if (cidade.isEmpty()) cidade = NAO_INFORMADO;
                        System.out.print("Rua: ");
                        rua = sc.nextLine().trim();
                        if (rua.isEmpty()) rua = NAO_INFORMADO;
                        bw.write(rua + ", " + numero + ", " + cidade + "|");
                        break;
                    case 5: // Idade
                        String idadeStr;
                        double idade = -1;
                        while (true) {
                            System.out.print(pergunta + " ");
                            idadeStr = sc.nextLine().replace(",", ".").trim();
                            if (idadeStr.isEmpty()) {
                                idadeStr = NAO_INFORMADO;
                                break;
                            }
                            try {
                                idade = Double.parseDouble(idadeStr);
                                if (idade > 20) throw new IllegalArgumentException("Idade maior que 20 anos.");
                                if (idade < 1) {
                                    System.out.print("Idade em meses: ");
                                    String mesesStr = sc.nextLine().trim();
                                    if (!mesesStr.isEmpty() && mesesStr.matches("\\d+")) {
                                        double meses = Double.parseDouble(mesesStr);
                                        idade = meses / 12.0;
                                        idadeStr = String.format("%.1f", idade);
                                    } else {
                                        idadeStr = "0." + idadeStr;
                                    }
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println("Idade inválida. " + e.getMessage());
                            }
                        }
                        bw.write(idadeStr + "|");
                        break;
                    case 6: // Peso
                        String pesoStr;
                        double peso = -1;
                        while (true) {
                            System.out.print(pergunta + " ");
                            pesoStr = sc.nextLine().replace(",", ".").trim();
                            if (pesoStr.isEmpty()) {
                                pesoStr = NAO_INFORMADO;
                                break;
                            }
                            try {
                                peso = Double.parseDouble(pesoStr);
                                if (peso < 0.5 || peso > 60)
                                    throw new IllegalArgumentException("Peso fora do permitido (0.5kg a 60kg).");
                                break;
                            } catch (Exception e) {
                                System.out.println("Peso inválido. " + e.getMessage());
                            }
                        }
                        bw.write(pesoStr + "|");
                        break;
                    case 7: // Raça
                        String raca;
                        while (true) {
                            System.out.print(pergunta + " ");
                            raca = sc.nextLine().trim();
                            if (raca.isEmpty()) {
                                raca = NAO_INFORMADO;
                                break;
                            }
                            if (!raca.matches("^[A-Za-zÀ-ÿ ]+$")) {
                                System.out.println("Raça inválida. Use apenas letras.");
                                continue;
                            }
                            break;
                        }
                        bw.write(raca + "|");
                        break;
                    default: // Perguntas extras
                        System.out.print(pergunta + " ");
                        String resposta = sc.nextLine().trim();
                        if (resposta.isEmpty()) resposta = NAO_INFORMADO;
                        bw.write(resposta + "|");
                }
                perguntaIndex++;
            }
            bw.newLine();
            System.out.println("Pet cadastrado com sucesso!");
        }
    }

    private static void listarPetsCadastrados() throws IOException {
        // Implementar lógica de listagem
        System.out.println("\n--- PETS CADASTRADOS ---");
        // Código para ler e exibir pets
    }

    private static void deletarPet(Scanner sc) {
        // Implementar lógica de exclusão
        System.out.println("\n--- EXCLUIR PET ---");
        // Código para deletar pet
    }

    private static void listarTodosPets() throws IOException {
        System.out.println("\n--- TODOS OS PETS ---");
        List<String[]> pets = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/pets/respostas.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dadosPet = linha.split("\\|");
                pets.add(dadosPet);
            }
        }
        if (pets.isEmpty()) {
            System.out.println("Nenhum pet cadastrado.");
        } else {
            int count = 1;
            for (String[] pet : pets) {
                System.out.println("Pet #" + count++);
                for (int i = 0; i < pet.length; i++) {
                    System.out.println("Campo " + (i + 1) + ": " + pet[i]);
                }
                System.out.println("----------------------");
            }
        }
    }

    private static void listarPorCriterio(Scanner sc) {
        // Implementar lógica de filtro
        System.out.println("\n--- FILTRAR PETS ---");
        System.out.println("Critérios disponíveis: Nome, Tipo, Idade");
        // Código para filtrar
    }
}
