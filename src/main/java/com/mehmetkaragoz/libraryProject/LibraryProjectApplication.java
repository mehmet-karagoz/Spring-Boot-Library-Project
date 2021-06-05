package com.mehmetkaragoz.libraryProject;

import java.util.List;

import com.mehmetkaragoz.libraryProject.model.Book;
import com.mehmetkaragoz.libraryProject.repository.BookRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryProjectApplication.class, args);

		
	}

	@Bean
	CommandLineRunner commandLineRunner(BookRepository bookrepo) {
		return args -> {
			Book book1 = new Book("Ataturk", "Ilber Ortayli", 35);

			System.out.println("Adding book1...");
			bookrepo.save(book1);
			System.out.println("Number of book: " + bookrepo.count());


			System.out.println("Select all books...");
			List<Book> listBooks = bookrepo.findAll();

			listBooks.forEach(System.out::println);
		};
	}
}
