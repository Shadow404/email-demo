package com.pansoft.emaildemo.ServiceImpl;

import com.pansoft.emaildemo.Service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Slf4j
@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender sender;
    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        try{
            sender.send(simpleMailMessage);
            log.info("邮件已经发送 ");
        }catch (Exception e)
        {
            log.error("发送邮件异常!");
            log.error(e.getMessage());
        }
    }

    @Override
    public void sendAtrractMail(String to, String subject, String content, String rscPath, String rscID) {
        MimeMessage mimeMessage= sender.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);
            FileSystemResource res=new FileSystemResource(rscPath);
            helper.addInline(rscID,res);
            sender.send(mimeMessage);
            log.info("邮件已经发送");
        }catch (Exception e){
            log.error("嵌入文件异常");
            log.error(e.getMessage());
        }

    }
}

