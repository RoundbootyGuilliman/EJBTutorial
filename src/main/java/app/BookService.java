package app;

import generator.annotation.Loggable;
import generator.annotation.ThirteenDigits;
import generator.NumberGenerator;

import javax.inject.Inject;

@Loggable
public class BookService {
	
	@Inject @ThirteenDigits
	private NumberGenerator numberGenerator;
	public Book createBook(String title, Float price, String description) {
		Book book = new Book(title, price, description);
		book.setNumber(numberGenerator.generateNumber());
		return book;
	}
}
