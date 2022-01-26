package com.galvanize.tmo.paspringstarter;

import com.galvanize.tmo.paspringstarter.bean.Book;
import com.galvanize.tmo.paspringstarter.service.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;


@RestController
public class LibraryController {
    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
    }

    @GetMapping("/health")
    public void health() {

    }

    @PostMapping(value = "/api/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        LOG.info("Request: {}", book);
        return ResponseEntity.
                status(HttpStatus.CREATED)
                .body(libraryService.saveBook(book));
    }

    @GetMapping(value = "/api/books")
    public ResponseEntity<HashMap> getBooks(){
        LOG.info("Getting books in alphabetical order by title");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(libraryService.getBooks());
    }

    @DeleteMapping(value = "/api/books")
    public ResponseEntity deleteBooks(){
        LOG.info("Deleting books from library");
        libraryService.deleteBooks();
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("");
    }
}
