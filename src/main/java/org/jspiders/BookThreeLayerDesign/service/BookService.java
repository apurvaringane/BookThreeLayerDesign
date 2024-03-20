package org.jspiders.BookThreeLayerDesign.service;

import org.jspiders.BookThreeLayerDesign.domain.Book;
import org.jspiders.BookThreeLayerDesign.repository.BookRepository;

import java.util.List;

public class BookService {
    private BookRepository rep=new BookRepository();

    public List<Book> getBookList() {
        return rep.getBookList();
    }

    public void addBook(Book book) {
        rep.addBook(book);
    }

    public Book getBook(int id) {
        Book b1=null;
        for(Book b:rep.getBookList()){
            if (b.getBookId()==id){
                b1=b;
            }
        }
        return b1;
    }

    public void updateBookDetails(Book book) {
        int index=0;
        int id=book.getBookId();
        for(int a=0; a<rep.getBookList().size(); a++){
            Book b=rep.getBookList().get(a);
            if (b.getBookId()==id){
                index=a;
            }
        }

        rep.updateBookDetails(index,book);
    }

    public void deleteBook(int id) {
        Book b1=null;
        for(Book b: rep.getBookList()){
            if (b.getBookId()==id){
                b1=b;
            }
        }
        //remove it from repository
        rep.deleteBook(b1);
    }

    public List<Book> searchBook(Book book) {
        rep.clearBookSearchHistory();
        List<Book> resultBookList=null;
        String name=book.getBookName().toUpperCase();
        for(Book b:rep.getBookList()){
            if (b.getBookName().toUpperCase().startsWith(name)){
                resultBookList=rep.searchedBook(b);
            }
        }
        return resultBookList;
    }
}
