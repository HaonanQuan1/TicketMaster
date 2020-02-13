package external;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;;
//import com.sun.org.apache.xml.internal.utils.URI;

public class TicketMasterAPI {

	private static final String URL = "http://app.ticketmaster.com/discovery/v2/events.json";

	private static final String DEFAULT_KEYWORD = ""; // no restriction

	private static final String API_KEY = "uDoyUSX9WDPGJYn63emh85AYiLK8uIgG"; // my api_key

	public JSONArray search(double lat, double lon, String keyword) {
		if (keyword == null) {
			keyword = DEFAULT_KEYWORD;
		}
		try {
			keyword = java.net.URLEncoder.encode(keyword, "UTF-8");

		} catch (Exception e) {
			e.printStackTrace();
		}

		String geoHash = GeoHash.encodeGeohash(lat, lon, 8);

		String query = String.format("apikey=%s&geoPoint=%s&keyword=%s&radius=%s  ", API_KEY, geoHash, keyword, 50);

		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(URL + "?" + query).openConnection();
			int responseCode = connection.getResponseCode();

			System.out.println("\nSending 'GET' request to URL:" + URL + "?" + query);
			System.out.println("Response Code:" + responseCode);

			if (responseCode != 200) {
//				
			}

			BufferedReader in = new BufferedReader(new java.io.InputStreamReader(connection.getInputStream()));
			String inputline;
			StringBuilder response = new StringBuilder();

			while ((inputline = in.readLine()) != null) {
				response.append(inputline);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private void queryAPI(double lat, double lon) {
		JSONArray events = search(lat, lon, null);
		try {
			for (int i = 0; i < events.length(); i++) {
				JSONObject event = events.getJSONObject(i);
				System.out.println(event);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
