package io.ministep.dadoc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.ministep.dadoc.controller.dto.BookRequest;
import io.ministep.dadoc.domain.Book;
import io.ministep.dadoc.repository.BookRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book create(BookRequest request) {
        Book book = Book.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .publisher(request.getPublisher())
                .totalPages(request.getTotalPages())
                .readPages(request.getReadPages())
                .status(request.getStatus())
                .rating(request.getRating())
                .memo(request.getMemo())
                .build();
        book.onCreate();
        return bookRepository.save(book);
    }

    public Book update(Long id, BookRequest request) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("존재하지 않는 책입니다."));

        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setIsbn(request.getIsbn());
        book.setPublisher(request.getPublisher());
        book.setTotalPages(request.getTotalPages());
        book.setReadPages(request.getReadPages());
        book.setStatus(request.getStatus());
        book.setRating(request.getRating());
        book.setMemo(request.getMemo());
        book.onUpdate();

        return bookRepository.save(book);
    }

    public Book find(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("존재하지 않는 책입니다."));
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

}
