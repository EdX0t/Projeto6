package pt.aor.paj.rest;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import pt.aor.paj.resources.MusicResource;
import pt.aor.paj.resources.PlaylistResource;
import pt.aor.paj.resources.UserResource;

@ApplicationPath("/rest")
public class WsApplication extends Application {
	

	@Override
	public Set<Class<?>> getClasses() {
	    Set<Class<?>> resources = new java.util.HashSet<>();
	    addRestResourceClasses(resources);
	    return resources;
	}
	
	/*
	 * Responsible for adding our resource classes
	 */
	private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(UserResource.class);
		resources.add(PlaylistResource.class);
		resources.add(MusicResource.class);
	}
	}
