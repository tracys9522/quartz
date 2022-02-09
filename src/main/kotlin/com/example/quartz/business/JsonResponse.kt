package com.example.quartz.business

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class JsonResponse(
    val hasActiveBuyer: Boolean? = null
)