package com.codecool.recommendation;

import com.codecool.recommendation.entity.Recommendation;
import com.codecool.recommendation.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class VideoRecomendationServiceApplication {

    @Autowired
    RecommendationRepository recommendationRepository;

    public static void main(String[] args) {
        SpringApplication.run(VideoRecomendationServiceApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            Recommendation recommendation1 = Recommendation.builder()
                    .comment("This is a great video")
                    .videoId(1L)
                    .rating(5)
                    .build();
            Recommendation recommendation2 = Recommendation.builder()
                    .comment("Very nice")
                    .videoId(1L)
                    .rating(4)
                    .build();
            Recommendation recommendation3 = Recommendation.builder()
                    .comment("5/7")
                    .videoId(3L)
                    .rating(5)
                    .build();

            recommendationRepository.saveAll(Arrays.asList(recommendation1, recommendation2, recommendation3));
        };
    }

}
