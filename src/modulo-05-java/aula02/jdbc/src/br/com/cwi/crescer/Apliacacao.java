package br.com.cwi.crescer;

import java.util.List;

import br.com.cwi.crescer.dao.PedidoDao;
import br.com.cwi.crescer.model.Pedido;

public class Apliacacao {

    public static void main(String[] args) throws Exception {

        Pedido pedido = new Pedido();
        pedido.setDsPedido("Pedido teste");

        PedidoDao pedidoDao = new PedidoDao();
        List<Pedido> lista = pedidoDao.find(pedido);

        for (Pedido pedidos : lista) {
            System.out.println(pedidos.getDsPedido());
        }

        // Servico servico = new Servico();
        // servico.setIdServico(2);
        // servico.setDsServico("Secagem de Roupa");
        //
        // ServicoDao servicoDao = new ServicoDao();
        // servicoDao.insert(servico);

        // List<Servico> lista = servicoDao.listAll();
        // for (Servico service : lista) {
        // System.out.println(service.getDsServico());
        // }

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
