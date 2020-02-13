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
 * Servlet implementation class Recommenditem
 */
@WebServlet("/recommendation")
public class Recommenditem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recommenditem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//PrintWriter out=response.getWriter();
		
		//esponse.setContentType("application/json");
		
		JSONArray array=new JSONArray();
		JSONObject o1=new JSONObject();
		JSONObject o2=new JSONObject();
		try {
			o1.put("name","abcd");
			o1.put("address", "san francisco");
			o1.put("time","01/01/2017");
			o2.put("name","123");
			o2.put("address", "p");
			o2.put("time", "01/02/2017");
			array.put(o1);
			array.put(o2);
		}catch (JSONException e) {
			e.printStackTrace();
		}
		RpcHelper.writeJSONArray(response,array);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
