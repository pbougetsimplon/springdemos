package fr.bouget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.bouget.model.Adresse;
import fr.bouget.model.Client;
import fr.bouget.model.Telephone;
import fr.bouget.repository.ClientRepository;
import fr.bouget.repository.TelephoneRepository;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ProjetApiCriteriaApplication implements CommandLineRunner{

	
	@Bean
	   public Docket clientApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("fr.bouget")).build();
	   }
	
	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private TelephoneRepository telephoneRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetApiCriteriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Ajout des enregistrements pour les tests :
		
		  Adresse adresse1=new Adresse("5, rue du Renard","","75015","PARIS", "FRANCE");
          Client client1=new Client("MARTIN","Jean");
          client1.setCa(35000);
          client1=clientRepository.save(client1);
          
          Adresse adresse2=new Adresse("5, rue du Renard","","75015","PARIS","FRANCE");
          Client client2=new Client("DUPONT","sophie", adresse2);
          client2.setCa(60000);
          adresse2.setClient(client2);
          client2=clientRepository.save(client2);
          
          Adresse adresse3=new Adresse("20, boulevard Gambetta","","78300","POISSY","FRANCE");
          Client client3=new Client("DURAND","Pierre", adresse3);
          client3.setCa(15000);
          adresse3.setClient(client3);
          client3=clientRepository.save(client3);
          
          Adresse adresse4=new Adresse("29, boulevard Devaux","","78300","POISSY","FRANCE");
          Client client4=new Client("MADEC","Denis", adresse4);
          client4.setCa(5000);
          adresse4.setClient(client4);
          client4=clientRepository.save(client4);
          
          Client client5=new Client("MATHIEU","Daniel");
          client5.setCa(12000);
          clientRepository.save(client5);
          
          client1.setAdresse(adresse1);
          adresse1.setClient(client1);
          clientRepository.save(client1);
       
          Telephone tel1=new Telephone("01 43 65 87 34");
          telephoneRepository.save(tel1);
          client1.getTelephones().add(tel1);
        
          Telephone tel2=new Telephone("01 65 34 01 23");
          telephoneRepository.save(tel2);
          client2.getTelephones().add(tel2);
     
          Telephone tel3=new Telephone("02 78 99 41 73");
          telephoneRepository.save(tel3);
          client3.getTelephones().add(tel3);
        
          Telephone tel4=new Telephone("02 65 98 23 08");
          telephoneRepository.save(tel4);
          client4.getTelephones().add(tel4);
		
	}

}
