package com.udacity.course3.exercise10;

import static org.junit.Assert.assertThat;

import java.util.List;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataMongoTest
public class ApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test(@Autowired MongoTemplate mongoTemplate) {
        DBObject objectToSave = BasicDBObjectBuilder.start().add("key", "value").get();

        mongoTemplate.save(objectToSave, "collection");

        List<DBObject> list = mongoTemplate.findAll(DBObject.class, "collection");

        // assertThat(mongoTemplate.findAll(DBObject.class,
        // "collection")).extracting("key").containsOnly("value");
    }

}
