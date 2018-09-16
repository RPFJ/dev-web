package com.clientes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clientes.models.Cidade;
import com.clientes.services.CidadeService;

@Controller
@RequestMapping(value="/cidade")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;
	
    @RequestMapping(value="/listar_cidade", method=RequestMethod.GET)	
	public ModelAndView buscarTodosCidade() {
		ModelAndView mv = new ModelAndView("/cidade/listar");
		List<Cidade> listaCidades = cidadeService.buscarTodosCidade();
		mv.addObject("listaCidades", listaCidades);
		return mv;
	}
    
  
    @RequestMapping(value="/incluir", method=RequestMethod.GET)
    public ModelAndView incluirCidade(Cidade cidade) {
    	ModelAndView mv = new ModelAndView("/cidade/insert");
    	mv.addObject("cidade", cidade);
    	return mv;
    }
    
    @RequestMapping(value="/incluir_cidade",method=RequestMethod.POST, params="action=Salvar")
    public ModelAndView insertCidade(Cidade cidade, BindingResult result, Model model, RedirectAttributes attributes) {
    	cidadeService.insertCidade(cidade);
      	return new ModelAndView("redirect:/cidade/listar_cidade");
    }
	
    
    @RequestMapping(value="/alterar/{id}", method=RequestMethod.GET)
    public ModelAndView alterarCidade(@PathVariable("id") Long id, Model model) {
    	ModelAndView mv = new ModelAndView("/cidade/alterar");
    	Cidade cidade = cidadeService.buscarCidade(id);
    	mv.addObject("cidade", cidade);
    	return mv;
    }
    
    @RequestMapping(value="/alterar_cidade",method=RequestMethod.POST, params="action=Salvar")
    public ModelAndView updateCidade(Cidade cidade, BindingResult result, Model model, RedirectAttributes attributes) {
    	cidadeService.updateCidade(cidade);
    	return new ModelAndView("redirect:/cidade/listar_cidade");
    }
    
    @RequestMapping(value="/excluir/{id}", method=RequestMethod.GET)
    public ModelAndView excluirCidade(@PathVariable("id") Long id, Model model) {
    	ModelAndView mv = new ModelAndView("/cidade/excluir");
    	Cidade cidade = cidadeService.buscarCidade(id);
    	mv.addObject("cidade", cidade);
    	return mv;
    }
    
    @RequestMapping(value="/excluir_cidade",method=RequestMethod.POST,params="action=Salvar" )
    public ModelAndView removeCidade(Cidade cidade, BindingResult result, Model model, RedirectAttributes attributes) {
    	cidadeService.removeCidade(cidade.getCidade_id());
    	return new ModelAndView("redirect:/cidade/listar_cidade");
    }
}
