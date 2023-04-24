package todo.server.domain.user.service

import org.springframework.stereotype.Service
import todo.server.domain.user.deomain.UserRepository

@Service
class UserService (
    private val userRepository: UserRepository
){

}