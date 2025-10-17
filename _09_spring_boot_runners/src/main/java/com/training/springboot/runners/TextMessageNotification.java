package com.training.springboot.runners;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(2)
@Component
public class TextMessageNotification implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
 	   List<String> values=args.getNonOptionArgs();
		   for(String value:values) {
			   System.out.println(value);
		   }
		
		System.out.println("Sending Text Message to Management");
     System.out.println("");
	}

}
