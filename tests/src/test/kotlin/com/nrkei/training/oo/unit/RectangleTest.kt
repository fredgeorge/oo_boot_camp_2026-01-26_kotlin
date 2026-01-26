package com.nrkei.training.oo.unit

import com.nrkei.training.oo.rectangle.Rectangle
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

// Ensures Rectangle operates correctly
internal class RectangleTest {

    @Test
    fun area() {
        assertEquals(24.0, Rectangle(4.0, 6.0).area())
        assertEquals(24.0, Rectangle(4, 6).area)
    }

    @Test fun perimeter() {
        assertEquals(20.0, Rectangle(4.0, 6.0).perimeter())
        assertEquals(20.0, Rectangle(4, 6).perimeter())
    }

    @Test fun `value dimension`() {
        assertThrows<IllegalArgumentException> { Rectangle(0, 4)  }
        assertThrows<IllegalArgumentException> { Rectangle(6, 0)  }
    }
}