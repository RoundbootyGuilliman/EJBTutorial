package chapter2.app;

import chapter2.generator.NumberGenerator;
import chapter2.generator.annotation.Loggable;
import chapter2.generator.annotation.ThirteenDigits;

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
