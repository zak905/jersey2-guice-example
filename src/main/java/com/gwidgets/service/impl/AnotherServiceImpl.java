package com.gwidgets.service.impl;

import com.gwidgets.service.AnotherService;

public class AnotherServiceImpl implements AnotherService {
	@Override
	public String provideName() {
		return "foo";
	}
}