package co.springcoders;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import co.springcoders.domain.User;
import co.springcoders.security.UserRepository;

@SpringBootApplication
public class SpringSecurityBasicAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityBasicAuthenticationApplication.class, args);
	}
	
	@Component
	static class DataLoader implements CommandLineRunner{
		@Autowired UserRepository userRepo;
		@Autowired BCryptPasswordEncoder encoder;
		@Override
		public void run(String... args) throws Exception {
			ArrayList<String> userRoles = new ArrayList<>();
;			userRoles.add("ADMIN");
			userRepo.save(User.builder().username("amit").password(encoder.encode("admin")).roles(userRoles).build());
			userRepo.save(User.builder().username("shivam").password(encoder.encode("admin")).roles(userRoles).build());
			userRepo.save(User.builder().username("anurag").password(encoder.encode("admin")).roles(userRoles).build());
		}
	}
	
	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
