package com.ratingnstustudent.data.repository

import com.alxminyaev.ratingnstustudent.domain.model.Account
import com.alxminyaev.ratingnstustudent.domain.model.Student
import com.alxminyaev.ratingnstustudent.domain.repository.StudentRepository
import javax.inject.Inject

class StudentRepositoryImpl @Inject constructor(

) : StudentRepository {

    override suspend fun findByAccount(account: Account): Student {
        TODO()
    }
}