package com.example.quartz.business.jpa

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "BUYERS")
class Buyer(
    @Id
    @Column(name = "BUYER_ID", nullable = false)
    var id: String = "",

    @Column(name = "BUYER_NAME")
    var buyerName: String? = null
) : Serializable {

}