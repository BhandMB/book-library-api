package com.bhandmb.booklibrary;

import com.bhandmb.booklibrary.model.Book;
import com.bhandmb.booklibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSeeder implements CommandLineRunner {

    private final BookRepository bookRepository;

    @Override
    public void run(String... args) {
        if (bookRepository.count() == 0) {
            List<Book> books = List.of(
                Book.builder().title("The Pragmatic Programmer").author("Andrew Hunt")
                    .isbn("9780135957059").publishedYear(2019).genre("Technology")
                    .rating(4.8).description("A classic guide for software developers.").available(true).build(),
                Book.builder().title("Clean Code").author("Robert C. Martin")
                    .isbn("9780132350884").publishedYear(2008).genre("Technology")
                    .rating(4.7).description("A handbook of agile software craftsmanship.").available(true).build(),
                Book.builder().title("To Kill a Mockingbird").author("Harper Lee")
                    .isbn("9780061935466").publishedYear(1960).genre("Fiction")
                    .rating(4.9).description("A Pulitzer Prize-winning novel.").available(true).build(),
                Book.builder().title("1984").author("George Orwell")
                    .isbn("9780451524935").publishedYear(1949).genre("Dystopia")
                    .rating(4.8).description("A dystopian social science fiction novel.").available(false).build(),
                Book.builder().title("The Great Gatsby").author("F. Scott Fitzgerald")
                    .isbn("9780743273565").publishedYear(1925).genre("Fiction")
                    .rating(4.2).description("A story of the Jazz Age in America.").available(true).build(),
                Book.builder().title("Design Patterns").author("Gang of Four")
                    .isbn("9780201633610").publishedYear(1994).genre("Technology")
                    .rating(4.5).description("Elements of Reusable Object-Oriented Software.").available(true).build(),
                Book.builder().title("Dune").author("Frank Herbert")
                    .isbn("9780441013593").publishedYear(1965).genre("Science Fiction")
                    .rating(4.7).description("An epic science fiction novel set in the distant future.").available(true).build(),
                Book.builder().title("Sapiens").author("Yuval Noah Harari")
                    .isbn("9780062316097").publishedYear(2011).genre("Non-Fiction")
                    .rating(4.6).description("A brief history of humankind.").available(true).build()
            );
            bookRepository.saveAll(books);
            log.info("Seeded {} books into the database.", books.size());
        }
    }
}
