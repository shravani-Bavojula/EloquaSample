import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
@WebServlet("/Demo")

public class Demo extends GenericServlet
{

	public void service(ServletRequest req,ServletResponse resp) throws ServletException,IOException
	{
		Date date=new Date();
		PrintWriter printWriter=resp.getWriter();
		printWriter.println(date);
	}
}
