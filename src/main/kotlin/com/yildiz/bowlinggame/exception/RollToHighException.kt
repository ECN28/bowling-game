package com.yildiz.bowlinggame.exception

class RollToHighException(message: String = "You entered a to high value for your roll! Please type the correct value:"): Exception(message) {
}