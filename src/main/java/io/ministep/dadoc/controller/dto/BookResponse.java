package io.ministep.dadoc.controller.dto;

import java.time.LocalDateTime;

import io.ministep.dadoc.domain.Book;
import io.ministep.dadoc.domain.ReadingStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookResponse {

    private final Long id;
    private final String title;
    private final String author;
    private final String isbn;
    private final String publisher;
    private final Integer totalPages;
    private final Integer readPages;
    private final ReadingStatus status;
    private final Integer rating;
    private final String memo;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public static BookResponse from(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .publisher(book.getPublisher())
                .totalPages(book.getTotalPages())
                .readPages(book.getReadPages())
                .status(book.getStatus())
                .rating(book.getRating())
                .memo(book.getMemo())
                .createdAt(book.getCreatedAt())
                .updatedAt(book.getUpdatedAt())
                .build();
    }
}
