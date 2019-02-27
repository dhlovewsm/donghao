
import com.bosssoft.com.cn.hr.train.monitoring.entity.Admin;
import com.bosssoft.com.cn.hr.train.monitoring.entity.UserBean;
import com.bosssoft.com.cn.hr.train.monitoring.service.LoadFile;
import com.bosssoft.com.cn.hr.train.monitoring.entity.Mail;
import com.bosssoft.com.cn.hr.train.monitoring.service.SendEmailService;
import org.dom4j.DocumentException;
import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class XStreamTest1 {
    public static void main(String[] args) throws IOException, MessagingException, DocumentException {
        SendEmailService sendEmailService = new SendEmailService();
        LoadFile loadFile = new LoadFile();
        File userFile = new File("src/main/resources/xml/userInfo.xml");
        File adminFile = new File("src/main/resources/xml/adminInfo.xml");
        File mailFile = new File("src/main/resources/xml/mailInfo.xml");
        Admin admin = loadFile.LoadAdminFile(adminFile);
        List<UserBean> userList = loadFile.LoadUserFile(userFile);
        List<Mail> mailList = loadFile.LoadMailFile(mailFile);
        Mail mail = mailList.get(0);
        List<String> contacts = new ArrayList<>();
        for (UserBean userBean : userList){         /**/
            contacts.add(userBean.getUserEmail());
        }
        sendEmailService.SendEmail(admin,contacts,mail);
    }

}
