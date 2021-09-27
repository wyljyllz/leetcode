package wei.commonApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

/**
 * @ClassName TimeTest
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class TimeTest {
    public static void localTest() {//LocalDateTime类是LocalDate和LocalTime的结合体
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间：" + currentTime);
        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int second = currentTime.getSecond();
    }
    public static void zoneDateTest() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("当前时间" + now);
    }
    public static void dateTest() throws ParseException {
        Date date = new Date();
        System.out.println(date);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long l = System.currentTimeMillis();
        System.out.println(l);
        Date date1 = new Date(l);
        System.out.println(date1);
        //Instant instant = date.toInstant();//Instant用于表示一个时间戳
        Instant instant = Instant.now();
        System.out.println(System.currentTimeMillis());
        System.out.println(instant.getEpochSecond());
        Date from = Date.from(instant);
        System.out.println(from);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("G yyyy-MM-dd a z");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        Date date2 = simpleDateFormat.parse(format);
        System.out.println(date2);

    }
    public static void main(String[] args) {
        try {
            dateTest();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //localTest();
        //zoneDateTest();
    }
}
