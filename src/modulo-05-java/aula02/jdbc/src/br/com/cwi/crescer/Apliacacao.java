package br.com.cwi.crescer;

import java.sql.SQLException;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.model.Cliente;

public class Apliacacao {

    public static void main(String[] args) throws SQLException {

        Cliente cliente = new Cliente();
        cliente.setIdCliente(15);
        cliente.setNmCliente("Marcos");
        cliente.setNrCpf("54654654654");
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.adiciona(cliente);

        /*
         * final int FECHAR = 0;
         * Scanner scanner = new Scanner(System.in);
         * LinkedList linkedList = new LinkedList();
         * int opcao = 10;
         * while (opcao != FECHAR) {
         * System.out.println("Escolha uma opção");
         * System.out.println("1 - Inserir na Lista");
         * System.out.println("2 - Remover da Lista");
         * System.out.println("3 - Listar estrutura");
         * System.out.println("0 - Fechar");
         * opcao = scanner.nextInt();
         * switch (opcao) {
         * case 1:
         * System.out.println("Digite o texto para inserir na lista");
         * String texto = scanner.nextLine();
         * linkedList.add(texto);
         * break;
         * case 2:
         * System.out.println("Digite o índice do elemento para remover");
         * linkedList.remove(scanner.nextInt());
         * break;
         * case 3:
         * System.out.println(linkedList.list());
         * break;
         * default:
         * break;
         * }
         * }
         */

    }
}
