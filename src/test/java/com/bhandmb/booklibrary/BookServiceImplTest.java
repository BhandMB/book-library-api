package com.bhandmb.booklibrary;

import com.bhandmb.booklibrary.dto.BookRequestDTO;
import com.bhandmb.booklibrary.dto.BookResponseDTO;
import com.bhandmb.booklibrary.exception.BookNotFoundException;
import com.bhandmb.booklibrary.exception.DuplicateIsbnException;
import com.bhandmb.booklibrary.model.Book;
import com.bhandmb.booklibrary.repository.BookRepository;
import com.bhandmb.booklibrary.service.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void getBookById_existingBook_returnsBook() {
        Book book = sampleBook();
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        BookResponseDTO result = bookService.getBookById(1L);

        assertEquals(1L, result.getId());
        assertEquals("Clean Architecture", result.getTitle());
        verify(bookRepository).findById(1L);
    }

    @Test
    void getBookById_missingBook_throwsNotFound() {
        when(bookRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(BookNotFoundException.class, () -> bookService.getBookById(99L));
        verify(bookRepository).findById(99L);
    }

    @Test
    void createBook_duplicateIsbn_throwsConflict() {
        BookRequestDTO request = request("9780134494166");
        when(bookRepository.existsByIsbn("9780134494166")).thenReturn(true);

        assertThrows(DuplicateIsbnException.class, () -> bookService.createBook(request));
        verify(bookRepository, never()).save(any(Book.class));
    }

    @Test
    void createBook_validRequest_savesBook() {
        BookRequestDTO request = request("9780134494167");
        Book saved = sampleBook();
        saved.setIsbn("9780134494167");

        when(bookRepository.existsByIsbn("9780134494167")).thenReturn(false);
        when(bookRepository.save(any(Book.class))).thenReturn(saved);

        BookResponseDTO result = bookService.createBook(request);

        assertEquals("9780134494167", result.getIsbn());
        verify(bookRepository).save(any(Book.class));
    }

    @Test
    void toggleAvailability_existingBook_flipsAvailability() {
        Book book = sampleBook();
        book.setAvailable(true);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(bookRepository.save(book)).thenReturn(book);

        BookResponseDTO result = bookService.toggleAvailability(1L);

        assertFalse(result.getAvailable());
        verify(bookRepository).save(book);
    }

    private BookRequestDTO request(String isbn) {
        return BookRequestDTO.builder()
                .title("Clean Architecture")
                .author("Robert C. Martin")
                .isbn(isbn)
                .publishedYear(2017)
                .genre("Technology")
                .rating(4.6)
                .description("Software architecture and design")
                .available(true)
                .build();
    }

    private Book sampleBook() {
        return Book.builder()
                .id(1L)
                .title("Clean Architecture")
                .author("Robert C. Martin")
                .isbn("9780134494166")
                .publishedYear(2017)
                .genre("Technology")
                .rating(4.6)
                .description("Software architecture and design")
                .available(true)
                .build();
    }
}
