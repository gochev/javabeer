package org.gochev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
//		user.setUsername("test");
////		user.setPassword(passwordEncoder.encode("test"));
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
