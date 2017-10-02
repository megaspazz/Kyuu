import java.io.IOException;
import java.io.PrintWriter;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class TestHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
		httpExchange.sendResponseHeaders(200, 0);
		
		PrintWriter writer = new PrintWriter(httpExchange.getResponseBody());
		writer.print("Hello world!");
		writer.flush();
		writer.close();
	}
}
