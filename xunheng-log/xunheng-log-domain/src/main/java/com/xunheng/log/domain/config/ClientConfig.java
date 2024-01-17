package com.xunheng.log.domain.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import java.util.List;


@ConfigurationProperties(prefix = "spring.elasticsearch") //配置的前缀
@Configuration
@Slf4j
public class ClientConfig {
    @Setter
    private String uris;


    /**
     * 解析配置的字符串，转为HttpHost对象数组
     *
     * @return
     */
    private HttpHost[] toHttpHost() {
        if (!StringUtils.hasLength(uris)) {
            throw new RuntimeException("invalid elasticsearch configuration");
        }
        String[] hostArray = uris.split(",");
        HttpHost[] httpHosts = new HttpHost[hostArray.length];
        HttpHost httpHost;
        for (int i = 0; i < hostArray.length; i++) {
            String[] strings = hostArray[i].split(":");
            httpHost = new HttpHost(strings[0], Integer.parseInt(strings[1]), "http");
            httpHosts[i] = httpHost;
        }
        return httpHosts;
    }

    @Bean("EsClient")
    public ElasticsearchClient EsClient() throws Exception {
        ElasticsearchTransport transport = getElasticsearchTransport("", "", toHttpHost());
        return new ElasticsearchClient(transport);
    }


    private static ElasticsearchTransport getElasticsearchTransport(String username, String passwd, HttpHost... hosts) {
        RestClient client = RestClient.builder(hosts)
                .setHttpClientConfigCallback(httpClientBuilder
                        ->httpClientBuilder.setDefaultHeaders(
                                List.of(new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString())))
                        .addInterceptorLast((HttpResponseInterceptor) (response, context)
                                -> response.addHeader("X-Elastic-Product", "Elasticsearch"))).build();
        return new RestClientTransport(client, new JacksonJsonpMapper());

    }


}
