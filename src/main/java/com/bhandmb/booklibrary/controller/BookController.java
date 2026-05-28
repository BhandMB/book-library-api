package com.bhandmb.booklibrary.controller;

import com.bhandmb.booklibrary.dto.ApiResponse;
import com.bhandmb.booklibrary.dto.BookRequestDTO;
import com.bhandmb.booklibrary.dto.BookResponseDTO;
import com.bhandmb.booklibrary.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
@Tag(name = "Books", description = "Book Library CRUD & search operations")
public class BookController {

    private final BookService bookService;

    @GetMapping
    @Operation(summary = "Get all books")
    public ResponseEntity<ApiResponse<List<BookResponseDTO>>> getAllBooks() {
        List<BookResponseDTO> books = bookService.getAllBooks();
        return ResponseEntity.ok(ApiResponse.success(books, "Fetched " + books.size() + " books"));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get book by ID")
    public ResponseEntity<ApiResponse<BookResponseDTO>> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(bookService.getBookById(id), "Book found"));
    }

    @GetMapping("/isbn/{isbn}")
    @Operation(summary = "Get book by ISBN")
    public ResponseEntity<ApiResponse<BookResponseDTO>> getBookByIsbn(@PathVariable String isbn) {
        return ResponseEntity.ok(ApiResponse.success(bookService.getBookByIsbn(isbn), "Book found"));
    }

    @PostMapping
    @Operation(summary = "Create a new book")
    public ResponseEntity<ApiResponse<BookResponseDTO>> createBook(
            @Valid @RequestBody BookRequestDTO request) {
        BookResponseDTO created = bookService.createBook(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(created, "Book created successfully"));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing book")
    public ResponseEntity<ApiResponse<BookResponseDTO>> updateBook(
            @PathVariable Long id,
            @Valid @RequestBody BookRequestDTO request) {
        return ResponseEntity.ok(ApiResponse.success(bookService.updateBook(id, request), "Book updated successfully"));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a book")
    public ResponseEntity<ApiResponse<Void>> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Book deleted successfully"));
    }

    @GetMapping("/search")
    @Operation(summary = "Search books by title, author or genre")
    public ResponseEntity<ApiResponse<List<BookResponseDTO>>> searchBooks(
            @RequestParam String query) {
        List<BookResponseDTO> results = bookService.searchBooks(query);
        return ResponseEntity.ok(ApiResponse.success(results, "Found " + results.size() + " results"));
    }

    @GetMapping("/author/{author}")
    @Operation(summary = "Get books by author")
    public ResponseEntity<ApiResponse<List<BookResponseDTO>>> getByAuthor(
            @PathVariable String author) {
        return ResponseEntity.ok(ApiResponse.success(bookService.getBooksByAuthor(author), "Books by " + author));
    }

    @GetMapping("/genre/{genre}")
    @Operation(summary = "Get books by genre")
    public ResponseEntity<ApiResponse<List<BookResponseDTO>>> getByGenre(
            @PathVariable String genre) {
        return ResponseEntity.ok(ApiResponse.success(bookService.getBooksByGenre(genre), "Books in genre: " + genre));
    }

    @GetMapping("/available")
    @Operation(summary = "Get all available books")
    public ResponseEntity<ApiResponse<List<BookResponseDTO>>> getAvailableBooks() {
        return ResponseEntity.ok(ApiResponse.success(bookService.getAvailableBooks(), "Available books"));
    }

    @GetMapping("/rating")
    @Operation(summary = "Get books with minimum rating")
    public ResponseEntity<ApiResponse<List<BookResponseDTO>>> getByMinRating(
            @RequestParam Double minRating) {
        return ResponseEntity.ok(ApiResponse.success(bookService.getBooksByMinRating(minRating),
                "Books with rating >= " + minRating));
    }

    @PatchMapping("/{id}/toggle-availability")
    @Operation(summary = "Toggle book availability")
    public ResponseEntity<ApiResponse<BookResponseDTO>> toggleAvailability(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(bookService.toggleAvailability(id), "Availability toggled"));
    }
}
