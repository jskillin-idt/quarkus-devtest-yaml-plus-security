package com.acme;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api")
public class TestResource {

  @GET
  @RolesAllowed("sample_role")
  public String getExample() {
    return "Hello World!";
  }
}
