package com.learntechinst.sendgrid;

import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;

public class SendGridEmailDynamicTemplate {

	public static void main(String[] args) throws IOException {
		SendGrid sg = new SendGrid("SG.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		Request request = new Request();

		Mail mail = new Mail();
		mail.setFrom(new Email("XXXXXXXXX@gmail.com"));
		mail.setSubject("Send Grid Dynamic Template");

		Personalization personalization = new Personalization();
		personalization.addTo(new Email("XXXXXXXXX@gmail.com"));
		mail.addPersonalization(personalization);

		mail.setTemplateId("d-XXXXXXXXX"); 

		request.setMethod(Method.POST);
		request.setEndpoint("mail/send");
		request.setBody(mail.build());

		Response response = sg.api(request);

		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders());
		System.out.println(response.getBody());

	}

}
