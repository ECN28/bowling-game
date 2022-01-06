package com.yildiz.bowlinggame.exception

class RollNegativeInputException(message: String = "You entered a negative value for your roll! Please type a positive value:"): Exception(message)  {
}