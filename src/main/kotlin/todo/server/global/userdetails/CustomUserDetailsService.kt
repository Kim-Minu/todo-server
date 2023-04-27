package todo.server.global.userdetails

import todo.server.domain.user.domain.UserRepository
import todo.server.domain.user.exception.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(private val userRepository: UserRepository): UserDetailsService
{
    override fun loadUserByUsername(eamil: String): UserDetails {
        val user = userRepository.findByEmail(eamil)?: throw UserNotFoundException()
        return CustomUserDetails(user)
    }
}