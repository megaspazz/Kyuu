import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
/**
 * 
 * @author yiboz
 * Print info describing the JSON of an addMessage operation 
 * Yo, how are we integrating this with the memory queue and getMessage? 
 */
public class AddMessageHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
		httpExchange.sendResponseHeaders(200, 0);
		
		PrintWriter writer = new PrintWriter(httpExchange.getResponseBody());
		String query = httpExchange.getRequestURI().getQuery(); 
		Map<String, String> queryParams = HttpUtils.queryToMap(query);
		/**
		 * Params: 
		 * msg: the message to add
		 * qid: the id of the queue to add to
		 * uid: the user adding the message
		 */
		
		writer.println("Message: " + queryParams.get("msg"));
		writer.println("QID: " + queryParams.get("qid"));
		writer.println("UID: " + queryParams.get("uid"));
		writer.flush();
		writer.close();
	}
	
}
