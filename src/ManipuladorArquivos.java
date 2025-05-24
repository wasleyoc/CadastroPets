package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ManipuladorArquivos {
    public static void ler(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String linha = "";

        while (true) {
            if (linha != null) {
                System.out.println(linha);
            } else {
                break;
            }
            linha = bufferedReader.readLine();
        }
        bufferedReader.close();
    }
}
