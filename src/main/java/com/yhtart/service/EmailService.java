package com.yhtart.service;


import com.yhtart.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public boolean sendMail(String to, String subject, String content){
        // create MimeMessage object, and MimeMessageHelper object
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try{
            // set message properties
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);

            // send email
            mailSender.send(message);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean sendMailByCustomer(Customer customer){
        return true;
    }
}
