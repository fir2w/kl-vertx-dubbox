package com.klwork.spring.vertx.common;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * HttpUtils 处理http请求
 * 
 * https://hc.apache.org/httpcomponents-client-ga/tutorial/html/connmgmt.html
 * 
 * @author dz
 * 
 */
public class HttpUtils {

    private static final Logger LOG = LoggerFactory.getLogger(HttpUtils.class);

    private static CloseableHttpClient httpClient;

    private static final int SOCKET_TIMEOUT = 1000 * 3;
    private static final int CONNECT_TIMEOUT = 1000 * 3;

    static {

        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        // Increase max total connection to 200
        cm.setMaxTotal(200);
        // Increase default max connection per route to 20
        cm.setDefaultMaxPerRoute(20);
        // Increase max connections for localhost:80 to 50
        HttpHost localhost = new HttpHost("locahost", 8080);
        cm.setMaxPerRoute(new HttpRoute(localhost), 50);

        RequestConfig config = RequestConfig.custom().setSocketTimeout(SOCKET_TIMEOUT).setConnectTimeout(CONNECT_TIMEOUT).build();

        httpClient = HttpClients.custom().setConnectionManager(cm).setDefaultRequestConfig(config).build();
        // .setKeepAliveStrategy(keepAliveStrategy)

    }

    public static String post(String url, List<Header> headers, String post) throws IOException, ClientProtocolException {

        return request(new HttpPost(url), headers, null, post);
    }

    public static String post(String url, String post) throws IOException, ClientProtocolException {

        return request(new HttpPost(url), null, null, post);
    }

    public static String get(String url, Map<String, String> params) throws IOException, ClientProtocolException {

        return request(new HttpGet(url), null, null, null);
    }

        private static String request(HttpRequestBase httpRequest, List<Header> headers, List<NameValuePair> nvps, String postData) throws IOException,
            ClientProtocolException {

        String result = "";
        CloseableHttpResponse response = null;

        try {

            if (headers != null && !headers.isEmpty()) {
                for (Header header : headers) {
                    httpRequest.addHeader(header);
                }
            }

            if (nvps != null && !nvps.isEmpty() && httpRequest instanceof HttpPost) {
                ((HttpPost) httpRequest).setEntity(new UrlEncodedFormEntity(nvps));
            }

            if (postData != null && httpRequest instanceof HttpPost) {
                ((HttpPost) httpRequest).setEntity(new StringEntity(postData,"UTF-8"));
            }

            response = httpClient.execute(httpRequest);
            HttpEntity entity = response.getEntity();

            result = EntityUtils.toString(entity);

            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity);

        } catch (ClientProtocolException e) {
            LOG.error(e.getMessage(), e);
            throw e;
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            throw e;
        } finally {
            closeQuietly(response);
        }

        return result;
    }

    private static void closeQuietly(Closeable c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (IOException ioe) {
            // ignore
        }
    }

}
