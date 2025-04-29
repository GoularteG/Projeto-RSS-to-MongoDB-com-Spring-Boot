package br.com.anima.gep;

import br.com.anima.gep.service.RssService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GepApplication {
	public static void main(String[] args) {
		SpringApplication.run(GepApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(RssService rssService) {
		return args -> {
			String rssUrl = "https://g1.globo.com/dynamo/tecnologia/rss2.xml";
			rssService.fetchAndSaveRss(rssUrl);
			System.out.println("RSS processado e salvo no MongoDB!");
		};
	}
}

