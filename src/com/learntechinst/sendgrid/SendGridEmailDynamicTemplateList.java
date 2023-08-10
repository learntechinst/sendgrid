package com.learntechinst.sendgrid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;

public class SendGridEmailDynamicTemplateList {

	public static void main(String[] args) throws IOException {
		SendGrid sg = new SendGrid("SG.XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		Request request = new Request();

		Mail mail = new Mail();
		mail.setFrom(new Email("XXXXXXXXX@gmail.com"));
		mail.setSubject("Send Grid Dynamic Template - List");

		Personalization personalization = new Personalization();
		personalization.addTo(new Email("XXXXXXXXX@gmail.com"));
		personalization.addDynamicTemplateData("name", "Youtube Channel!!");
		personalization.addDynamicTemplateData("course_list", getCourseList());
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

	private static List<Course> getCourseList() {

		List<Course> courseList = new ArrayList<>();
		courseList.add(new Course(1, "Java"));
		courseList.add(new Course(1, "Spring Boot"));
		courseList.add(new Course(1, "AWS"));
		courseList.add(new Course(1, "ELK"));
		courseList.add(new Course(1, "Design Patterns"));

		return courseList;
	}

}
