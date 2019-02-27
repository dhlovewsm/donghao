import com.bosssoft.com.cn.hr.train.monitoring.entity.UserBean;
import com.thoughtworks.xstream.XStream;

public class XStreamTest {
    public static void main(String[] args) throws Exception {
        UserBean userBean = new UserBean();
        UserBean userBean1 = new UserBean();
        userBean.setUserId("52212");
        userBean.setUserName("董浩");
        userBean.setUserEmail("2857753688@qq.com");
        userBean1.setUserId("50012");
        userBean1.setUserName("mkie");
        userBean1.setUserEmail("sssss");
        XStream xStream = new XStream();
        xStream.alias("user", UserBean.class);
        System.out.println( xStream.toXML(userBean));
        System.out.println( xStream.toXML(userBean1));
    }
}
