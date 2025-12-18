package io.ministep.dadoc.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ministep.dadoc.controller.dto.BookRequest;
import io.ministep.dadoc.controller.dto.BookResponse;
import io.ministep.dadoc.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public BookResponse create(@Valid @RequestBody BookRequest request) {
        return BookResponse.from(bookService.create(request));
    }

    @GetMapping("/{id}")
    public BookResponse get(@PathVariable Long id) {
        return BookResponse.from(bookService.find(id));
    }

    @GetMapping
    public List<BookResponse> list() {
        return bookService.findAll().stream()
                .map(BookResponse::from)
                .toList();
    }

    @PutMapping("/{id}")
    public BookResponse updateString(@PathVariable Long id, @Valid @RequestBody BookRequest request) {
        return BookResponse.from(bookService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
}
