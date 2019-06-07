package com.zanatciu.backend.reactive;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class ReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveApplication.class, args);
    }

//        @Bean
//    public MongoClient mongoClient(){
//        return MongoClients.create();
//    }
//
//   @Bean
//   public ReactiveMongoDatabaseFactory reactiveMongoDatabaseFactory(){
//        return new SimpleReactiveMongoDatabaseFactory(mongoClient(), "capppeddb");
//   }
//    @Bean
//    public ReactiveMongoTemplate reactiveMongoTemplate(){
//        return new ReactiveMongoTemplate(reactiveMongoDatabaseFactory());
//    }

}
