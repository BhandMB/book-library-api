package com.bhandmb.booklibrary.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookRequestDTO {

    @NotBlank(message = "Title is required")
    @Size(max = 255)
    private String title;

    @NotBlank(message = "Author is required")
    @Size(max = 150)
    private String author;

    @NotBlank(message = "ISBN is required")
    @Pattern(regexp = "^(97(8|9))?\\d{9}(\\d|X)$", message = "Invalid ISBN format")
    private String isbn;

    @Min(1000) @Max(2100)
    private Integer publishedYear;

    @Size(max = 100)
    private String genre;

    @DecimalMin("0.0") @DecimalMax("5.0")
    private Double rating;

    @Size(max = 1000)
    private String description;

    private Boolean available = true;
}
