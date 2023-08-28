package com.acme;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.keycloak.client.KeycloakTestClient;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class TestResourceTest {

  KeycloakTestClient keycloakClient = new KeycloakTestClient();

  @Test
  public void runTest() {
    given()
        .auth().oauth2(keycloakClient.getAccessToken("alice"))
        .when().get("/api")
        .then()
        .statusCode(200)
        .body(equalTo("Hello World!"));
  }
}
