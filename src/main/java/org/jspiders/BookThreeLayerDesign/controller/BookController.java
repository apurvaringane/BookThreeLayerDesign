package org.jspiders.BookThreeLayerDesign.controller;

import jakarta.validation.Valid;
import org.jspiders.BookThreeLayerDesign.domain.Book;
import org.jspiders.BookThreeLayerDesign.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    private BookService service=new BookService();
    @GetMapping("/")
    public String getWelcomePage(Model model){
        model.addAttribute("book",new Book());
        model.addAttribute("books",service.getBookList());
        return "booklist";
    }

    @GetMapping("/getbookform")
    public String getBookForm(Model model){
        model.addAttribute("book",new Book());
        return "addbook";
    }

    @PostMapping("/savebook")
    public String addBook(@Valid Book book, BindingResult result){
        if(result.hasErrors()) return "addbook";
        service.addBook(book);
        return "redirect:/";
    }

    @GetMapping("/updatebookdetails/{id}")
    public String getUpdateForm(@PathVariable(name="id") int id, Model model){
        //fetch specific task from existing task list
        model.addAttribute("book",service.getBook(id));
        return "updatebook";
    }

    @PostMapping("/updatebook")
    public String updateBookDetails(Book book){
        service.updateBookDetails(book);
        return "redirect:/";
    }

    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable(name="id") int id, Model model){
        //fetch specific task from existing task list
        service.deleteBook(id);
        return "redirect:/";
    }

    @PostMapping("/searchbook")
    public String searchBook(Book book, Model model){
        model.addAttribute("books",service.searchBook(book));
        return "bookList";
    }
}
