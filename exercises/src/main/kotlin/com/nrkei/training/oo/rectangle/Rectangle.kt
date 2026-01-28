package com.nrkei.training.oo.rectangle

// Understands a four-sided polygon with sides at right angles
class Rectangle(length: Number, width: Number) {
    companion object {
        fun square(side: Number) = Rectangle(side, side)
    }
    private val length = length.toDouble()
    private val width = width.toDouble()
    init {
        require(this.length > 0.0 && this.width > 0.0) {
            "Dimensions must be greater than zero."
        }
    }
    fun area() = length * width
    val area get() = area()
    fun perimeter() = (length + width) * 2.0
    val perimeter get() = perimeter()
}