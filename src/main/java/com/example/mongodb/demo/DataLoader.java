package com.example.mongodb.demo;

import com.example.mongodb.demo.entity.*;
import com.example.mongodb.demo.repository.AuthorRepository;
import com.example.mongodb.demo.repository.BookRepository;
import com.example.mongodb.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        System.err.println("\n\n\nLOADING DATA(DataLoader.java)....");
        Book book = Book.builder().title("Epic Story").description("Epic story for the generations to go beyond NEXT LEVEL").build();
        Publisher publisher = Publisher.builder().name("Ekta Publishers").address("Kathmandu, Nepal").build();
        Author author = Author.builder().firstName("Thakur Baldev").lastName("Singh").build();
        Author curator = Author.builder().firstName("Jai").lastName("Dev").build();
        Reader reader = Reader.builder().firstName("Basanti").lastName("Unknown").build();

        Comment comment = Comment.builder().title("Next Level").description("Epic!").build();
        List<Comment> subComments = new ArrayList<>();
        subComments.add(Comment.builder().title("Awesome").description("You are awesome.").build());
        comment.setThreadComments(subComments);

        Comment parentComment = Comment.builder().title("I am parent").description("There will be sub comments.").build();
        comment.setParent(parentComment);
        book.setPublisher(publisher);

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        book.setComments(comments);

        Set<Reader> readers = new HashSet<>();
        readers.add(reader);
        book.setReaders(readers);

        Set<Author> authors = new HashSet<>();
        authors.add(author);
        authors.add(curator);
        book.setAuthors(authors);

        bookRepository.save(book);


        System.out.println("bookrepo : " + (bookRepository instanceof BookRepository));
        System.out.println("bookrepo parent : " + (bookRepository instanceof MongoRepository));
    }
}
