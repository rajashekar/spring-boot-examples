package com.udacity.course3.exercise10;

import java.util.Optional;

import com.udacity.course3.exercise10.model.Member;
import com.udacity.course3.exercise10.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(MemberRepository memberRepository) {
        return args -> {
            // STEP 1: Define Member and MemberRepository first before changing this class
            Member member = new Member();
            member.setFirstName("Raj");
            member.setLastName("Xyz");
            member.setAge(26);

            // STEP 2: create a Member record
            memberRepository.save(member);

            // STEP 3: save the Member record
            Optional<Member> optional = memberRepository.findByFirstName("Raj");

            // read the Member using memeber last name
            if (optional.isPresent()) {
                System.out.println("Member: " + member);
            }
        };
    }
}