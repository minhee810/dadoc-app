package io.ministep.dadoc.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 책 제목
    @Column(nullable = false)
    private String title;

    // 저자
    @Column(nullable = false)
    private String author;

    // ISBN (국제표준도서번호)
    @Column(unique = true, nullable = false)
    private String isbn;

    // 출판사
    private String publisher;

    // 총 페이지 수
    private Integer totalPages;

    // 현재까지 읽은 페이지 수
    private Integer readPages;

    // 독서 상태 (READING, COMPLETED, WANT_TO_READ)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReadingStatus status;

    // 평점 (1 ~ 5)
    private Integer rating;

    // 한 줄 메모
    @Column(length = 6000) // (6000 byte) 2000자
    private String memo;

    // 생성일
    private LocalDateTime createdAt;

    // 수정일
    private LocalDateTime updatedAt;

    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
