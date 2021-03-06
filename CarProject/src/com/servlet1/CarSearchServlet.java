package com.servlet1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.carsales1.Car;

/**
 * Servlet implementation class CarSearchServlet
 */
@WebServlet("/CarSearchServlet")
public class CarSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.setAttribute("searchByModel", request.getParameter("searchByModel"));
		
		ArrayList<Car> cars = (ArrayList<Car>) session.getAttribute("cars");
		ArrayList<Car> searchResults = new ArrayList<Car>();

		String searchByModel = request.getParameter("searchByModel");
		 		
		for (Car car : cars) {
			if(car.getModel().equalsIgnoreCase(searchByModel)) {
				searchResults.add(car);
			}
		}
		
		
		session.setAttribute("searchResults", searchResults);
		
		RequestDispatcher rs = request.getRequestDispatcher("results.jsp");
		rs.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
