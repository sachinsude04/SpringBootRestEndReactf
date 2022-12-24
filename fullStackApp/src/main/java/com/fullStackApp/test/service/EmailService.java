package com.fullStackApp.test.service;

import com.fullStackApp.test.model.EmailDetails;

public interface EmailService {

	String sendSimpleMail(EmailDetails details);
}
