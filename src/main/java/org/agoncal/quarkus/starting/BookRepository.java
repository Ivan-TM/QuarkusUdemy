package org.agoncal.quarkus.starting;

import java.util.List;
import java.util.Optional;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookRepository {

	@ConfigProperty(name = "books.genere", defaultValue = "Sci-Fi")
	String genere;

	public List<Book> getAllBooks() {
		return List.of(new Book(1, "Understanding Quarkus", "Antonio", 2020, genere),
				new Book(2, "Practising Quarkus", "Antonio", 2020, genere),
				new Book(3, "Effective Java", "Josh Bloch", 2001, genere),
				new Book(4, "Thinking in java", "Bruce Eckel", 1998, genere));
	}

	public int countAllBooks() {
		return getAllBooks().size();
	}

	public Optional<Book> getBook(int id) {
		return getAllBooks().stream().filter(book -> book.id == id).findFirst();
	}
}
