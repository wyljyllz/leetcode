package test.service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TestNet
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class TestNet {
    private static URL url;
    private static HttpURLConnection con;
    private static int state = -1;

    /**
     * @param urlStr 指定URL网络地址
     * @return URL
     */
    public synchronized URL isConnect(String urlStr) {
            try {
                url = new URL(urlStr);
                con = (HttpURLConnection) url.openConnection();
                state = con.getResponseCode();
                if (state == 200) {
                    System.out.println("URL可用！");
                }
            }catch (Exception ex) {
                System.out.println("URL不可用");
                urlStr = null;
            }
        return url;
    }


    public static void main(String[] args) {
        TestNet u=new TestNet();
        String str1 = "https://longpay.ccb.com/ctmsacth5/#/couponDetail/14070926TKUS/";
       // int i = 90000;
        String str2 = "/14070926TKUS";
      //  System.out.println(str1 + i + str2);
        for (int i = 9000; i < 91000; i++) {
            URL connect = u.isConnect(str1 + i + str2);
            System.out.println(connect);

        }


    }
}
