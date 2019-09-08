package demo.webmvc.additionaltechniques;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class SafihaDemoImplementation implements MyService{

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Hello from safiha bean";
	}

	@Override
	public Date getTimestamp() {
		// TODO Auto-generated method stub
		return new Date();
	}
	
}
