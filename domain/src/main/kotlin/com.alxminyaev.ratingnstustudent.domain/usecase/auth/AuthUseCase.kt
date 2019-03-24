package com.alxminyaev.ratingnstustudent.domain.usecase.auth

import com.alxminyaev.ratingnstustudent.domain.model.Account
import com.alxminyaev.ratingnstustudent.domain.model.Student
import com.alxminyaev.ratingnstustudent.domain.repository.StudentRepository
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val studentRepository: StudentRepository
) {

    suspend fun auth(username: String, password: String): Student {
        return studentRepository.findByAccount(Account(username, password))
    }
}