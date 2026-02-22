package com.ayushi.todo.Controller;

import com.ayushi.todo.Service.TaskService;
import com.ayushi.todo.Model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;


    @PostMapping
    public Task createTasks(@RequestBody Task t){
        return taskService.createTask(t);
    }

    @GetMapping
    public List<Task> getallTasks(){
        return taskService.getAllTask();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable String id){
        return taskService.getTaskById(id);
    }

    //update
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable String id, @RequestBody Task task){
        return taskService.updateTask(id,task);
    }

//    delete by id
    @DeleteMapping("{id}")
    public String deleteById(@PathVariable String id){
        return taskService.deleteTaskById(id);
    }
//    get by status
    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable String status){
        return taskService.getTaskByStatus(status);
    }
    @GetMapping("/page")
    public Page<Task> getTaskWithPagination(Pageable pageable){
        return taskService.getTaskWithPagination(pageable);
    }


}
