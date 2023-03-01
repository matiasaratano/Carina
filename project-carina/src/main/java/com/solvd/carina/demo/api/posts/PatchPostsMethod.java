package com.solvd.carina.demo.api.posts;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.env.base_url}/posts/${id}", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/posts/_patch/rq.json")
@ResponseTemplatePath(path = "api/posts/_patch/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PatchPostsMethod extends AbstractApiMethodV2 {
}

