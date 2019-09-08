package demo.beans;

import org.springframework.stereotype.Component;

@Component
public class DemoCalc {
	public int add(int first, int second) {
		return first + second;
	}
	public int sub(int first, int second) {
		return first - second;
	}
}
