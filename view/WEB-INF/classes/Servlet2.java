import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Set;


public class Servlet2 extends HttpServlet 
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		try
		{
		DataAccess d1 = new DataAccess();
		System.out.println(d1);
		ArrayList<Order> l1 = d1.getOrderDetails();
		Iterator<Order> i1 = l1.iterator();
		
		d1.closeCon();

		PrintWriter out = res.getWriter();
		System.out.println(l1);

		

		out.println("<html><body><form><h1> Here you get details of Order </h1><br>");
		out.println("<style> table { width: 100%;border-collapse: collapse;} th, td { border: 1px solid black; padding: 8px;text-align: left;}th { background-color: #f2f2f2; }</style>");
		out.println("<table><tr><th>ORDER_ID</th><th>ORDER_DATE</th><th>SUPPLIER</th><th>ORDER_COST</th><th>ORDER_LINES</th><th>STATUS</th>");
		//System.out.println("hello");
		while(i1.hasNext())
		{
			
			Order o1 = i1.next();

			int orderid = o1.orderid;
			String orderdate = o1.orderdate;
			String supplier = o1.supplier;
			int ordercost = o1.ordercost;
			int orderlines = o1.orderlines;
			boolean status = o1.status;

			String s1 = null;

			if (status == true)
			{
				s1 = "order successfull";
			}
			else
			{
				s1 = "order on process";
			}

			
			out.println("<tr><td>"+orderid+"</td><td>"+orderdate+"</td><td>"+supplier+"</td><td>"+ordercost+"</td><td>"+orderlines+"</td><td>"+s1+"</td>");

		}
		out.println("</table><br>");
		out.println("<a href = http://localhost:8090/view/form1.html> @home page </a>");
		out.println("</form></body></html>");

		}
			
	
		catch(Exception e1)
		{
			System.out.println(e1);
		}

	}
}
