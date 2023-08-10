package com.learntechinst.sendgrid;

import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

public class SendGridEmail {
	
	public static void main(String[] args) throws IOException {
	    Email from = new Email("learntechinst@gmail.com");
	    String subject = "Sending with Twilio SendGrid";
	    Email to = new Email("learntechinst@gmail.com");
	    Content content = new Content("text/plain", "Welcome to Learn Technology Institute!!!");
	    Mail mail = new Mail(from, subject, to, content);

	    SendGrid sg = new SendGrid("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");
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println(response.getStatusCode());
	      System.out.println(response.getBody());
	      System.out.println(response.getHeaders());
	    } catch (IOException ex) {
	      throw ex;
	    }
	  }

}
