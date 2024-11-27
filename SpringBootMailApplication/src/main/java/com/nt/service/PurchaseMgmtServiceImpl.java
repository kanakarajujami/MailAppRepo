package com.nt.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service
public class PurchaseMgmtServiceImpl implements IPurchaseMgmtService {
	@Autowired
   private JavaMailSender sender;
	@Override
	public String shopping(String[] toMails, String[] items, Double[] prices) throws Exception {
		//calculate total bill amt
		 Double billAmt=0.0;
		 for(Double amt: prices) {
			 billAmt=billAmt+amt;
		 }
		 String msg1=Arrays.toString(items)+" prices are "+Arrays.toString(prices)+" with bill amount::"+billAmt;
		 //call mail method
		 String msg2=sendMail(toMails, msg1);
		return msg1+"........."+msg2;
		
	}//end of method
	private String sendMail(String[] toMails,String mailBody) throws Exception {
		//create mail and send mail
		MimeMessage message=sender.createMimeMessage();
		//create MimeMessageHelper object to send mail with attachment
		MimeMessageHelper helper=new MimeMessageHelper(message,true);
		//set mail header
		helper.setSentDate(new Date());
		helper.setSubject("Open it know it");
		helper.setBcc(toMails);
		//set mail body
		helper.setText(mailBody);
		helper.addAttachment("CR.jpeg", new ClassPathResource("CR.jpeg"));
		sender.send(message);
		return "mail delivered";
	
	}
}
