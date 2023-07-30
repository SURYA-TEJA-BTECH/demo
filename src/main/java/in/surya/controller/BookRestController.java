package in.surya.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.surya.entity.BookEntity;
import in.surya.service.BookServiceInterface;
import jakarta.websocket.server.PathParam;

@RestController
public class BookRestController {
	private BookServiceInterface bookServiceImp;
	
	public BookRestController( BookServiceInterface bookServiceImp ) {
		this.bookServiceImp=bookServiceImp;
	}

	@GetMapping("/")
	public ResponseEntity<String> displayMess() {

		String mess = "hi welcome to the book store   have a great time";

		return new ResponseEntity<String>(mess, HttpStatus.OK);

	}
	@GetMapping("/book")
	public ResponseEntity<List<BookEntity>> getAllBooksInfo() {

		List<BookEntity> books = bookServiceImp.getAllBooks();

		return new ResponseEntity<List<BookEntity>>(books, HttpStatus.OK);

	}
	
	
	@PostMapping("/book")
	public ResponseEntity<String> insert(@RequestBody BookEntity bookEntity) {

		String mess = bookServiceImp.upsert(bookEntity);

		return new ResponseEntity<String>(mess, HttpStatus.CREATED);

	}
	
	@PutMapping("/book")
	public ResponseEntity<String> update(@RequestBody BookEntity bookEntity) {

		String mess = bookServiceImp.upsert(bookEntity);

		return new ResponseEntity<String>(mess, HttpStatus.CREATED);

	}
	
	@DeleteMapping("/book/{bookid}")
	public ResponseEntity<String> deleteBook(@PathVariable("bookid") Integer bookid) {

		String mess = bookServiceImp.deleteBook(bookid);

		return new ResponseEntity<String>(mess, HttpStatus.OK);

	}
	
	
	
	
	

}
