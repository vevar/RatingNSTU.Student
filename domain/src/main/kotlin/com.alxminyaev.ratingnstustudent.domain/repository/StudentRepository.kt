package com.alxminyaev.ratingnstustudent.domain.repository

import com.alxminyaev.ratingnstustudent.domain.model.Account
import com.alxminyaev.ratingnstustudent.domain.model.Student

interface StudentRepository {
    suspend fun findByAccount(account: Account): Student
}