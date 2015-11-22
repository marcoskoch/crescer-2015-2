package br.com.cwi.crescer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model){

        String mensagem = "Bem vindo a Lavanderia";
        model.addAttribute("mensagem", mensagem);

        return "index";
    }

}
