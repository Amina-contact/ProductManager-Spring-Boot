package org.sid.web;

import org.sid.dao.CategorieRepository;
import org.sid.entities.Categorie;
import org.sid.entities.Produit;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategorieController {
	@Autowired
	private CategorieRepository categorieRepository;
	
	@RequestMapping(value="/categories",method=RequestMethod.GET)
	 public String listCategories(Model model) {
		List<Categorie>  categories=categorieRepository.findAll();
		model.addAttribute("listCategories",categories);
		return "categories";
	}
	
    /*@PostMapping("/admin/saveCategorie")
    public String saveCategorie(Model model, @Valid Categorie categorie, BindingResult bindingResult) {
    	if(bindingResult.hasErrors()) return  "FormCategorie";
    	
    	categorieRepository.save(categorie);
    	return "redirect:/categories";
    }
    */
	@GetMapping("/admin/deletecategorie")
	public String deletecategorie(Long idCat) {
		categorieRepository.deleteById(idCat);
		return "redirect:/categories";
	}
	@GetMapping("/admin/addCategorie")
	public String add(Model model) {
		//pour afficher des donnees pae defaut dans ajouter categorie
		//new categorie car c'est un nouveau on ajoute
    	model.addAttribute("categorie",new Categorie());
		return "AddCategorie";
	}
	
	//@GetMapping("/admin/savecategprie") n'a pas fonctionner get not supported
	/* 
	 * Solution:   @RequestMapping(value = "/admin/savecategprie", method = { RequestMethod.GET, RequestMethod.POST })
	 * @GetMapping("/admin/savecategprie")
	 * @Valid pour la validation des formulaire
	 * bindingResult la ou on stock et oncategories verifie
	 * */
	@RequestMapping(value = "/admin/savecategprie", method = { RequestMethod.GET, RequestMethod.POST })
	public String savecategprie(Model model,@Valid Categorie categorie,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) return  "AddCategorie";
		
		categorieRepository.save(categorie);
		return "redirect:/categories";
	}
	
	@GetMapping("/admin/editcategorie")
	public String editcategorie(Model model, Long idCat) {
		//.get() pour retourner l'objet lui meme
		Categorie categorie=categorieRepository.findById(idCat).get();
		//ici il y'a pas de new car le produit deja existe 
    	model.addAttribute("categorie",categorie);
		return "EditCategorie";
	}
	
	
	
	

	

}
