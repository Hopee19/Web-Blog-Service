package com.codepresso.codepressoblog;

import com.codepresso.codepressoblog.vo.Post;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CodepressoBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodepressoBlogApplication.class, args);
	}
	@Bean
	public List<Post> postList(){
		return new ArrayList<>();
	}

}
