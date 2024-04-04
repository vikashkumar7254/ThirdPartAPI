package com.example.ThirdPartAPIIntegration.ThirdPartAPIIntegration.postservice;

import java.util.List;
import java.util.Map;

public interface PostService  {
    List<Map<String ,Object>> getPosts();
    Map<String ,Object>getPostById(int id);
}
