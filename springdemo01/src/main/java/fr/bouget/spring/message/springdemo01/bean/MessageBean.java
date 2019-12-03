/**
 * 
 */
package fr.bouget.spring.message.springdemo01.bean;

import org.springframework.stereotype.Component;

/**
 * @author Philippe
 *
 */
@Component("messageBean")
public class MessageBean {
	public void message()
	{
		System.out.println("Bonjour cher(e) apprenant(e) !");
		
	}
	public void message(String phrase)
	{
		System.out.println("Bonjour cher(e) apprenant(e), voici ta phrase : "+phrase);
		
	}
	
	

}
