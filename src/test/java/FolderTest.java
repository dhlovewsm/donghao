
import com.bosssoft.com.cn.hr.train.monitoring.entity.FileProperties;
import com.bosssoft.com.cn.hr.train.monitoring.service.FileScanner;
import java.io.File;
import java.util.List;

public class FolderTest {
    public static void main(String[] args)  {
        FileProperties fileProperties = new FileProperties();
        FileScanner scanner = new FileScanner();
        File file = new File(fileProperties.fileXmlString);
        List<String> list = scanner.scan(file);
        System.out.println(list);
    }
}
