/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pkg.email;


import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author MASTER
 */
public class SendEmail {
    
    public String getRandom(){
        Random rmd =new Random();
        int number =rmd.nextInt(999999);
        return String.format("%06d",number);
    }
    
    public boolean sendEmail(User user){
        boolean test= false;
        String fromEmail = "noduesclearance@gmail.com";
        String password ="euly zjha dbqj tbvg";
//        String fromEmail = "rohitkalampatil@gmail.com";
//        String password ="rohit0905";
        String toEmail = user.getEmail();
        try{
            Properties pr = new Properties();
            pr.setProperty("mail.smtp.host","smtp.gmail.com");
         
            pr.setProperty("mail.smtp.port","587");
            pr.setProperty("mail.smtp.auth","true");
            pr.setProperty("mail.smtp.starttls.enable","true");
//            //pr.setProperty("mail.smtp.host","smtp.mail.com");
//            pr.put("mail.smtp.socketFactory.port", "465");
//            pr.put("mail.smtp.socketFactory.class", "javax.mail.ssl.SSLSocketFactory");
            
            Session session = Session.getInstance(pr,new Authenticator(){
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(fromEmail, password);
                }
            });
            
            Message mess = new MimeMessage(session);
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            mess.setFrom(new InternetAddress(fromEmail));
            mess.setSubject("user verifn");
            mess.setText("use :"+user.getCode());
            
            Transport.send(mess);
            test=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return test;
    }
}
