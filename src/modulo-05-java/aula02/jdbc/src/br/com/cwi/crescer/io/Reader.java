package br.com.cwi.crescer.io;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Reader {

    public void readBuffer(String nmArquivo) throws IOException {
        BufferedReader buff = null;
        try {
            buff = new BufferedReader(new FileReader(nmArquivo));
            String linha = buff.readLine();
            while (linha != null) {
                System.out.println(linha);
                linha = buff.readLine();
            }
            buff.close();
        } catch (IOException e) {
            System.err.printf("Falha ao ler arquivo " + e.getMessage());
        } finally {
            buff.close();
        }
    }

    public void readBufferCloseable(String nmArquivo) {
        try (BufferedReader buff = new BufferedReader(new FileReader(nmArquivo))) {
            String linha = buff.readLine();
            while (linha != null) {
                System.out.println(linha);
                linha = buff.readLine();
            }
        } catch (IOException e) {
            System.err.printf("Falha ao ler arquivo " + e.getMessage());
        }
    }

    public void readScanner(String nmArquivo) {
        try {
            File file = new File(nmArquivo);
            Scanner scanner = new Scanner(file).useDelimiter("#"); // useDelimiter
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.printf("Falha ao ler arquivo " + e.getMessage());
        }
    }

    public void readJavaNio(String nmArquivo) {
        try {
            String dados = new String(Files.readAllBytes(new File(nmArquivo).toPath()));
            System.out.println(dados);
        } catch (IOException e) {
            System.err.printf("Falha ao ler arquivo " + e.getMessage());
        }
    }
}