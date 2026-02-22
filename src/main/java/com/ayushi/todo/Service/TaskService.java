package com.ayushi.todo.Service;

import com.ayushi.todo.Model.Task;
import com.ayushi.todo.Repository.TaskRepository;
import com.ayushi.todo.exception.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;




import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

//    save task
    public Task createTask(Task t){
//        if(t.getStatus()== null) {
//            t.setStatus("Pending");
//        }
        System.out.println("Connected DB: " + mongoTemplate.getDb().getName());

        return taskRepository.save(t);
    }

//    get all tasks
    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

//    GET BY ID
    public Task getTaskById(String id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id :"+ id));
    }

//    update
    public Task updateTask(String id , Task updatedtask){
        Task existingtask = getTaskById(id);

        existingtask.setTitle(updatedtask.getTitle());
        existingtask.setDescription(updatedtask.getDescription());
        existingtask.setStatus(updatedtask.getStatus());

        return taskRepository.save(existingtask);
    }

//    DELETE
    public String deleteTaskById(String id){
        Task existing = getTaskById(id);
        taskRepository.delete(existing);
        return "deleted";
    }

    public List<Task> getTaskByStatus(String status){
        return taskRepository.findByStatus(status);
    }

    public Page<Task> getTaskWithPagination(Pageable pageable){
        return taskRepository.findAll((pageable));
    }
    @Autowired
    private org.springframework.data.mongodb.core.MongoTemplate mongoTemplate;
    public void printDbName() {
        System.out.println("Connected DB: " + mongoTemplate.getDb().getName());
    }



}
