package com.alwaysbaked.flagsandcontacts.contacts


class Contact {

    var name: String? = null
    var number: String? = null

    override fun toString(): String {
        return "Contact{" +
                "Name='" + name + '\''.toString() +
                ", Number='" + number + '\''.toString() +
                '}'.toString()
    }
}
