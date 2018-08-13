package controller;

import chapter2.app.Book;
import chapter2.app.BookService;
import chapter3.app.Customer;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Date;
import java.util.Set;

@WebServlet("/main")
public class Main extends HttpServlet {

	@Inject
	BookService bookService;
	@Inject
	Validator validator;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		
		Customer validCustomer = new Customer("John", "Smith", "jsmith@gmail.com");
		Set<ConstraintViolation<Customer>> violations = validator.validate(validCustomer);
		System.out.println(violations.size());
		
		Customer invalidCustomer = new Customer("Джон", "Смит", "DummyEmail");
		violations = validator.validate(invalidCustomer);
		System.out.println(violations.size());
		
		System.out.println(violations.iterator().next().getMessage());
		System.out.println(violations.iterator().next().getInvalidValue());
		System.out.println(violations.iterator().next().getMessageTemplate());
		
//		Book book = bookService.createBook("H2G2", 12.5f, "Интересная книга");
//		System.out.println(book);
		
		request.setAttribute("date", new Date());
		
		try {
			request.getRequestDispatcher("result.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
