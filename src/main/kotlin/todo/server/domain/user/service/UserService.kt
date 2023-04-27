package todo.server.domain.user.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.authentication.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import todo.server.domain.user.domain.UserRepository
import todo.server.domain.user.dto.*
import todo.server.domain.user.exception.UserEmailDuplicateException
import todo.server.domain.user.exception.UserNotFoundException
import todo.server.domain.user.exception.UserSignInException
import todo.server.global.jwt.JwtTokenProvider
import java.util.*
import javax.transaction.Transactional

@Service
class UserService (
    private val userRepository: UserRepository,
    private val authenticationManager: AuthenticationManager,
    private val jwtTokenProvider: JwtTokenProvider,
) {
    private val bCryptPasswordEncoder = BCryptPasswordEncoder()

    // 회원 정보 조회
    fun find(jwtToken: String): UserResponseDto {
        val id = jwtTokenProvider.getUserId(jwtToken)
        val user = userRepository.findByIdOrNull(id) ?: throw UserNotFoundException()
        return UserResponseDto(user)
    }

    // 회원 가입
    @Transactional
    fun signUp(requestDto: UserSignUpRequestDto): UserSignUpResponseDto {

        // 이메일 중복체크
        val emailExist = userRepository.existsByEmail(requestDto.email)

        if(emailExist){
            throw UserEmailDuplicateException(requestDto.email)
        }

        val user = userRepository.save(requestDto.toEntity(bCryptPasswordEncoder.encode(requestDto.password)))

        val token = jwtTokenProvider.createToken(user)

        return UserSignUpResponseDto(user, token)
    }

    /**
     * 로그인
     */
    fun signIn(requestDto: UserSignInRequestDto): UserSignInResponseDto {

        val user = userRepository.findByEmail(requestDto.id) ?: throw UserNotFoundException()

        try {
            //아이디 비밀번호 인증
            val authenticator = UsernamePasswordAuthenticationToken(user.email, requestDto.password)

            if(!authenticationManager.authenticate(authenticator).isAuthenticated){
                throw UserSignInException("아이디 또는 비밀번호를 확인해주세요.")
            }

        }catch (e: DisabledException) {
            throw UserSignInException(e.message!!)
        }catch (e: BadCredentialsException){
            throw UserSignInException(e.message!!)
        }catch (e: LockedException){
            throw UserSignInException(e.message!!)
        }

        val token = jwtTokenProvider.createToken(user)

        return UserSignInResponseDto(user, token)
    }


    // 랜덤 문자열 생성
    fun randomPasswordGenerator(length: Int): String? {
        val randomString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val random = Random()
        val stringBuilder = StringBuilder(length)

        for (i in 0 until length) {
            stringBuilder.append(randomString[random.nextInt(randomString.length)])
        }

        return stringBuilder.toString()
    }
}