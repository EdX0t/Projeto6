package pt.aor.paj.rest;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import pt.aor.paj.resources.UtilizadorResource;

@ApplicationPath("/rest")
public class WsApplication extends Application {
	

	@Override
	public Set<Class<?>> getClasses() {
	    Set<Class<?>> resources = new java.util.HashSet<>();
	    addRestResourceClasses(resources);
	    return resources;
	}
	
	/*
	 * Responsible for adding our "service" classes
	 */
	private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(UtilizadorResource.class);
	}
	}
