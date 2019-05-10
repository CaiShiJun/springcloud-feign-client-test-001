package org.github.caishijun.springcloud.junit;

import org.github.caishijun.springcloud.http.HttpClientUtils;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class SpringCloudFeignJunitTest {

    private static String HOST = "localhost";
    private static int PORT = 8080;

    private static int FOR_TIMES = 1;
    private static int SLEEP_TIME = 0;

    public static String getUrl(String uri, String host, int port) {
        return "http://" + host + ":" + port + uri;
    }

    @Test
    public void feignClient() throws Exception {
        for (int i = 0; i < FOR_TIMES; i++) {
            String result = HttpClientUtils.sendGetRequest(getUrl("/feignClient/feignClient-dafsdfasdfas", HOST, PORT));
            System.out.println("result ： " + result);
            Thread.sleep(SLEEP_TIME);
        }
    }

    @Test
    public void restTemplate() throws Exception {
        for (int i = 0; i < FOR_TIMES; i++) {
            String result = HttpClientUtils.sendGetRequest(getUrl("/restTemplate/feignClient-dafsdfasdfas", HOST, PORT));
            System.out.println("result ： " + result);
            Thread.sleep(SLEEP_TIME);
        }
    }
}
