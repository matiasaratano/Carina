package com.solvd.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import com.solvd.carina.demo.api.GetPostsMethods;
import com.solvd.carina.demo.api.PostPostsMethod;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class SolvdTaskTest extends AbstractTest {
    private final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    @MethodOwner(owner = "maratano")
    public void testGetPosts() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/posts");
        Assert.assertEquals(response.getStatusCode(), 200);
        response.then().assertThat().body(matchesJsonSchemaInClasspath("posts-schema.json"));
    }

    @Test()
    @MethodOwner(owner = "maratano")
    public void testGetPostsTwo() {
        GetPostsMethods getPostsMethods = new GetPostsMethods();
        getPostsMethods.callAPIExpectSuccess();
        getPostsMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getPostsMethods.validateResponseAgainstSchema("api/posts/_get/rs.schema");
    }

    @Test
    @MethodOwner(owner = "maratano")
    public void testGetFirstPost() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/posts/1");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), 1);
        Assert.assertEquals(response.jsonPath().getString("title"), "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        Assert.assertEquals(response.jsonPath().getString("body"), "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");
    }

    @Test()
    @MethodOwner(owner = "maratano")
    public void testCreatePost() throws Exception {
        LOGGER.info("test");
        setCases("4555,54545");
        PostPostsMethod api = new PostPostsMethod();
        api.setProperties("api/posts/posts.properties");

        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "maratano")
    public void testCreatePostsMissingSomeFields() throws Exception {
        PostPostsMethod api = new PostPostsMethod();
        api.getProperties().remove("title");
        api.getProperties().remove("body");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

}
