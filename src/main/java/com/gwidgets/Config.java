package com.gwidgets;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;


import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

@ApplicationPath("/")
public class Config extends ResourceConfig {

	@Inject
	public Config(ServiceLocator serviceLocator) {
		packages("com.gwidgets.resource");
		Injector injector = Guice.createInjector(new GuiceModule());
		initGuiceIntoHK2Bridge(serviceLocator, injector);
	}


	private void initGuiceIntoHK2Bridge(ServiceLocator serviceLocator, Injector injector) {
		GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
		GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
		guiceBridge.bridgeGuiceInjector(injector);
	}
}