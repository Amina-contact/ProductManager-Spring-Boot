package org.sid;

import org.sid.dao.CategorieRepository;
import org.sid.dao.ClientRepository;
import org.sid.dao.ProduitRepository;
import org.sid.entities.Categorie;
import org.sid.entities.Client;
import org.sid.entities.Produit;
//import org.sid.entities.Produit;
//import org.sid.entities.Produit;
//import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.sun.xml.bind.v2.TODO;

@SpringBootApplication
public class CatalMvc6Application implements CommandLineRunner{
    @Autowired
	private ProduitRepository produitRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private ClientRepository clientRepository;
	public static void main(String[] args) {
		SpringApplication.run(CatalMvc6Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		//TODO Auto-generated method stub
		/*clientRepository.save(new Client(null,"Dahmouni","Amina","Taounate","C:\\Users\\Amina\\Downloads\\amina.png","aminadh@gmail.com"));
		clientRepository.save(new Client(null,"Dahmouni","Safae","Fes","C:\\Users\\Amina\\Downloads\\amina.png","safae@gmail.com"));
		clientRepository.save(new Client(null,"Hayouni","Mohammed","Tanger","C:\\Users\\Amina\\Downloads\\amina.png","mohammed@gmail.com"));
		clientRepository.save(new Client(null,"Alami","Honayda","Taounate","C:\\Users\\Amina\\Downloads\\amina.png","honayda@gmail.com"));*/
		clientRepository.findAll().forEach(cl->{
			
		System.out.println(cl.getPhoto() +" "+ cl.getPrenom());
		});
		/*categorieRepository.save(new Categorie(null,"PC"));
		 * #337ab7
		 *  background: #0B87A6;
		categorieRepository.save(new Categorie(null,"Imprimante"));
		categorieRepository.save(new Categorie(null,"Serveur"));
		categorieRepository.save(new Categorie(null,"Tablete"));*/
		categorieRepository.findAll().forEach(c->{
			
		System.out.println(c.getNomCat());
		});
		
		/*produitRepository.save(new Produit(null,"Imprimante lazer LG",1400.0,8));
		produitRepository.save(new Produit(null,"PC 5463",6000,12));
		produitRepository.save(new Produit(null,"Imprimante HP",1200,10));
		produitRepository.save(new Produit(null,"PC dell",9000,1));
		produitRepository.save(new Produit(null,"Lenovo Core i5",4200,10));
		produitRepository.save(new Produit(null,"Tablette",1800,20));
		produitRepository.save(new Produit(null,"Microsoft Windows Server",1944,3));
		produitRepository.save(new Produit(null,"Scanner LIDE 300",654,2));
		produitRepository.save(new Produit(null,"Imprimante HP DeskJet 2720",450,6));*/
		produitRepository.findAll().forEach(p->{
			System.out.println(p.getDesignation());
			//System.out.println(p.getCategorie());
		});
	}

}
