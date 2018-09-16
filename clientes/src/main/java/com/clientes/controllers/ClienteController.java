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

import com.clientes.models.Cliente;
import com.clientes.services.ClientesService;

@Controller
@RequestMapping(value="/cliente")
public class ClienteController {

	@Autowired
	private ClientesService clienteService;
	
    @RequestMapping(value="/listar_clientes", method=RequestMethod.GET)	
	public ModelAndView buscarTodosClientes() {
		ModelAndView mv = new ModelAndView("/cliente/listar");
		List<Cliente> listaClientes = clienteService.buscarTodosClientes();
		mv.addObject("listaClientes", listaClientes);
		return mv;
	}
    
  
    @RequestMapping(value="/incluir", method=RequestMethod.GET)
    public ModelAndView incluirCliente(Cliente cliente) {
    	ModelAndView mv = new ModelAndView("/cliente/insert");
    	mv.addObject("cliente", cliente);
    	return mv;
    }
    
    @RequestMapping(value="/incluir_cliente",method=RequestMethod.POST, params="action=Salvar")
    public ModelAndView insertCliente(Cliente cliente, BindingResult result, Model model, RedirectAttributes attributes) {
    	clienteService.insertCliente(cliente);
      	return new ModelAndView("redirect:/cliente/listar_clientes");
    }
	
    
    @RequestMapping(value="/alterar/{id}", method=RequestMethod.GET)
    public ModelAndView alterarCliente(@PathVariable("id") Long id, Model model) {
    	ModelAndView mv = new ModelAndView("/cliente/alterar");
    	Cliente cliente = clienteService.buscarCliente(id);
    	mv.addObject("cliente", cliente);
    	return mv;
    }
    
    @RequestMapping(value="/alterar_cliente",method=RequestMethod.POST, params="action=Salvar")
    public ModelAndView updateCliente(Cliente cliente, BindingResult result, Model model, RedirectAttributes attributes) {
    	clienteService.updateCliente(cliente);
    	return new ModelAndView("redirect:/cliente/listar_clientes");
    }
    
    /*
     * Rotina para exclusão dos registros da tabela. 
     */
    // rotina para fazer a busca do registro na tabela
    @RequestMapping(value="/excluir/{id}", method=RequestMethod.GET)
    public ModelAndView excluirCliente(@PathVariable("id") Long id, Model model) {
    	ModelAndView mv = new ModelAndView("/cliente/excluir");
    	Cliente cliente = clienteService.buscarCliente(id);
    	mv.addObject("cliente", cliente);
    	return mv;
    }
    
    // rotina para fazer a exclusão do registro na tabela
    @RequestMapping(value="/excluir_cliente",method=RequestMethod.POST,params="action=Salvar" )
    public ModelAndView removeCliente(Cliente cliente, BindingResult result, Model model, RedirectAttributes attributes) {
    	clienteService.removeCliente(cliente.getCliente_id());
    	return new ModelAndView("redirect:/cliente/listar_clientes");
    }
}
