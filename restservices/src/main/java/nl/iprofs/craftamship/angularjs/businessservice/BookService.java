package nl.iprofs.craftamship.angularjs.businessservice;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import nl.iprofs.craftamship.angularjs.model.Book;
import nl.iprofs.craftamship.angularjs.model.Review;

public class BookService {

	private static Map<String, Book> allBooks;
	static {
		allBooks = new HashMap<String, Book>();

		Book book = new Book("gouden_ei", "Het gouden ei", "Roald Dahl",
				new BigDecimal("14.50"));
		allBooks.put(book.getId(), book.addReview(
				new Review("Trouw", "Leuk voor volwassenen")).addReview(
				new Review("Volkskrant", "Taaie kost!")));

		book = new Book("koning_van_katoren", "Koning van Katoren",
				"Jan Terlouw", new BigDecimal("18.95"));
		allBooks.put(book.getId(), book.addReview(
				new Review("Trouw", "Heel politiek correct!")).addReview(
				new Review("NRC", "Goed kinderboek!")));

		book = new Book("lord_of_the_rings", "Lord of the Rings",
				"JRR Tolkien", new BigDecimal("12.95"));
		allBooks.put(book.getId(), book.addReview(
				new Review("Telegraaf", "Spannend boek hoor!")).addReview(
				new Review("NRC", "Beetje voor het gewone volk!")));

		book = new Book("pet_cemetery", "Pet Cemetery", "Stephen King",
				new BigDecimal("18.75"));
		allBooks.put(book.getId(), book.addReview(
				new Review("New York Times",
						"Splended, really scary as it should be!")).addReview(
				new Review("NRC", "Echt heel erg freaky!")));

		book = new Book("sjakie_chocolade", "Sjakie en de chocolade fabriek",
				"Roald Dahl", new BigDecimal("9.99"));
		allBooks.put(book.getId(), book
				.addReview(
						new Review("Volkskrant",
								"Een goede kandidaat voor verfilming."))
				.addReview(new Review("Spits", "Heel bizar!")));
	}

	public Set<Book> getAll() {
		return Collections
				.unmodifiableSet(new HashSet<Book>(allBooks.values()));
	}

	public Book getBookById(String bookId) {
		return allBooks.get(bookId);
	}

	public void updateBook(Book book) {
		if (allBooks.containsKey(book.getId())) {
			allBooks.put(book.getId(), book);
		} else {
			throw new IllegalStateException(
					"Cannot update non existing book with id:" + book.getId());
		}
	}

	public void deleteBook(String bookId) {
		if (allBooks.containsKey(bookId)) {
			allBooks.remove(bookId);
		} else {
			throw new IllegalStateException(
					"Cannot delete non existing book with id:" + bookId);
		}
	}

	public void saveBook(Book book) {
		if (book.getId() != null && !book.getId().isEmpty()) {
			throw new IllegalStateException(
					"Cannot save new book id is already set" + book.getId());
		}
		book.setId(generateBookId(book));
		if (allBooks.containsKey(book.getId())) {
			throw new IllegalStateException("Cannot save new book, book already exists with id:" + book.getId());
		} else {
			allBooks.put(book.getId(), book);
		}
	}

	private String generateBookId(Book book) {
		String firstGuess = book.getTitle().replace(' ', '_').toLowerCase();
		if (allBooks.containsKey(firstGuess)) {
			String secondGuess = firstGuess + '-' + book.getAuthor().replace(' ', '_').toLowerCase();
			if (allBooks.containsKey(secondGuess)) {
				String thirdGuess = secondGuess +  '_' +  System.currentTimeMillis();
				return thirdGuess;
			} else {
				return secondGuess;
			}
		} else {
			return firstGuess;
		}

	}
}
