package com.example.javamail.demo;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class EmailSender {

	Logger logger = LogManager.getLogger(EmailSender.class);

	
    @Autowired
	private JavaMailSender mailSender;
	
    @Autowired
    private YamlConfig myConfig;
    
	public void sendEmail() {
		
		logger.debug(myConfig.getTo() + "    "+ myConfig.getFrom() );
		
		
		MimeMessage message = mailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		try {
		
		helper.setTo(myConfig.getTo());
		helper.setFrom(myConfig.getFrom());
		helper.setSubject("How are you !!!");
		helper.setText("fine weather today");
		mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
