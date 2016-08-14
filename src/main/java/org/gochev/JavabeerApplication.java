package org.gochev;

import org.gochev.model.User;
import org.gochev.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJpaAuditing
@EnableGlobalMethodSecurity
@SpringBootApplication(exclude={org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration.class} )
public class JavabeerApplication {

	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JavabeerApplication.class, args);
	
//		PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
		UserRepository userRepo = context.getBean(UserRepository.class);
		User user = new User();
		user.setUsername("gochev@gmail.com");
//		user.setPassword(passwordEncoder.encode("test"));
		user.setPassword("$2a$10$qu5o.SuF8BBb5rG8/3A5je8qnhikFuS1ZCxhYCVn33MTbQ4AI/5wi");
		userRepo.save(user);
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
