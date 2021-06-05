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
			Book book2 = new Book("Mustafa", "Ilber Ortayli", 30);
			Book book3 = new Book("Kemal", "Ilber Ortayli", 25);
			Book book4 = new Book("Pasa", "Ilber Ortayli", 15);
			Book book5 = new Book("Mustafa", "George", 50);

			//System.out.println("Adding book1...");
			//bookrepo.save(book1);
			bookrepo.saveAll(List.of(book1, book2, book3, book4, book5));
			System.out.println("Number of book: " + bookrepo.count());

			bookrepo.updateBookTitleById(5, "Delikanli");
			
			System.out.println("Select all books...");
			List<Book> listBooks = bookrepo.findAll();
			listBooks.forEach(System.out::println);

			bookrepo.findById(2L).ifPresentOrElse(System.out::println, 
			() -> System.out.println("Can not find any book with 2 id"));

			bookrepo.findBookByTitle("Mustafa").forEach(System.out::println);

			

		};
	}
}
