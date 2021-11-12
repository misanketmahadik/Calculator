package Servelets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calcServelet
 */
@WebServlet("/calcServelet")
public class calcServelet extends HttpServlet {
	int result;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public calcServelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	int add(int a,int b)
	{
		return a+b;
	}
	int sub(int a,int b)
	{
		return a-b;
	}
	int multiply(int a,int b)
	{
		return a*b;
	}
	int divide(int a,int b)
	{
		return a/b;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int op1=Integer.parseInt(request.getParameter("op1"));
		int op2=Integer.parseInt(request.getParameter("op2"));

		RequestDispatcher rd= request.getRequestDispatcher("Calculator.jsp");

		System.out.println(request.getParameter("operation"));
		if(request.getParameter("op1").equals(null)||request.getParameter("op2").equals(null))
		{
			request.setAttribute("emptyOP", "Enter the input correctly");
		}
		else
		{


			
			if(request.getParameter("operation").equals("add"))
			{
				this.result=add(op1, op2);
			}
			else if(request.getParameter("operation").equals("sub"))
			{
				this.result=sub(op1, op2);
			}
			else if(request.getParameter("operation").equals("multiply"))
			{
				this.result=multiply(op1, op2);
			}
			else if(request.getParameter("operation").equals("divide"))
			{
				if(request.getParameter("op2").equals("0"))
				{
					request.setAttribute("divide_zero", "Cannot Divide By Zero");
					rd.forward(request, response);
				}
				else
				{
					this.result=divide(op1, op2);
				}
			}
			request.setAttribute("result", result);
			rd.include(request, response);
		}
	}

}
