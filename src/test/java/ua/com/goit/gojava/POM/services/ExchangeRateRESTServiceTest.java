package ua.com.goit.gojava.POM.services;

import static org.junit.Assert.*;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.junit.Test;

public class ExchangeRateRESTServiceTest {

	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/ProjectOfficeManagement").build();
	}

	@Test
	public void test() {
		
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		
		WebTarget target = client.target(getBaseURI());

		String response = target.path("rest").path("ExchangeRate").request()
				.accept(MediaType.TEXT_PLAIN).get(Response.class).toString();

		String plainAnswer = target.path("rest").path("ExchangeRate").request()
				.accept(MediaType.TEXT_PLAIN).get(String.class);
		String xmlAnswer = target.path("rest").path("ExchangeRate").request()
				.accept(MediaType.TEXT_XML).get(String.class);
		String htmlAnswer = target.path("rest").path("ExchangeRate").request()
				.accept(MediaType.TEXT_HTML).get(String.class);

		System.out.println(response);
		System.out.println(plainAnswer);
		System.out.println(xmlAnswer);
		System.out.println(htmlAnswer);
		
	}

}
