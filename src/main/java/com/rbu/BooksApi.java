package com.rbu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BooksApi {

	List<Book> booklist=new ArrayList<>();
	public BooksApi() {
		Book book1=new Book(1,"Java","Naveen");
		Book book2=new Book(2,"spring","jhonroadson");
		Book book3=new Book(3,"Docker","DH");
		booklist.add(book1);
		booklist.add(book2);
		booklist.add(book3);		
		
	}
	
	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks(){
		return booklist;
	}
	
	
	
	
	
}
