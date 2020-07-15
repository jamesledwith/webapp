package james.springframework.webapp.bootstrap;

import james.springframework.webapp.domain.Author;
import james.springframework.webapp.domain.Book;
import james.springframework.webapp.repositories.AuthorRepository;
import james.springframework.webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author jimmy = new Author("Jimmy", "Smith");
        Book rd = new Book("Repo Depo", "22424");
        jimmy.getBooks().add(rd);
        rd.getAuthors().add(jimmy);

        authorRepository.save(jimmy);
        bookRepository.save(rd);

        Author matt = new Author("Matthew", "Walker");
        Book wws = new Book("Why We Sleep", "1432");
        matt.getBooks().add(wws);
        wws.getAuthors().add(matt);

        authorRepository.save(matt);
        bookRepository.save(wws);

        System.out.println("Started in bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());

    }
}
