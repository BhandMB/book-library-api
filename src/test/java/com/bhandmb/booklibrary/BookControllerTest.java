package com.bhandmb.booklibrary;

import com.bhandmb.booklibrary.dto.BookRequestDTO;
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
    void getAllBooks_returnsPaginatedResponse() throws Exception {
        mockMvc.perform(get("/api/v1/books?page=0&size=2&sort=title,asc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.data.page").value(0))
                .andExpect(jsonPath("$.data.size").value(2))
                .andExpect(jsonPath("$.data.totalElements").isNumber())
                .andExpect(jsonPath("$.data.totalPages").isNumber())
                .andExpect(jsonPath("$.data.content").isArray());
    }

    @Test @Order(2)
    void getAllBooks_invalidPageSize_returnsBadRequest() throws Exception {
        mockMvc.perform(get("/api/v1/books?page=0&size=101"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.success").value(false));
    }

    @Test @Order(3)
    void getAllBooks_invalidSortField_returnsBadRequest() throws Exception {
        mockMvc.perform(get("/api/v1/books?sort=unknown,asc"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.success").value(false));
    }

    @Test @Order(4)
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

    @Test @Order(5)
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

    @Test @Order(6)
    void getBookById_notFound_returns404() throws Exception {
        mockMvc.perform(get("/api/v1/books/9999"))
                .andExpect(status().isNotFound());
    }

    @Test @Order(7)
    void searchBooks_returnsResults() throws Exception {
        mockMvc.perform(get("/api/v1/books/search?query=clean"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true));
    }
}
