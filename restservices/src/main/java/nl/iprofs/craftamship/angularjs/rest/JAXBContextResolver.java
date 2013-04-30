package nl.iprofs.craftamship.angularjs.rest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;

import nl.iprofs.craftamship.angularjs.model.Book;
import nl.iprofs.craftamship.angularjs.model.Review;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;

@Provider
public class JAXBContextResolver implements ContextResolver<JAXBContext> {
	private final JAXBContext context;
	private final Set<Class<?>> types;
	private Class<?>[] ctypes = { Book.class, Review.class }; // your pojo classes

	public JAXBContextResolver() throws Exception {
		this.types = new HashSet<Class<?>>(Arrays.asList(ctypes));
		this.context = new JSONJAXBContext(JSONConfiguration.natural().build(), ctypes); // json configuration
	}

	@Override
	public JAXBContext getContext(Class<?> objectType) {
		return (types.contains(objectType)) ? context : null;
	}
}