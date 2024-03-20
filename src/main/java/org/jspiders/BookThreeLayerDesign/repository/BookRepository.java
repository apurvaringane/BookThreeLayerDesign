package org.jspiders.BookThreeLayerDesign.repository;

import org.jspiders.BookThreeLayerDesign.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<Book> bookList=new ArrayList<>();
    private List<Book> resultBookList=new ArrayList<>();
    {
        bookList.add(new Book(1,"Java","ABC","James",2500.36));
        bookList.add(new Book(2,"SQL","ABC","Smith",1000.45));
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void updateBookDetails(int index, Book book) {
        bookList.set(index,book);
    }

    public void deleteBook(Book b1) {
        bookList.remove(b1);
    }

    public List<Book> searchedBook(Book b) {
        resultBookList.add(b);
        return resultBookList;
    }

    public void clearBookSearchHistory() {
        resultBookList.clear();
    }
}
