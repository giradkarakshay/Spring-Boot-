package com.yash.webformapplication.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author akshay.giradkar
 *
 */
public class SpringAnnotationWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	public SpringAnnotationWebInitializer() {
		System.out.println("SpringAnnotationWebInitializer called...");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] { SpringAnnotationWebInitializer.class };
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] { "/" };
	}

}