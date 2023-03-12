package com.tastybeans.services.profile.command.api

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.Date

data class RegisterCustomer(
        @TargetAggregateIdentifier
        val customerId: String,
        val registrationDate: Date,
        val firstName: String,
        val lastName: String,
        val emailAddress: String,
        val invoiceAddress: Address,
        val shippingAddress: Address
)

data class CancelSubscription(
        @TargetAggregateIdentifier
        val customerId: String,
        val endDate: Date
)

data class EndSubscription(
        @TargetAggregateIdentifier
        val customerId: String
)

data class StartSubscription(
        @TargetAggregateIdentifier
        val customerId: String,
        val startDate: Date
)