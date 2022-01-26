package com.galvanize.tmo.paspringstarter.service;

import com.galvanize.tmo.paspringstarter.bean.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface LibraryService {
    List<Book> books = new ArrayList<>();

    Book saveBook(Book book);

    HashMap<String, List<Book>> getBooks();

    void deleteBooks();
}
