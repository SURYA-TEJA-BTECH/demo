package in.surya.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.surya.entity.BookEntity;
import in.surya.reposistry.BookReposisistry;

@Service
public class BookServiceImp implements BookServiceInterface {

	private BookReposisistry bookReposisistry;
	
	public BookServiceImp(BookReposisistry bookReposisistry) {
		this.bookReposisistry = bookReposisistry;
	}

	// create and update
	public String upsert(BookEntity bookEntity) {

		Integer bookId = bookEntity.getBookId();

		bookReposisistry.save(bookEntity);
		if (bookId == null) {
			return "book inserted";
		} else {
			return "book updated";
		}

	}

	// retrive
	public List<BookEntity> getAllBooks() {

		return bookReposisistry.findAll();
	}

	// delete
	public String deleteBook(Integer bookId) {

		bookReposisistry.deleteById(bookId);
		return "book data deleted";
	}

}
