package configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sahinler.holding.socialMediaApp.business.concretes.PostManager;

@Configuration
public class PostConfig {
	
	@Bean
	public PostManager postBean() {
		return new PostManager();
	}
	
	@Bean
	public ModelMapper modelMapperBean() {
		return new ModelMapper();
	}

}
