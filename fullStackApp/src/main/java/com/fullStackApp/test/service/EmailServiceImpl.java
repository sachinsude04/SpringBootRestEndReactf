package com.fullStackApp.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.fullStackApp.test.model.EmailDetails;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private JavaMailSender  javaMailSender;
	
	@Value("${spring.mail.username}")
	private String Sender;
	@Override
	public String sendSimpleMail(EmailDetails details) {
		// TODO Auto-generated method stub
		try {
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setFrom(Sender);
		mailMessage.setTo(details.getRecipient());
		mailMessage.setCc("shantanurangari8@gmail.com");
		mailMessage.setSubject(details.getSubject());
		mailMessage.setText(details.getMsgBody());
		
		javaMailSender.send(mailMessage);
		return "\"Mail Sent Successfully...\";";
		}
		catch(Exception ex) {
			return "Error while Sending Mail";
		}
		
		
		/*#############################################################################################################
		public String
    sendMailWithAttachment(EmailDetails details)
    {
        // Creating a mime message
        MimeMessage mimeMessage
            = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
 
        try {
 
            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(
                details.getSubject());
 
            // Adding the attachment
            FileSystemResource file
                = new FileSystemResource(
                    new File(details.getAttachment()));
 
            mimeMessageHelper.addAttachment(
                file.getFilename(), file);
 
            // Sending the mail
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }
 
        // Catch block to handle MessagingException
        catch (MessagingException e) {
 
            // Display message when exception occurred
            return "Error while sending mail!!!";
        }
    }
		//#############################################################################################################*/
		
		
		
		
	}
	
	

}
