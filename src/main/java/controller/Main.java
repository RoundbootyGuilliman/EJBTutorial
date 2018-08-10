package controller;

import app.Book;
import app.BookService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@WebServlet("/main")
public class Main extends HttpServlet {

	@Inject
	BookService bookService;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		
		Book book = bookService.createBook("H2G2", 12.5f, "Интересная книга");
		System.out.println(book);
		
		request.setAttribute("date", new Date());
		
		try {
			request.getRequestDispatcher("result.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
