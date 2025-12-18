package io.ministep.dadoc.controller.dto;

import io.ministep.dadoc.domain.ReadingStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {

    @NotBlank(message = "제목은 필수입니다.")
    private String title;

    @NotBlank(message = "저자는 필수입니다.")
    private String author;

    @NotBlank(message = "ISBN은 필수입니다.")
    private String isbn;

    private String publisher;

    @Positive(message = "총 페이지 수는 1 이상이어야 합니다.")
    private Integer totalPages;

    @PositiveOrZero(message = "읽은 페이지 수는 0 이상이어야 합니다.")
    private Integer readPages;

    @NotNull(message = "독서 상태는 필수입니다.")
    private ReadingStatus status;

    @Min(value = 1, message = "평점은 1 이상이어야 합니다.")
    @Max(value = 5, message = "평점은 5 이하여야 합니다.")
    private Integer rating;

    @Size(max = 2000, message = "메모는 2000자 이내여야 합니다.")
    private String memo;
}
