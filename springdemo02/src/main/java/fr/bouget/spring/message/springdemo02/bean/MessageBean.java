package fr.bouget.spring.message.springdemo02.bean;

import org.springframework.stereotype.Component;

/**
 * @author Philippe
 *
 */
@Component("messageBean")
public class MessageBean {
	public String message()
	{
		return "Bonjour cher(e) apprenant(e) !";
		
	}
	
	public String message(String phrase)
	{
		return "Bonjour cher(e) apprenant(e), voici ta phrase : "+phrase;
		
	}
	
	

}
