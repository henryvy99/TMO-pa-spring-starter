package com.galvanize.tmo.paspringstarter.service.impl;

import com.galvanize.tmo.paspringstarter.bean.Book;
import com.galvanize.tmo.paspringstarter.service.LibraryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {


    @Override
    public Book saveBook(Book book) {
        int id = books.size()+1;
        book.setId(id);
        books.add(book);

        return book;
    }

    @Override
    public HashMap<String, List<Book>> getBooks() {
        List<Book> sortBooksByTitle = new ArrayList<>(books);
        sortBooksByTitle.sort(Comparator.comparing(Book::getTitle));
        HashMap<String, List<Book>> map = new HashMap<>();
        map.put("books", sortBooksByTitle);
        return map;
    }

    @Override
    public void deleteBooks() {
        books.clear();
    }
}
