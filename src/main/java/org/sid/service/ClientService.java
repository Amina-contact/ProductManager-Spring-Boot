package org.sid.service;

import java.io.IOException;
import java.util.Base64;

import org.sid.dao.ClientRepository;
import org.sid.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	public void saveclientBD(MultipartFile file,String nom,String prenom,String adresse,String mail) {
		Client client = new Client();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			client.setPhoto(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setAdresse(adresse);
		client.setMail(mail);
		
		clientRepository.save(client);
	}

}
