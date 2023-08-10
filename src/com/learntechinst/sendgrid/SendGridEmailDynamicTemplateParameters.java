package com.learntechinst.sendgrid;

import java.io.IOException;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;

public class SendGridEmailDynamicTemplateParameters {

	public static void main(String[] args) throws IOException {
		SendGrid sg = new SendGrid("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");
		Request request = new Request();

		Mail mail = new Mail();
		mail.setFrom(new Email("learntechinst@gmail.com"));
		mail.setSubject("Send Grid Dynamic Template - Parameters");

		Personalization personalization = new Personalization();
		personalization.addTo(new Email("learntechinst@gmail.com"));
		personalization.addDynamicTemplateData("name", "Youtube Channel!!");
		mail.addPersonalization(personalization);

		mail.setTemplateId("d-8cc1bf343db34f16b04b3cf850898e32"); 

		request.setMethod(Method.POST);
		request.setEndpoint("mail/send");
		request.setBody(mail.build());

		Response response = sg.api(request);

		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders());
		System.out.println(response.getBody());

	}

}
