package com.example.operatorbz2.domain

interface Repository {
    fun getFirstList(): List<Item>
    fun getSecondList(): List<Item>
}