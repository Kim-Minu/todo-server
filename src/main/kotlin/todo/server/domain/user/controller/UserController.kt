package todo.server.domain.user.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import springfox.documentation.annotations.ApiIgnore
import todo.server.domain.user.dto.*
import todo.server.domain.user.service.UserService
import javax.validation.Valid

@Api(tags = ["회원 API"])
@RestController
@RequestMapping("/api/v1/user")
class UserController (
    private val userService: UserService
) {
    @ApiOperation(value = "로그인")
    @PostMapping("/signIn")
    fun signIn(@RequestBody @Validated requestDto: UserSignInRequestDto): ResponseEntity<UserSignInResponseDto>{
        val result = userService.signIn(requestDto)
        return ResponseEntity(result, HttpStatus.OK)
    }

    @ApiOperation(value = "회원가입")
    @PostMapping("/signUp")
    fun signUp(@RequestBody @Validated requestDto: UserSignUpRequestDto): ResponseEntity<UserSignUpResponseDto>{
        val result = userService.signUp(requestDto)
        return ResponseEntity(result, HttpStatus.CREATED)
    }

    @ApiOperation(value = "내 정보 보기")
    @GetMapping("/my")
    fun find(@ApiIgnore @RequestHeader("Authorization") jwtToken: String) : ResponseEntity<UserResponseDto> {
        val result = userService.find(jwtToken)
        return ResponseEntity(result, HttpStatus.OK)
    }

}