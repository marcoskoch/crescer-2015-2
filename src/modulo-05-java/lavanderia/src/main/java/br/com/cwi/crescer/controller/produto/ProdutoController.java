package br.com.cwi.crescer.controller.produto;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.dto.ProdutoDTO;
import br.com.cwi.crescer.service.MaterialService;
import br.com.cwi.crescer.service.ProdutoService;
import br.com.cwi.crescer.service.ServicoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;
    private ServicoService servicoService;
    private MaterialService materialService;

    @Autowired
    public ProdutoController(ProdutoService produtoService, ServicoService servicoService, MaterialService materialService) {
        this.produtoService = produtoService;
        this.servicoService = servicoService;
        this.materialService = materialService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        return new ModelAndView("produto/lista", "produtos", produtoService.listarProdutos());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
    public ModelAndView viewEdita(@PathVariable("id") Long id) {
        return new ModelAndView("produto/edita", "produto", produtoService.buscarClientePorId(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/incluir", method = RequestMethod.GET)
    public ModelAndView viewInclui() {
        return new ModelAndView("produto/adicionar", "produto", new ProdutoDTO());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/incluir", method = RequestMethod.POST)
    public ModelAndView incluir(@Valid @ModelAttribute("produto") ProdutoDTO dto, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return new ModelAndView("produto/adicionar");
        }

        produtoService.incluir(dto);
        redirectAttributes.addFlashAttribute("mensagem", "Produto inserido com sucesso!");
        return new ModelAndView("redirect:/produtos");
    }

    @ModelAttribute("servicos")
    public List<Servico> comboServicos() {
        return servicoService.listar();
    }

    @ModelAttribute("materiais")
    public List<Material> comboMateriais() {
        return materialService.listar();
    }

}
