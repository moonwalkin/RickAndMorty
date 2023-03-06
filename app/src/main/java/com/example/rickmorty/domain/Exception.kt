package com.example.rickmorty.domain

import java.io.IOException

class NoConnectionException : IOException("No Internet Connection!")

class ServiceUnavailableException : IOException("Service unavailable!")