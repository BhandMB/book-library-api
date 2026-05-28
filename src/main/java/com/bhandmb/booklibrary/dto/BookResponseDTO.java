package com.bhandmb.booklibrary.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponseDTO {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Integer publishedYear;
    private String genre;
    private Double rating;
    private String description;
    private Boolean available;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
