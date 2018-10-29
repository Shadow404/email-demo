package com.pansoft.emaildemo.MaliServiceTest;

import com.pansoft.emaildemo.Service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {
    @Autowired
    private MailService mailService;
    @Test
    public void testMail()throws Exception{
        mailService.sendSimpleMail("1353520411@qq.com","主题：孙呆 ","维系渣渣辉，贪玩蓝月你值得玩一玩，不花一分钱，");
    }
    @Test
    public void testAttractMail()throws  Exception{
        String rscId = "lamei";
        String content="辣妹";
        mailService.sendAtrractMail("1328898169@qq .com","主题：性感宁宁在线",content,"E:\\123.jpg",rscId);
    }



}
