package com.solvd.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class SolvdTaskTest extends AbstractTest {
    private final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @Test
    @MethodOwner(owner = "maratano")
    public void testGetPosts() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/posts");
        Assert.assertEquals(response.getStatusCode(), 200);
        response.then().assertThat().body(matchesJsonSchemaInClasspath("posts-schema.json"));
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

}
