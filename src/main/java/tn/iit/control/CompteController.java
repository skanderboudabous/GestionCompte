package tn.iit.control;


import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import tn.iit.entity.Client;
import tn.iit.entity.Compte;
import tn.iit.service.ClientService;
import tn.iit.service.CompteService;

@RestController
public class CompteController {
	
	@Autowired
    private CompteService compteService;
    @Autowired
    private ClientService clientService;
   

    @GetMapping(value = "/comptes")
    public ModelAndView getAllCompte(String keyword) {
        ModelAndView modelAndView = new ModelAndView();
        List<Compte> comptes;
        comptes = compteService.findAll();
        if (keyword != null) {
            comptes = compteService.findByType(keyword);
        }
        modelAndView.addObject("keyword", keyword);
        modelAndView.addObject("comptes", comptes);
        modelAndView.setViewName("comptes");
        return modelAndView;
    }

    @GetMapping(value = "/comptes/{id}")
    public ModelAndView getClinetsCompte(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        List<Compte> comptes;
        comptes = compteService.findCompteByClientId(id);
        modelAndView.addObject("comptes", comptes);
        modelAndView.setViewName("comptes");
        return modelAndView;
    }

    @GetMapping("/delete-compte/{id}")
    public ModelAndView deleteCompte(@PathVariable("id") long id) throws Exception {
        compteService.deleteCompte(id);
        List<Compte> comptes = compteService.findAll();
        ModelAndView model = new ModelAndView(new RedirectView("/comptes"));
        model.addObject("comptes", comptes);
        return model;
    }

    @PostMapping(value = "/update-compte")
    public ModelAndView updateCompte(Compte compte) {
        ModelAndView modelAndView = new ModelAndView(new RedirectView());
        compteService.saveCompte(compte);
        modelAndView.setViewName("redirect:comptes");
        return modelAndView;
    }

    @GetMapping(value = "/edit-compte/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") long id, ModelAndView modelAndView) throws Exception {
    	List<Client> clients;
        clients = clientService.findAll();
    	Compte compte = compteService.findCompById(id);
    	modelAndView.addObject("clients", clients);
        modelAndView.addObject("compte", compte);
        modelAndView.setViewName("edit-compte");
        return modelAndView;
    }
    
	@GetMapping(value = "/add-compte")
    public ModelAndView showAddCompteForm() {
        ModelAndView modelAndView = new ModelAndView();
        List<Client> clients;
        clients = clientService.findAll();
        modelAndView.addObject("clients", clients);
        Compte compte = new Compte();
        modelAndView.addObject("compte", compte);
        modelAndView.setViewName("add-compte");
        return modelAndView;
    }

    
    @PostMapping(value = "/save-compte")
    public ModelAndView saveCompte(Compte compte) {
        ModelAndView modelAndView = new ModelAndView(new RedirectView());   
        compteService.saveCompte(compte);
        modelAndView.setViewName("redirect:comptes");
        return modelAndView;
    }
	
}
