package ac;

import java.net.*;
import java.io.*;

public class Util {
	public static String getHost(String url) throws Exception {
System.out.println("UTIL GETHOST: " + url.trim());
		URL aURL = new URL(url);
		return aURL.getHost();
/**
		URL aURL = new URL("http://example.com:80/docs/books/tutorial" + "/index.html?name=networking#DOWNLOADING");

		System.out.println("protocol = " + aURL.getProtocol()); //http
		System.out.println("authority = " + aURL.getAuthority()); //example.com:80
		System.out.println("host = " + aURL.getHost()); //example.com
		System.out.println("port = " + aURL.getPort()); //80
		System.out.println("path = " + aURL.getPath()); //  /docs/books/tutorial/index.html
		System.out.println("query = " + aURL.getQuery()); //name=networking
		System.out.println("filename = " + aURL.getFile()); ///docs/books/tutorial/index.html?name=networking
		System.out.println("ref = " + aURL.getRef()); //DOWNLOADING
*/
	}

	public static int getPort(String url) throws Exception {
		URL aURL = new URL(url.trim());
		return aURL.getPort();

	}

	public static String getProtocol(String url) throws Exception {
		URL aURL = new URL(url.trim());
		return aURL.getProtocol();
	}
}
