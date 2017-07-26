package hu.sjuhasz.jsftraining.helloworld.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class DemoBean {

	private final String name = "Sandor Juhasz";

	public String getName() {
		return name;
	}
	
}
