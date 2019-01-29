package com.example.indicatormodule.excaption

class PageLessException : Exception() {
    override val message: String?
        get() = "Page must equal or lager than 2"
}