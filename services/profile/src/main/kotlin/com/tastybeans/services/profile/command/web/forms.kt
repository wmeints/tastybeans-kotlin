package com.tastybeans.services.profile.command.web

import com.tastybeans.services.profile.command.api.Address

data class RegisterCustomerForm(
    val firstName: String,
    val lastName: String,
    val emailAddress: String,
    val invoiceAddress: Address,
    val shippingAddress: Address)