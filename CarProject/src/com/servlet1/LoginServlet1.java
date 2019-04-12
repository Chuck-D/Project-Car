package com.servlet1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
 * Servlet implementation class LoginServlet1
 */
@WebServlet("/LoginServlet1")
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String mySaveInventoryPath = "C:/Users/adriandavis/Desktop/carProjectSaves";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * Car(String modelYear, String make, String model, int price, String engineType, int currentMileage,
		int mpg, String transmissionType, boolean isNew)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				//setting up ArrayList to hold starting inventory	
	//	ArrayList<Car> cars = (ArrayList<Car>) session.getAttribute("cars");
	// 	if (cars == null) {
		//	cars = new ArrayList<Car>();}	
		ArrayList<Car> cars = new ArrayList<Car>();
	
		
		Car car1 = new Car("2016", "Ford", "Fusion", 14100, "V6", 42730, 36, "Automatic", false);
		car1.setCarPhoto("Photos/2016 Ford Fusion SE.jpg");
		car1.setVinNumber(8);
		cars.add(car1);
		
		Car car2 = new Car("2017", "Honda", "Civic", 23700, "V6", 9176, 42, "Automatic", false);
		car2.setCarPhoto("Photos/honda2017.jpg");
		car2.setVinNumber(7);
		cars.add(car2);

		Car car3 = new Car("2017", "Ford", "Edge", 18500, "EcoBoost", 43000, 29, "Automatic", false);
		car3.setCarPhoto("Photos/2017-Ford-EdgeSport.jpg");
		car3.setVinNumber(5);
		cars.add(car3);

		Car car4 = new Car("2019", "VW", "Jetta", 22000, "V6", 2, 30, "Manual", true);
		car4.setCarPhoto("Photos/2019Jetta.jpg");
		car4.setVinNumber(287);
		cars.add(car4);

		Car car5 = new Car("2019", "Jaguar", "I-pace", 92000, "Electric", 12, 99, "Automatic", true);
		car5.setCarPhoto("Photos/jaguarIpace.jpeg");
		car5.setVinNumber(868987);
		cars.add(car5);

		Car car6 = new Car("2002", "Chevy", "Corvette", 59900, "V8", 4898, 16, "Manual", false);
		car6.setCarPhoto("Photos/corvette.jpg");
		car6.setVinNumber(2752986);
		cars.add(car6);

		Car car7 = new Car("2019", "Honda", "Civic", 39900, "V6", 12, 25, "Manual", true);
		car7.setCarPhoto("Photos/civic type r.jpeg");
		car7.setVinNumber(898527);
		cars.add(car7);

		Car car8 = new Car("2017", "Chrysler", "300", 22000, "V6", 19000, 22, "Automatic", false);
		car8.setCarPhoto("Photos/300.jpg");
		car8.setVinNumber(89782);
		cars.add(car8);

		Car car9 = new Car("2019", "Lexus", "LS500", 91000, "V6", 13, 21, "Automatic", true);
		car9.setCarPhoto("Photos/ls500.jpeg");
		car9.setVinNumber(8998587);
		cars.add(car9);

		Car car10 = new Car("2019", "Mercedes", "Maybach", 204900, "V6", 8, 15, "Automatic", true);
		car10.setCarPhoto("Photos/maybach 2019.jpeg");			
		car10.setVinNumber(89887);	
		cars.add(car10);	
		
		
		/*each car needs a purchase date set in order to allow bidding on cars purchased
		 * greater than 120 days ago.
		 * 
		 */
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		for(Car car : cars) {
			//these cars will have a purchase date over 120 days
			if(car.getVinNumber()% 2 == 0){
				try {
					car.setPurchaseDate(sdf.parse("11/21/2018"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				try {
					car.setPurchaseDate(sdf.parse("04/01/2019"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		HttpSession session = request.getSession(true);
		session.setAttribute("cars", cars);
		
		ArrayList<CarPurchase> salesHistory = new ArrayList<CarPurchase>();
		session.setAttribute("salesHistory", salesHistory);
		
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");		
				
		//TODO adjust nav bars to only show manager link when manager is logged in.			
		if (loginName.equalsIgnoreCase("manager1") && password.equals("password")) {
			boolean manager = true;
			session.setAttribute("manager", manager);
			RequestDispatcher rs = request.getRequestDispatcher("carManagement.jsp");
			rs.forward(request, response);	
		} else if (loginName.equalsIgnoreCase("customer") && password.equals("password")) {
			boolean manager = false;
			session.setAttribute("manager", manager);
			RequestDispatcher rs = request.getRequestDispatcher("home.jsp");
			rs.forward(request, response);	
		} else {
			RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
			rs.forward(request, response);	}
		
		
		
		
	}

}
