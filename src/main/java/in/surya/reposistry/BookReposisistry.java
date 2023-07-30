package in.surya.reposistry;

import org.springframework.data.jpa.repository.JpaRepository;

import in.surya.entity.BookEntity;

public interface BookReposisistry<T> extends JpaRepository<BookEntity, Integer> {

}
