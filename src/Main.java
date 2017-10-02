import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class Main {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello world!");
		
		HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 1997), 0);
		server.createContext("/", new IndexHandler());
		server.createContext("/test", new TestHandler());
		server.createContext("/addMessage", new AddMessageHandler());
		server.start();
	}
}
