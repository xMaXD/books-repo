package xmax.dev.springdto.repository;

import xmax.dev.springdto.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
