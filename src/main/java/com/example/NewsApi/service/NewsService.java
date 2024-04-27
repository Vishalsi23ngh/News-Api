package com.example.NewsApi.service;

import com.example.NewsApi.dto.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {

    @Autowired
    RestTemplate restTemplate;

    //https://newsapi.org/v2/top-headlines?country=us&apiKey=57902fdae4594ab393adb67a75393937
    String baseUrl = "https://newsapi.org/v2/top-headlines?country=";
    public Object getNews(String country, String apiKey) {

    String url = prepareUrl( country,  apiKey);

    NewsResponse  response = restTemplate.getForObject(url , NewsResponse.class);

    return  response;
    }
    public  String prepareUrl(String country, String apiKey){
       return baseUrl+country+'&'+"apiKey="+apiKey;
    }
}
