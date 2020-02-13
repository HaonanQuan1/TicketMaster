package rpc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class Searchitem
 */
@WebServlet("/search")
public class Searchitem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Searchitem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		PrintWriter out=response.getWriter();
//		
//		if(request.getParameter("username")!=null) {
//			String username=request.getParameter("username");
//			out.print("hello "+username);
//		}
//		if(request.getParameter("password")!=null) {
//			String password=request.getParameter("password");
//			out.print("fuck "+password);
//		}
//		out.close();
//		response.setContentType("text/html");
//		PrintWriter out=response.getWriter();
//		out.println("<html><body>");
//		out.println("<h1>This is a Page</h1>");
//		out.println("</body></html>");
//		out.close();
		response.setContentType("application/json");
		PrintWriter out=response.getWriter();
		
		//String username="";
		JSONArray array=new JSONArray();
//		if(request.getParameter("username")!=null) {
//			username=request.getParameter("username");
//		}
//		JSONObject obj=new JSONObject();
		try {
			array.put(new JSONObject().put("username", "jack"));
			array.put(new JSONObject().put("username","1234"));
		}catch(JSONException e) {
			e.printStackTrace();
		}
		//out.print(obj);
		RpcHelper.writeJSONArray(response, array);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
