package test.service;



import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author:renxin.tang
 * @Desc: 获取HTTP接口数据
 * @Date: Created in 19:31 2019/4/22
 */
public class HttpRequestUtil {
    public static String getData(String addess){
        URL url = null;
        HttpURLConnection httpConn = null;
        BufferedReader in = null;
        StringBuffer sb = new StringBuffer();
        try{
            url = new URL(addess);
            in = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8") );
            String str = null;
            while((str = in.readLine()) != null) {
                sb.append( str );
            }
        } catch (Exception ex) {
        } finally{
            try{
                if(in!=null) {
                    in.close();
                }
            }catch(IOException ex) {
            }
        }
        String  data =sb.toString();
        return data;
    }


    public static void main(String[] args) {
        String url = "http://127.0.0.1:8081/person";
        String data = getData(url);
        System.out.println(data);
    }
}

