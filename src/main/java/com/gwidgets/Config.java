package com.gwidgets;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ResourceConfig;

import com.google.inject.Guice;
import com.google.inject.Injector;

@ApplicationPath("/")
public class Config extends ResourceConfig {

	public Config() {
		packages("com.gwidgets");
		Injector injector = Guice.createInjector(new GuiceModule());
		HK2toGuiceModule hk2Module = new HK2toGuiceModule(injector);
		register(hk2Module);
	}
}