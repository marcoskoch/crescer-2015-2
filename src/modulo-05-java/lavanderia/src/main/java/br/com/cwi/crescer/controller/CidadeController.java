package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cwi.crescer.service.CidadeService;

@Controller
@RequestMapping("/cidade")
public class CidadeController {

    private CidadeService cidadeService;

    @Autowired
    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    // @RequestMapping(path = "/json/cidades", produces = { MediaType.APPLICATION_JSON_VALUE })
    // @ResponseBody
    // public List<CidadeDTO> jsonCidades() {
    // return cidadeService.listar();
    // }

}
