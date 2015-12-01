package br.com.cwi.crescer.controller.pedido;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.dto.PedidoListaDTO;
import br.com.cwi.crescer.service.ClienteService;
import br.com.cwi.crescer.service.ItemService;
import br.com.cwi.crescer.service.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    private PedidoService pedidoService;
    private ClienteService clienteService;
    private ItemService itemService;

    @Autowired
    public PedidoController(PedidoService pedidoService, ClienteService clienteService, ItemService itemService) {
        this.pedidoService = pedidoService;
        this.clienteService = clienteService;
        this.itemService = itemService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarPedidos());
    }

    @RequestMapping(path = "/incluir", method = RequestMethod.GET)
    public ModelAndView viewInclui() {
        return new ModelAndView("pedido/adicionar", "pedido", new PedidoDTO());
    }

    @RequestMapping(path = "/incluir", method = RequestMethod.POST)
    public ModelAndView incluir(@Valid @ModelAttribute("pedido") PedidoDTO dto, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return new ModelAndView("produto/adicionar");
        }

        pedidoService.incluir(dto);
        redirectAttributes.addFlashAttribute("mensagem", "Pedido inserido com sucesso!");
        return new ModelAndView("redirect:/pedidos");
    }

    @RequestMapping(path = "/itens/{id}", method = RequestMethod.GET)
    public ModelAndView viewEdita(@PathVariable("id") Long id) {
        PedidoListaDTO pedidoDTO = new PedidoListaDTO(pedidoService.buscarPorId(id));
        pedidoDTO.setItens(itemService.listarItensPedido(pedidoService.buscarPorId(id)));

        return new ModelAndView("pedido/itens", "pedidos", pedidoDTO);
    }

    @RequestMapping(path = "/processar/{id}", method = RequestMethod.GET)
    public ModelAndView processa(@PathVariable("id") Long id) {
        pedidoService.processaPedido(id);
        return new ModelAndView("redirect:/pedidos");
    }

    @RequestMapping(path = "/encerrar/{id}", method = RequestMethod.GET)
    public ModelAndView encerrar(@PathVariable("id") Long id) {
        pedidoService.encerraPedido(id);
        return new ModelAndView("redirect:/pedidos");
    }

    @RequestMapping(path = "/cancelar/{id}", method = RequestMethod.GET)
    public ModelAndView cancelar(@PathVariable("id") Long id) {
        pedidoService.cancelaPedido(id);
        return new ModelAndView("redirect:/pedidos");
    }

    @ModelAttribute("clientes")
    public List<Cliente> comboClientes() {
        return clienteService.listarClientesAtivos();
    }

}
