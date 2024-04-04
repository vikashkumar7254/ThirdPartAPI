package com.example.ThirdPartAPIIntegration.ThirdPartAPIIntegration.impl;

import com.example.ThirdPartAPIIntegration.ThirdPartAPIIntegration.postservice.PostService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {
 String baseUrl="https://jsonplaceholder.typicode.com/";
 StringBuilder stringBuilder=new StringBuilder(baseUrl);
 String POST="/posts";
 String POSTBYID="/posts/";
@Autowired
    private RestTemplate restTemplate;
    @Override
    public List getPosts() {
        HttpEntity<Void>httpEntity=new HttpEntity<>(gethttpHeaders());
       String url= stringBuilder.append(POST).toString();
        val response= restTemplate.exchange(url, HttpMethod.GET,httpEntity, List.class);
        return response.getBody();
    }

    @Override
    public Map getPostById(int id) {
        HttpEntity<Void>httpEntity=new HttpEntity<>(gethttpHeaders());
        String url= stringBuilder.append(POSTBYID).append(id).toString();
       // val response= restTemplate.exchange(url, HttpMethod.GET,httpEntity, Map.class).getBody();
        return restTemplate.getForObject(url, Map.class);
    }

    private HttpHeaders gethttpHeaders() {
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
