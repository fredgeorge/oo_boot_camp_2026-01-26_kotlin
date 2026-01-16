package com.nrkei.training.oo.unit

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

// Ensures Rectangle operates correctly
internal class RectangleTest {

    @Test
    fun area() {
        Assertions.assertEquals(24.0, Rectangle(4.0, 6.0).area())
    }
}