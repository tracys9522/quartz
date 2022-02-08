package com.example.quartz.business.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface BuyerRepository : JpaRepository<Buyer, String> {
    @Query(
        nativeQuery = true, value =
        """
                    SELECT BUYER_ID FROM BUYERS WHERE STATUS = '0'
    """
    )
    fun findActiveBuyer(): List<String>
}