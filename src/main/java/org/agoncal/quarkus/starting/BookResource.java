package org.agoncal.quarkus.starting;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

	@Inject
	private BookRepository bookRepository;

	@Inject
	private Logger logger;

	@GET
	public List<Book> getAllBooks() {
		logger.info("Returns all the books");
		return this.bookRepository.getAllBooks();
	}

	@GET
	@Path("/count")
	@Produces(MediaType.TEXT_PLAIN)
	public int countAllBooks() {
		logger.info("Counting all the books");
		return this.bookRepository.countAllBooks();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Optional<Book> getBook(@PathParam("id") int id) {
		logger.info("Returns the book of id " + id);
		return this.bookRepository.getBook(id);
	}
}
