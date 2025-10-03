package xmax.dev.springdto.service;

import xmax.dev.springdto.dto.BookDto;
import xmax.dev.springdto.dto.CreateBookRequestDto;
import xmax.dev.springdto.exception.EntityNotFoundException;
import xmax.dev.springdto.mapper.BookMapper;
import xmax.dev.springdto.model.Book;
import xmax.dev.springdto.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id " + id));
        return bookMapper.toDto(book);
    }

    public BookDto createBook(CreateBookRequestDto createBookRequestDto) {
        Book book = bookMapper.toEntity(createBookRequestDto);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);
    }

    public BookDto updateBook(Long id, CreateBookRequestDto createBookRequestDto) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id " + id));

        existingBook.setTitle(createBookRequestDto.getTitle());
        existingBook.setAuthor(createBookRequestDto.getAuthor());
        existingBook.setIsbn(createBookRequestDto.getIsbn());
        existingBook.setPrice(createBookRequestDto.getPrice());
        existingBook.setDescription(createBookRequestDto.getDescription());
        existingBook.setCoverImage(createBookRequestDto.getCoverImage());

        Book updatedBook = bookRepository.save(existingBook);
        return bookMapper.toDto(updatedBook);
    }

    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id " + id));

        bookRepository.delete(book);
    }
}
