package org.agoncal.quarkus.starting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class BookResourceTest {

	@Test
	public void shouldGetAllBooks() {
		given().
			header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
		when().
			get("/api/books").
		then().
			statusCode(200).
			body("size()", is(4));
	}
	
	@Test
	public void shouldCountAllBooks() {
		given().
			header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN).
		when().
			get("/api/books/count").
		then().
			statusCode(200).
			body(is("4"));
	}
	
	@Test
	public void shouldGetBook() {
		given().
			header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
			pathParam("id", 1).
		when().
			get("/api/books/{id}").
		then().
			statusCode(200).
			body("title", is("Understanding Quarkus")).
			body("author", is("Antonio")).
			body("yearOfPublication", is(2020)).
			body("genere", is("IT"));
		
	}

}