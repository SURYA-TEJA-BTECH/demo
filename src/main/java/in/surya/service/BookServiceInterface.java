package in.surya.service;

import java.util.List;

import in.surya.entity.BookEntity;

public interface BookServiceInterface {
	
	public String upsert(BookEntity bookEntity);
	
	
	public List<BookEntity> getAllBooks();
	
	public String deleteBook(Integer bookId);
	

}
