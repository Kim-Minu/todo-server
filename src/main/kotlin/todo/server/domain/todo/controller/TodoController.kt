package todo.server.domain.todo.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import todo.server.domain.todo.service.TodoService

@RestController
@RequestMapping("/api/v1/todo")
class TodoController (
    private val todoService: TodoService
) {

    @GetMapping("/list")
    fun list(){

    }

    @PostMapping("/")
    fun create() {

    }

    @DeleteMapping("/")
    fun delete() {

    }

    @PatchMapping("/")
    fun update() {

    }

}