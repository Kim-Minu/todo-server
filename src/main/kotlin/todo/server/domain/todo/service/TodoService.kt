package todo.server.domain.todo.service

import org.springframework.stereotype.Service
import todo.server.domain.todo.domain.TodoRepository

@Service
class TodoService (
    private val todoRepository: TodoRepository
) {

}