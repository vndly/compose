package com.mauriciotogneri.composetest.di

import javax.inject.Inject

class RepositoryImpl @Inject constructor() : Repository {
    override fun testMethod(): Int = 42
}