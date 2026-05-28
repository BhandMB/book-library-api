package com.bhandmb.booklibrary.service;

import com.bhandmb.booklibrary.dto.BookRequestDTO;
import com.bhandmb.booklibrary.dto.BookResponseDTO;
import com.bhandmb.booklibrary.exception.BookNotFoundException;
import com.bhandmb.booklibrary.exception.DuplicateIsbnException;
import com.bhandmb.booklibrary.model.Book;
import com.bhandmb.booklibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    @Transactional(readOnly = true)
    public List<BookResponseDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public BookResponseDTO getBookById(Long id) {
        return toDTO(findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public BookResponseDTO getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn)
                .map(this::toDTO)
                .orElseThrow(() -> new BookNotFoundException("Book not found with ISBN: " + isbn));
    }

    @Override
    public BookResponseDTO createBook(BookRequestDTO request) {
        if (bookRepository.existsByIsbn(request.getIsbn())) {
            throw new DuplicateIsbnException(request.getIsbn());
        }
        Book book = toEntity(request);
        return toDTO(bookRepository.save(book));
    }

    @Override
    public BookResponseDTO updateBook(Long id, BookRequestDTO request) {
        Book existing = findById(id);
        // Only check ISBN uniqueness if it changed
        if (!existing.getIsbn().equals(request.getIsbn()) &&
                bookRepository.existsByIsbn(request.getIsbn())) {
            throw new DuplicateIsbnException(request.getIsbn());
        }
        existing.setTitle(request.getTitle());
        existing.setAuthor(request.getAuthor());
        existing.setIsbn(request.getIsbn());
        existing.setPublishedYear(request.getPublishedYear());
        existing.setGenre(request.getGenre());
        existing.setRating(request.getRating());
        existing.setDescription(request.getDescription());
        if (request.getAvailable() != null) {
            existing.setAvailable(request.getAvailable());
        }
        return toDTO(bookRepository.save(existing));
    }

    @Override
    public void deleteBook(Long id) {
        findById(id);
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookResponseDTO> searchBooks(String query) {
        return bookRepository.searchBooks(query).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookResponseDTO> getBooksByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookResponseDTO> getBooksByGenre(String genre) {
        return bookRepository.findByGenreIgnoreCase(genre).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookResponseDTO> getAvailableBooks() {
        return bookRepository.findByAvailable(true).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookResponseDTO> getBooksByMinRating(Double minRating) {
        return bookRepository.findByMinRating(minRating).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponseDTO toggleAvailability(Long id) {
        Book book = findById(id);
        book.setAvailable(!book.getAvailable());
        return toDTO(bookRepository.save(book));
    }

    // ---- helpers ----

    private Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    private BookResponseDTO toDTO(Book book) {
        return BookResponseDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .publishedYear(book.getPublishedYear())
                .genre(book.getGenre())
                .rating(book.getRating())
                .description(book.getDescription())
                .available(book.getAvailable())
                .createdAt(book.getCreatedAt())
                .updatedAt(book.getUpdatedAt())
                .build();
    }

    private Book toEntity(BookRequestDTO dto) {
        return Book.builder()
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .isbn(dto.getIsbn())
                .publishedYear(dto.getPublishedYear())
                .genre(dto.getGenre())
                .rating(dto.getRating())
                .description(dto.getDescription())
                .available(dto.getAvailable() != null ? dto.getAvailable() : true)
                .build();
    }
}
