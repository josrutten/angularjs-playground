package nl.iprofs.craftamship.angularjs.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import nl.iprofs.craftamship.angularjs.businessservice.BookService;
import nl.iprofs.craftamship.angularjs.model.Book;

@Path("/bookstore/")
public class BookRestService {

	private BookService bookService = new BookService();

	@GET
	@Path("/list/all.json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getAllBooks() {
		System.out.println("getAllBooks");
		return new ArrayList<Book>(bookService.getAll());
	}

	@GET
	@Path("/detail/{bookId}.json")
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBookDetail(@PathParam("bookId") String bookId) {
		System.out.println("getBookDetail bookId=" + bookId);
		return bookService.getBookById(bookId);
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateBook(Book book) {
		System.out.println("updateBook bookId=" + book.getId());
		bookService.updateBook(book);
	}

	@DELETE
	@Path("/delete/{bookId}")
	public void deleteBook(String bookId) {
		System.out.println("deleteBook bookId=" + bookId);
		bookService.deleteBook(bookId);
	}

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveBook(Book book) {
		System.out.println("saveBook bookId=" + book.getId());
		bookService.saveBook(book);
	}
	
}
