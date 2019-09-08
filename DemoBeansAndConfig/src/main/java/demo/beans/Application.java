package demo.beans;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
		MyBean bean = ctx.getBean(MyBean.class);
        System.out.println(bean);     
        
        DemoCalc calc = ctx.getBean(DemoCalc.class);
        System.out.printf("%d + %d = %d \n",2,5,calc.add(2, 5));
        System.out.printf("%d - %d = %d ",20,5,calc.sub(20, 5));
        
        DataBean databean = ctx.getBean(DataBean.class);
        List<String> categories = databean.getCategories();
        for(String category : categories) {
        	System.out.println(category);
        }
	}
}
