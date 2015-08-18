package ua.com.goit.gojava.POM.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import ua.com.goit.gojava.POM.dataModel.common.ExchangeRate;

@Path("/ExchangeRate")
@Service
@Configurable
public class ExchangeRateRESTService {

	@Autowired
	ExchangeRateService exchangeRateService;
	
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
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<ExchangeRate> getExchangeRates() {
		try {
			return exchangeRateService.retrieveAll();
		} catch (POMServicesException e) {
			return new ArrayList<ExchangeRate>();
		}
	}
}
