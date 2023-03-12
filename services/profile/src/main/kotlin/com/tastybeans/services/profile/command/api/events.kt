package com.tastybeans.services.profile.command.api

import java.util.Date

data class CustomerRegistered(
        val id: String,
        val firstName: String,
        val lastName: String,
        val emailAddress: String,
        val invoiceAddress: Address,
        val shippingAddress: Address
)

data class SubscriptionStarted(
        val id: String,
        val startDate: Date
)

data class SubscriptionCancelled(
        val id: String,
        val endDate: Date
)

data class SubscriptionEnded(val id: String)