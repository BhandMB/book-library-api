package com.bhandmb.booklibrary.service;

import com.bhandmb.booklibrary.dto.BookRequestDTO;
import com.bhandmb.booklibrary.dto.BookResponseDTO;
import com.bhandmb.booklibrary.dto.PageResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    PageResponse<BookResponseDTO> getAllBooks(Pageable pageable);
    BookResponseDTO getBookById(Long id);
    BookResponseDTO getBookByIsbn(String isbn);
    BookResponseDTO createBook(BookRequestDTO request);
    BookResponseDTO updateBook(Long id, BookRequestDTO request);
    void deleteBook(Long id);
    List<BookResponseDTO> searchBooks(String query);
    List<BookResponseDTO> getBooksByAuthor(String author);
    List<BookResponseDTO> getBooksByGenre(String genre);
    List<BookResponseDTO> getAvailableBooks();
    List<BookResponseDTO> getBooksByMinRating(Double minRating);
    BookResponseDTO toggleAvailability(Long id);
}
