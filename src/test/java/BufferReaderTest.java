import com.bosssoft.com.cn.hr.train.monitoring.service.XmlReadService;

import java.io.File;

public class BufferReaderTest {
    public static void main(String[] args)  {
        XmlReadService xmlFileReadWriteService = new XmlReadService();
        File file = new File("src/main/resources/xml/userInfo.xml");
        String xml = xmlFileReadWriteService.ReadXml(file);
        System.out.println(xml);
    }
}
