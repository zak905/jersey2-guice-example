package com.gwidgets;

import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.google.inject.Injector;
import com.gwidgets.service.SimpleService;;

public class HK2toGuiceModule extends AbstractBinder {
	
	private Injector guiceInjector;


	public HK2toGuiceModule(Injector guiceInjector) {
		this.guiceInjector = guiceInjector;
	}


	@Override
	protected void configure() {
		bindFactory(new ServiceFactory<SimpleService>(guiceInjector, SimpleService.class)).to(SimpleService.class);
	}
	
	
	private static class ServiceFactory<T> implements Factory<T> {

	    private final Injector guiceInjector;

	    private final Class<T> serviceClass;

	    public ServiceFactory(Injector guiceInjector, Class<T> serviceClass) {

	      this.guiceInjector = guiceInjector;
	      this.serviceClass = serviceClass;
	    }

	    @Override
	    public T provide() {
	      return guiceInjector.getInstance(serviceClass);
	    }

	    @Override
	    public void dispose(T versionResource) {
	    }
	  }
}