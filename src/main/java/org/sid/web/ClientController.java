package org.sid.web;


import javax.validation.Valid;

import org.sid.dao.ClientRepository;
import org.sid.entities.Categorie;
import org.sid.entities.Client;
import org.sid.service.ClientService;
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
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ClientController {
	public String image;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ClientService  clientService;
	@GetMapping(value="/clients")
	public String listClients(Model model,@RequestParam(name="page",defaultValue="0") int page,@RequestParam(name="motCle",defaultValue="") String mc) {
		Page<Client>  pageclients=clientRepository.findByNomContains(mc,PageRequest.of(page, 3));
		model.addAttribute("listClients",pageclients.getContent());
		model.addAttribute("pages",new int[pageclients.getTotalPages()]);
		model.addAttribute("currentPage",page);
		model.addAttribute("motCle",mc);
		return "clients";
	}
	
	@GetMapping("/admin/deleteClient")
	public String deleteClient(Long idClient,int page,String motCle) {
		clientRepository.deleteById(idClient);
		return "redirect:/clients?page="+page+"&motCle="+motCle;
	}
	
	@GetMapping("/admin/addClient")
	public String addClient(Model model) {
		//pour afficher des donnees pae defaut dans ajouter categorie
		//new categorie car c'est un nouveau on ajoute
    	model.addAttribute("client",new Client());
		return "AddClient";
	}
	
	/*@RequestMapping(value = "/admin/saveclient", method = { RequestMethod.GET})
	public String saveclient(@RequestParam("file") MultipartFile file,@RequestParam("nom") String nom,@RequestParam("prenom") String prenom,@RequestParam("adresse") String adresse,@RequestParam("mail") String mail) {
		clientService.saveclientBD(file,nom,prenom,adresse,mail);
		return "redirect:/clients";
	}*/
	@RequestMapping(value = "/admin/saveclient", method = { RequestMethod.GET})
	public String saveclient(Model model,@Valid Client client,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) return  "AddClient";
		
		clientRepository.save(client);
		return "redirect:/clients";
	}
	
	@GetMapping("/admin/editclient")
	public String editclient(Model model, Long idClient) {
		//.get() pour retourner l'objet lui meme
		Client client=clientRepository.findById(idClient).get();
		//ici il y'a pas de new car le produit deja existe 
    	model.addAttribute("client",client);
		return "EditClient";
	}
	@GetMapping("/admin/viewclient")
	String viewclient(Model model, Long idClient) {
		//.get() pour retourner l'objet lui meme
		Client client=clientRepository.findById(idClient).get();
		//ici il y'a pas de new car le produit deja existe 
    	model.addAttribute("client",client);
		return "clientDetails";
	}
}
