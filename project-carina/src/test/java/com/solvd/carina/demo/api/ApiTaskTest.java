package com.solvd.carina.demo.api;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.carina.demo.api.posts.GetPostsMethods;
import com.solvd.carina.demo.api.posts.PatchPostsMethod;
import com.solvd.carina.demo.api.posts.PostPostsMethod;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;


public class ApiTaskTest extends AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "maratano")
    public void testGetPosts() {
        GetPostsMethods getPostsMethods = new GetPostsMethods();
        getPostsMethods.callAPIExpectSuccess();
        getPostsMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPostsMethods.validateResponseAgainstSchema("api/posts/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "maratano")
    public void testCreatePost() throws Exception {
        LOGGER.info("Test Post");
        PostPostsMethod api = new PostPostsMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "maratano")
    public void testCreatePostsMissingSomeFields() throws Exception {
        PostPostsMethod api = new PostPostsMethod();
        api.getProperties().remove("title");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "maratano")
    public void testUpdatePosts() throws Exception {
        LOGGER.info("Test Post");
        PostPostsMethod api = new PostPostsMethod();
        api.setProperties("api/posts/posts.properties");
        Response response = api.callAPIExpectSuccess();
        api.validateResponse();

        PatchPostsMethod apiPatch = new PatchPostsMethod();
        apiPatch.replaceUrlPlaceholder("id", Integer.toString(response.jsonPath().getInt("id")));
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

}
