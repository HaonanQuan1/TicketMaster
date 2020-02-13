package rpc;	

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RpcHelper {
	public static void writeJSONObject(HttpServletResponse response,JSONObject obj ) {
	try {
		response.setContentType("application/json");
		response.addHeader("Access-control", "*");
		PrintWriter out=response.getWriter();
		out.print(obj);
		out.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
	public static void writeJSONArray(HttpServletResponse response,JSONArray array) {
		try {
			response.setContentType("application/json");
			response.addHeader("Access-control","*");
			PrintWriter out=response.getWriter();
			out.print(array);
			out.close();
		}	catch(Exception e) {
			e.printStackTrace();
		}
	}
}
