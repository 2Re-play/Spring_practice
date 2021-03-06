package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Order;
import service.OrderService;

/**
 * Servlet implementation class Order
 */
@WebServlet("/order")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String itemNumber = request.getParameter("itemNumber");
		String description = request.getParameter("description");
		String priceEach = request.getParameter("priceEach");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String middleInitial = request.getParameter("middleInitial");
		String shippingAddress = request.getParameter("shippingAddress");
		String creditCard = request.getParameter("creditCard");
		String creditCardNumber = request.getParameter("creditCardNumber");
		String repeatCreditCardNumber = request.getParameter("repeatCreditCardNumber");

		OrderService orderService = new OrderService();

		Order order = new Order(itemNumber, description, priceEach, firstName, lastName, middleInitial, shippingAddress, creditCard, creditCardNumber);
		
		request.setAttribute("order", order);

		boolean cardNumberCheck = orderService.checkCreditCardNumebr(creditCardNumber, repeatCreditCardNumber);

		String page;

		if (cardNumberCheck)
			page = "/view/order.jsp";
		else
			page = "/view/form.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}
