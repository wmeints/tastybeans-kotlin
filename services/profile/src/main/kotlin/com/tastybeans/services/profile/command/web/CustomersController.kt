package com.tastybeans.services.profile.command.web

import com.tastybeans.services.profile.command.api.RegisterCustomer
import org.axonframework.extensions.reactor.commandhandling.gateway.ReactorCommandGateway
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.net.URI
import java.util.*

@CrossOrigin
@RestController
@RequestMapping("/customers")
class CustomersController(private val gateway: ReactorCommandGateway) {
    @PostMapping
    fun registerCustomer(form: RegisterCustomerForm): Mono<ResponseEntity<Any>> {
        val customerId = UUID.randomUUID().toString()

        val cmd = RegisterCustomer(customerId, Date(), form.firstName, form.lastName,
            form.emailAddress, form.invoiceAddress, form.shippingAddress)

        return gateway.send<RegisterCustomer>(cmd).map {
            ResponseEntity.created(URI("/customers/${customerId}")).build()
        }
    }
}