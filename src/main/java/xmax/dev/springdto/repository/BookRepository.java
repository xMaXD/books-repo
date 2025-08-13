package xmax.dev.springdto.repository;

import java.util.List;

import xmax.dev.springdto.model.Book;

public interface Bookrepository {
    Book save(Book book);

    List<Book> findAll();

    Book findById(Long id);



}
