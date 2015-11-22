package br.com.cwi.crescer;

import java.util.Scanner;

public class Apliacacao {

    public static void main(String[] args) throws Exception {


        final int FECHAR = 0;
        Scanner scanner = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();
        int opcao = 10;
        while (opcao != FECHAR) {
            System.out.println("Escolha uma opção");
            System.out.println("1 - Incluir Pedido"); // necessario buscar cliente ou incluir
            System.out.println("2 - Listar pedido de um cliente");
            System.out.println("3 - Buscar Pedido"); // load
            System.out.println("0 - Fechar");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o texto para inserir na lista");
                    String texto = scanner.nextLine();
                    linkedList.add(texto);
                    break;
                case 2:
                    System.out.println("Digite o índice do elemento para remover");
                    linkedList.remove(scanner.nextInt());
                    break;
                case 3:
                    System.out.println(linkedList.list());
                    break;
                default:
                    break;
            }
        }


    }
}
