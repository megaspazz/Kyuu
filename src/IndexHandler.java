import java.io.IOException;
import java.io.PrintWriter;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class IndexHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
		httpExchange.sendResponseHeaders(200, 0);
		
		PrintWriter writer = new PrintWriter(httpExchange.getResponseBody());
		writer.print("<html><head><title>Kyuu~</title></head><body><p>Welcome to Kyuu~</p></body></html>");
		writer.flush();
		writer.close();
	}
}
