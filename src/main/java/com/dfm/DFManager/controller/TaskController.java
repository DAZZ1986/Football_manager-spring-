package com.dfm.DFManager.controller;

import com.dfm.DFManager.model.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {


    @GetMapping("/flow")
    public ResponseEntity main() {
        return ResponseEntity.ok("bingo");
    }

    @GetMapping("/task")    //тут ответ от бэка будет в виде json, тк наверное мы возвращаем объект-модель Task.
    public ResponseEntity task() {
        return ResponseEntity.ok(new Task(17l, "Купить хлеб"));
    }


    /*
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello, Spring REST";
    }

    @GetMapping("/{id}", produces = "application/json")
    public Book getBook(@PathVariable int id) {
        return findBookById(id);
    }

    @GetMapping("/rest/employee/get/{id}")
    public Employee getEmployeeByID(@PathVariable("id") int id) {
        return repository.retrieve(id);
    }
*/
}

