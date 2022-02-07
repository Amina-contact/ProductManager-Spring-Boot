package org.sid.web;

import javax.validation.Valid;

import org.sid.dao.CategorieRepository;

//import java.util.List;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Categorie;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	//@GetMapping("/index")
	@RequestMapping(value="/user/index",method=RequestMethod.GET)
	public String chercher(Model model,@RequestParam(name="page",defaultValue="0") int page,
	@RequestParam(name="motCle",defaultValue="") String mc) {
		 Page<Produit> pageproduits=produitRepository.findByDesignationContains(mc,PageRequest.of(page, 5));
		 model.addAttribute("listProduits",pageproduits.getContent());
		 model.addAttribute("pages",new int[pageproduits.getTotalPages()]);
		 model.addAttribute("currentPage",page);
		 model.addAttribute("motCle",mc);
		return "produits";
	}
	@GetMapping("/admin/delete")
	public String delete(Long id,int page,String motCle) {
		produitRepository.deleteById(id);
		return "redirect:/user/index?page="+page+"&motCle="+motCle;
	}
    @GetMapping("/admin/formProduit")
    public String form(Model model) {
    	//pour afficher des donnees pae defaut
    	model.addAttribute("produit",new Produit());
    	model.addAttribute("categorie",new Categorie());
    	model.addAttribute("categories",categorieRepository.findAll());
    	return "FormProduit";
    }
    @PostMapping("/admin/save")
    public String save(Model model, @Valid Produit produit, BindingResult bindingResult) {
    	
    	
    	produitRepository.save(produit);
    	return "redirect:/user/index";
    }
	@GetMapping("/admin/edit")
	public String edit(Model model,Long id) {
		Produit produit=produitRepository.findById(id).get();
    	model.addAttribute("categorie",new Categorie());
    	model.addAttribute("categories",categorieRepository.findAll());
		model.addAttribute("produit",produit);
		return "EditProduit";
	}
    @GetMapping("/")
    public String def() {
    	return "redirect:/user/index";
    }
    @GetMapping("/403")
    public String notAutorized(){
    	return "403";
    }
    @GetMapping("/login")
    public String login(){
    	return "login";
    }
    
    @GetMapping("/about")
    public String about(){
    	return "About";
    }
}
