package com.ayushi.todo.Repository;

import com.ayushi.todo.Model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByStatus(String status);
    // CUSTOM QUERY (NOT A STANDARD query)
//    mongo repo provides built in tool for basic tasks like findAll , findById etc
//    but this field status is not a part of it so we have to make a custom query for it
//    that will retrieve data based on the status like pending or success
}
