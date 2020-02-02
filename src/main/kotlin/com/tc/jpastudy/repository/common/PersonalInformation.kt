package com.tc.jpastudy.repository.common

import javax.persistence.Embeddable

@Embeddable
class PersonalInformation private constructor(
    name: String,
    age: Int,
    phone: String,
    address: String
) {

    companion object {
        fun empty() = PersonalInformation("", 0, "", "")
    }

    var name: String = name
        protected set
    var age: Int = age
        protected set
    var phone: String = phone
        protected set
    var address: String = address
        protected set
}
