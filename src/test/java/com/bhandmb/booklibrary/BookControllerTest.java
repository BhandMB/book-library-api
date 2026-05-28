package com.bhandmb.booklibrary;

import com.bhandmb.booklibrary.dto.BookRequestDTO;
import com.bhandmb.booklibrary.model.Book;
import com.bhandmb.booklibrary.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookControllerTest {

    @Autowired MockMvc mockMvc;
    @Autowired ObjectMapper objectMapper;
    @Autowired BookRepository bookRepository;

    @Test @Order(1)
    void getAllBooks_returnsOk() throws Exception {
        mockMvc.perform(get("/api/v1/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true));
    }

    @Test @Order(2)
    void createBook_validRequest_returnsCreated() throws Exception {
        BookRequestDTO dto = BookRequestDTO.builder()
                .title("Test Book").author("Test Author")
                .isbn("9781234567897").publishedYear(2023)
                .genre("Test").rating(4.0).available(true).build();

        mockMvc.perform(post("/api/v1/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.title").value("Test Book"));
    }

    @Test @Order(3)
    void createBook_duplicateIsbn_returnsConflict() throws Exception {
        BookRequestDTO dto = BookRequestDTO.builder()
                .title("Duplicate").author("Author")
                .isbn("9781234567897").publishedYear(2023)
                .genre("Test").available(true).build();

        mockMvc.perform(post("/api/v1/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isConflict());
    }

    @Test @Order(4)
    void getBookById_notFound_returns404() throws Exception {
        mockMvc.perform(get("/api/v1/books/9999"))
                .andExpect(status().isNotFound());
    }

    @Test @Order(5)
    void searchBooks_returnsResults() throws Exception {
        mockMvc.perform(get("/api/v1/books/search?query=clean"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true));
    }
}
