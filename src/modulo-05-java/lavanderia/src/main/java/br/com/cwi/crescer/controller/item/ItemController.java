package br.com.cwi.crescer.controller.item;

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

import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.dto.ItemDTO;
import br.com.cwi.crescer.service.ItemService;
import br.com.cwi.crescer.service.PedidoService;
import br.com.cwi.crescer.service.ProdutoService;

@Controller
@RequestMapping("/itens")
public class ItemController {

    private ItemService itemService;
    private PedidoService pedidoService;
    private ProdutoService produtoService;

    @Autowired
    public ItemController(ItemService itemService, PedidoService pedidoService, ProdutoService produtoService) {
        this.itemService = itemService;
        this.pedidoService = pedidoService;
        this.produtoService = produtoService;
    }

    @RequestMapping(path = "/incluir/{id}", method = RequestMethod.GET)
    public ModelAndView viewInclui(@PathVariable("id") Long id) {
        ItemDTO dto = new ItemDTO();
        dto.setIdPedido(id);
        return new ModelAndView("item/adicionar", "item", dto);
    }

    @RequestMapping(path = "/incluir", method = RequestMethod.POST)
    public ModelAndView incluir(@Valid @ModelAttribute("item") ItemDTO dto, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return new ModelAndView("item/adicionar");
        }

        itemService.incluir(dto);
        redirectAttributes.addFlashAttribute("mensagem", "Pedido inserido com sucesso!");
        return new ModelAndView("redirect:/pedidos/itens/" + dto.getIdPedido());
    }

    @RequestMapping(path = "/processar/{id}", method = RequestMethod.GET)
    public ModelAndView processa(@PathVariable("id") Long id) {
        itemService.processaItem(id);
        Item item = itemService.buscarPorId(id);
        return new ModelAndView("redirect:/pedidos/itens/" + item.getPedido().getIdPedido());
    }

    @ModelAttribute("produtos")
    public List<Produto> comboProdutos() {
        return produtoService.listarProdutosCombo();
    }

}
