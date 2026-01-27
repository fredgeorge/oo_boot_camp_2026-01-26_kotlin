/*
 * Copyright (c) 2022-26 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package com.nrkei.training.oo.unit

import com.nrkei.training.oo.quantities.Quantity
import com.nrkei.training.oo.quantities.Unit.Companion.PINT
import com.nrkei.training.oo.quantities.Unit.Companion.TABLESPOON
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

// Ensures Quantities operate correctly
internal class QuantityTest {

    @Test fun `equality of like units`() {
        assertEquals(Quantity(8.0, TABLESPOON), Quantity(8.0, TABLESPOON))
        assertNotEquals(Quantity(8.0, TABLESPOON), Quantity(6.0, TABLESPOON))
        assertNotEquals(Quantity(8.0, TABLESPOON), Any())
        assertNotEquals(Quantity(8.0, TABLESPOON), null)
    }

    @Test
    fun `equality of different units`() {
        assertNotEquals(Quantity(8.0, TABLESPOON), Quantity(8.0, PINT))
    }
}