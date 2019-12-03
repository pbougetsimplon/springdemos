/**
 * 
 */
package fr.bouget.spring.message.springdemo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.bouget.spring.message.springdemo02.bean.MessageBean;

/**
 * @author Philippe
 *
 */
@Controller
@RequestMapping("/demo2")
public class MessageController {
	
	@Autowired
	private MessageBean messageBean;
	
	@RequestMapping("/message")
	@ResponseBody
	public String afficherMessage()
	{
		return messageBean.message();
	}
	
	@RequestMapping("/message/{phrase}")
	@ResponseBody
	public String afficherMessage(@PathVariable("phrase") String phrase)
	{
		return messageBean.message(phrase);
	}

}
