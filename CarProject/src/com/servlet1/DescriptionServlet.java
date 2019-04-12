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
 * Servlet implementation class DescriptionServlet
 */
@WebServlet("/DescriptionServlet")
public class DescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DescriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		ArrayList<Car> cars = (ArrayList<Car>) session.getAttribute("cars");

		String vinNumber = request.getParameter("vinNumber");
		int vinIdNum = Integer.parseInt(vinNumber);
		
		for (int i = 0; i < cars.size(); i++) {
			if(vinIdNum == cars.get(i).getVinNumber()) {
				session.setAttribute("carInfo", cars.get(i));
			}
		}
		
		RequestDispatcher rs = request.getRequestDispatcher("carDetails.jsp");
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
