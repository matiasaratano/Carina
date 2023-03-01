package com.solvd.carina.demo.api.posts;


import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.env.base_url}/posts", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/posts/_post/rq.json")
@ResponseTemplatePath(path = "api/posts/_post/rs.json")
//@PropertiesPath(path = "api/posts/posts.properties")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostPostsMethod extends AbstractApiMethodV2 {
}