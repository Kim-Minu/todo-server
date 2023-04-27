package todo.server.domain.user.service

import org.springframework.stereotype.Service
import todo.server.domain.user.domain.UserRepository

@Service
class UserService (
    private val userRepository: UserRepository
){

}