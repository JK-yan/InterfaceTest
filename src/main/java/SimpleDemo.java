import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by Administrator on 2016/8/4.
 */
public class SimpleDemo {

    public static void main(String[] args)  {


        CloseableHttpClient client = HttpClients.createDefault();
       /* URI uri = new URIBuilder().setScheme("https").setHost("www.baidu.com")
                .build();*/
        HttpGet httpGet = new HttpGet("http://www.sina.com.cn/");
        System.out.println(httpGet.getURI());
        //CloseableHttpResponse response= null;
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:39.0) Gecko/20100101 Firefox/39.0");
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);

        //获得起始行
        System.out.println(response.getStatusLine().toString()+"\n");
        //获得首部---当然也可以使用其他方法获取
        Header[] hs=response.getAllHeaders();
        System.out.println(hs.length);
        for(Header h:hs){
            System.out.println(h.getName()+":\t"+h.getValue()+"\n");
        }
         //获取响应体
        HttpEntity ety=null;
            try{
                ety=response.getEntity();
                System.out.println(EntityUtils.toString(ety,"UTF-8"));//新浪网的编码格式个GBK
            }catch (IOException e){
                e.printStackTrace();

            }finally {
                EntityUtils.consume(ety);//释放实体
            }



        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                response.close();//关闭响应
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

       /** try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                entity = new BufferedHttpEntity(entity);
                java.io.InputStream instream = entity.getContent();
                try {
                    System.out.println(instream.read());
                    System.out.println(instream.read());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    instream.close();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            response.close();
        }*/

      /*  System.out.println(response.getEntity());
        System.out.println(response.getStatusLine().toString());
        System.out.println(response.getStatusLine().getReasonPhrase());
        response.close();*/


    }

}




