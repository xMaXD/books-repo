package xmax.dev.springdto.mapper;

import xmax.dev.springdto.dto.BookDto;
import xmax.dev.springdto.dto.CreateBookRequestDto;
import xmax.dev.springdto.model.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto toDto(Book book);
    List<BookDto> toDtoList(List<Book> books);
    Book toEntity(CreateBookRequestDto dto);
}
