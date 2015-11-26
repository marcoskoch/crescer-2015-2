package br.com.cwi.crescer.controller;

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

import br.com.cwi.crescer.domain.Cidade;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.service.CidadeService;
import br.com.cwi.crescer.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;
    private CidadeService cidadeService;

    @Autowired
    public ClienteController(ClienteService clienteService, CidadeService cidadeService) {
        this.clienteService = clienteService;
        this.cidadeService = cidadeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        return new ModelAndView("cliente/lista", "clientes", clienteService.listarClientesAtivos());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewExibe(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/exibe", "cliente", clienteService.buscarClientePorId(id));
    }

    @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
    public ModelAndView viewEdita(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/edita", "cliente", clienteService.buscarClientePorId(id));
    }

    @RequestMapping(path = "/editar", method = RequestMethod.POST)
    public ModelAndView editar(@Valid @ModelAttribute("cliente") ClienteDTO dto, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return new ModelAndView("cliente/edita");
        }

        clienteService.atualizar(dto);
        redirectAttributes.addFlashAttribute("mensagem", "Cliente editado com sucesso!");
        return new ModelAndView("redirect:/clientes");
    }

    @RequestMapping(path = "/remover/{id}", method = RequestMethod.GET)
    public ModelAndView viewRemove(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/remove", "cliente", clienteService.buscarClientePorId(id));
    }

    @RequestMapping(path = "/remover", method = RequestMethod.POST)
    public ModelAndView remover(ClienteDTO dto, RedirectAttributes redirectAttributes) {
        clienteService.desativar(dto);
        redirectAttributes.addFlashAttribute("mensagem", "Cliente removido com sucesso!");
        return new ModelAndView("redirect:/clientes");
    }

    @RequestMapping(path = "/incluir", method = RequestMethod.GET)
    public ModelAndView viewInclui() {
        return new ModelAndView("cliente/adicionar", "cliente", new ClienteDTO());
    }

    @RequestMapping(path = "/incluir", method = RequestMethod.POST)
    public ModelAndView incluir(@Valid @ModelAttribute("cliente") ClienteDTO dto, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return new ModelAndView("cliente/adicionar");
        }

        clienteService.incluir(dto);
        redirectAttributes.addFlashAttribute("mensagem", "Cliente inserido com sucesso!");
        return new ModelAndView("redirect:/clientes");
    }

    @ModelAttribute("cidades")
    public List<Cidade> comboCidades() {
        return cidadeService.listar();
    }
}
