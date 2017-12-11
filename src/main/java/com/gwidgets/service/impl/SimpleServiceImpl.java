package com.gwidgets.service.impl;

import com.gwidgets.service.AnotherService;
import com.gwidgets.service.SimpleService;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class SimpleServiceImpl implements SimpleService {	
	@Inject
	AnotherService anotherService;

	@Override
	public String getMessage() {
		return "Howdy" + " " + anotherService.provideName();
	}
}