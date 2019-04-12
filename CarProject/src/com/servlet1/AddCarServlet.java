package com.servlet1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.carsales1.Car;

/**
 * Servlet implementation class AddCarServlet
 */
@WebServlet("/AddCarServlet")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		 
		String modelYear = request.getParameter("modelYear");
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		int price = Integer.parseInt(request.getParameter("price"));
		int currentMileage = Integer.parseInt(request.getParameter("currentMileage"));
		int mpg = Integer.parseInt(request.getParameter("mpg"));
		String engineType = request.getParameter("engineType");
		String transmissionType = request.getParameter("transmissionType");
		boolean isUsed = Boolean.parseBoolean(request.getParameter("isUsed"));
		String photo = request.getParameter("carPhoto");
	//	int vinNumber = Integer.parseInt(request.getParameter("vinNumber"));
		System.out.println("here");
		
		ArrayList<Car> cars = (ArrayList<Car>) session.getAttribute("cars");
		
		Car addCar = new Car(modelYear, make, model, price, engineType, currentMileage, mpg, transmissionType, isUsed);
		addCar.setCarPhoto(photo);
		addCar.setVinNumber(addCar.generateVin());
		System.out.println("this is the vin " + addCar.getVinNumber());
		
		addCar.saveToFile();
		
		cars.add(addCar);
		
		
		RequestDispatcher rs = request.getRequestDispatcher("carManagement.jsp");
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
