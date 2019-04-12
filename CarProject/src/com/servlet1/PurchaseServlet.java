package com.servlet1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.carsales1.Car;
import com.carsales1.CarPurchase;

/**
 * Servlet implementation class PurchaseServlet
 */
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);		
		
		boolean bidCriteriaMet = false;
		if (request.getParameter("bid") != null && !request.getParameter("bid").equals("")) {
			
			double bid = Double.parseDouble(request.getParameter("bid"));			
			Car carToPurchase = (Car) session.getAttribute("carToPurchase");
			double minAcceptableBid = carToPurchase.getPrice() - carToPurchase.getPrice() * .1;
			
			if (bid >= minAcceptableBid) {
				bidCriteriaMet = true;
			}
		}
				if (request.getParameter("bid") == null || request.getParameter("bid").equals("") || bidCriteriaMet == true){
										
					ArrayList<Car> cars = (ArrayList<Car>) session.getAttribute("cars");
					Car carBought = (Car) session.getAttribute("carToPurchase");
					
					
					for (Car car : cars) {
						if (car == carBought) {
							cars.remove(car);
							session.setAttribute("cars", cars);
							break;
						}
					}	
					
					// Purchase successful.  get details for a sales history report.
					String firstName = request.getParameter("firstName");
					String lastName = request.getParameter("lastName");			
					Date dateCustomerPurchased = new Date();
					CarPurchase newSalesHistoryItem = new CarPurchase(firstName, lastName, dateCustomerPurchased, carBought);
					
					// Add the transaction to the sales history report
					ArrayList<CarPurchase> salesHistory = (ArrayList<CarPurchase>) session.getAttribute("salesHistory");
					salesHistory.add(0, newSalesHistoryItem);					
					session.setAttribute("firstName", firstName);
					session.setAttribute("lastName", lastName);
					session.setAttribute("salesHistory",salesHistory);
					
				
					session.setAttribute("lowBid", false);					
					
					RequestDispatcher rs = request.getRequestDispatcher("purchaseConfirmation.jsp");
					rs.forward(request, response);

				
				} else if (request.getParameter("bid") != null) {
					
					
					session.setAttribute("lowBid", true);
					RequestDispatcher rs = request.getRequestDispatcher("purchase.jsp");
					rs.forward(request, response);
					
				} 
			} 
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
