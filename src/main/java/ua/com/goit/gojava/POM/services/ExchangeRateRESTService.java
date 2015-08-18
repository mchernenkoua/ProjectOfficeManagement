package ua.com.goit.gojava.POM.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ExchangeRate")
public class ExchangeRateRESTService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextExchngeRate() {
		return "Hello Jersey";
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLExchngeRate() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlExchngeRate() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
				+ "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	}
}
