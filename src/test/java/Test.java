
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
        String str = date1.format(date);
        System.out.println(str);
    }
}
