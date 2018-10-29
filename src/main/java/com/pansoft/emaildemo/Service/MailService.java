package com.pansoft.emaildemo.Service;

public interface MailService {
    public void sendSimpleMail(String to, String subject, String content);
    public void sendAtrractMail(String to,String subject,String content,String rscPath,String rscID);


}
