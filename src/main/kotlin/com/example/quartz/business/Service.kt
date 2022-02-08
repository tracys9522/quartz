package com.example.quartz.business

import com.example.quartz.business.jpa.BuyerRepository
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Service

@Service
class Service(
    private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate,
    private val buyerRepository: BuyerRepository
) {
    fun getResponse(): JsonResponse {
        val sql = """
            SELECT BUYER_ID FROM BUYERS WHERE STATUS = :status
        """.trimIndent()
        val statement = MapSqlParameterSource("status", 0)
        return JsonResponse(namedParameterJdbcTemplate.queryForList(sql, statement).isNotEmpty())
    }

    fun getJpaResponse(): JsonResponse {
        return JsonResponse(buyerRepository.findActiveBuyer().isNotEmpty())
    }
}