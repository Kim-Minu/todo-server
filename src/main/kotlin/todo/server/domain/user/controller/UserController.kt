package todo.server.domain.user.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import todo.server.domain.user.service.UserService

@RestController
@RequestMapping("/api/user")
class UserController (
    private val userService: UserService
) {

    @GetMapping("/v1/{userId}")
    fun find(@PathVariable userId: String){

    }

}