package com.tastybeans.services.profile.command

import com.tastybeans.services.profile.command.api.*
import com.tastybeans.services.profile.shared.BusinessRuleViolationException
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate
import java.util.*

data class Subscription(val startDate: Date, val endDate: Date? = null)

@Aggregate
class Customer private constructor() {
    @get:AggregateIdentifier
    lateinit var id: String
        protected set

    lateinit var firstName: String
        protected set

    lateinit var lastName: String
        protected set

    lateinit var emailAddress: String
        protected set

    lateinit var invoiceAddress: Address
        protected set

    lateinit var shippingAddress: Address
        protected set

    var subscription: Subscription? = null
        protected set

    @CommandHandler
    constructor(cmd: RegisterCustomer) : this() {
        AggregateLifecycle.apply(
            CustomerRegistered(
                cmd.customerId,
                cmd.firstName,
                cmd.lastName,
                cmd.emailAddress,
                cmd.invoiceAddress,
                cmd.shippingAddress
            )
        )

        AggregateLifecycle.apply(SubscriptionStarted(cmd.customerId, cmd.registrationDate))
    }

    @CommandHandler
    fun cancelSubscription(cmd: CancelSubscription) {
        if (subscription == null) {
            throw BusinessRuleViolationException("Customer does not have an active subscription")
        }

        if (subscription?.endDate != null) {
            throw BusinessRuleViolationException("Customer's subscription has already been cancelled")
        }

        AggregateLifecycle.apply(SubscriptionCancelled(cmd.customerId, cmd.endDate))
    }

    @CommandHandler
    fun endSubscription(cmd: EndSubscription) {
        if (subscription == null) {
            throw BusinessRuleViolationException("Customer does not have an active subscription")
        }

        AggregateLifecycle.apply(SubscriptionEnded(cmd.customerId))
    }

    fun startSubscription(cmd: StartSubscription) {
        if (subscription != null) {
            throw BusinessRuleViolationException("Customer already has an active subscription")
        }

        AggregateLifecycle.apply(SubscriptionStarted(cmd.customerId, cmd.startDate))
    }

    @EventSourcingHandler
    fun on(evt: CustomerRegistered) {
        id = evt.id
        firstName = evt.firstName
        lastName = evt.lastName
        emailAddress = evt.emailAddress
        invoiceAddress = evt.invoiceAddress
        shippingAddress = evt.shippingAddress
    }

    @EventSourcingHandler
    fun on(evt: SubscriptionStarted) {
        subscription = Subscription(evt.startDate)
    }

    @EventSourcingHandler
    fun on(evt: SubscriptionCancelled) {
        subscription = subscription?.copy(endDate = evt.endDate)
    }

    @EventSourcingHandler
    fun on(evt: SubscriptionEnded) {
        subscription = null
    }
}