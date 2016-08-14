package org.gochev;

import java.util.Date;

import org.gochev.model.Event;
import org.gochev.model.User;
import org.gochev.repository.EventRepository;
import org.gochev.repository.UserRepository;
import org.joda.time.DateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

@EnableTransactionManagement
@EnableJpaAuditing
@EnableGlobalMethodSecurity
@SpringBootApplication(exclude={org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration.class} )
public class JavabeerApplication {

	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JavabeerApplication.class, args);
	
//		PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
//		UserRepository userRepo = context.getBean(UserRepository.class);
//		User user = new User();
//		user.setUsername("gochev@gmail.com");
//		user.setPassword(passwordEncoder.encode("test"));
//		userRepo.save(user);
//		
//		EventRepository eventRepository = context.getBean(EventRepository.class);
//		
//		for (int i = 0; i < 100; i++) {
//			Event event = new Event();
//			event.setTitle("test");
//			event.setDescription("test");
//			event.setLocation("sofia");
//			event.setStartTime(new Date());
//			eventRepository.save(event);
//		}
	}
	
//	@Bean
//    public SpringDataDialect springDataDialect() {
//        return new SpringDataDialect();
//    }
}
