package com.udacity.course3.exercise10.repository;

import java.util.Optional;

import com.udacity.course3.exercise10.model.Member;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends MongoRepository<Member, String> {
    Optional<Member> findByFirstName(String firstName);
}
