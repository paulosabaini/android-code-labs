package com.androiddevs.unittesthomework

import com.google.common.truth.Truth.assertThat
import org.junit.Test

internal class HomeworkTest {

    // fib()

    @Test
    fun `fibonacci of 0 is equal 0`() {
        val result = Homework.fib(0)
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `fibonacci of 1 is equal 1`() {
        val result = Homework.fib(1)
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `fibonacci of 3 is equal 2`() {
        val result = Homework.fib(3)
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `fibonacci of -5 is null`() {
        val result = Homework.fib(-5)
        assertThat(result).isNull()
    }

    // checkBraces()

    @Test
    fun `valid braces returns true`() {
        val result = Homework.checkBraces("(a * b)")
        assertThat(result).isTrue()
    }

    @Test
    fun `invalid braces returns false`() {
        val result = Homework.checkBraces("(a * b))")
        assertThat(result).isFalse()
    }

    @Test
    fun `no braces returns true`() {
        val result = Homework.checkBraces("a * b")
        assertThat(result).isTrue()
    }

    @Test
    fun `empty string returns false`() {
        val result = Homework.checkBraces("")
        assertThat(result).isFalse()
    }

    @Test
    fun `out of order braces returns false`() {
        val result = Homework.checkBraces(") a * b (")
        assertThat(result).isFalse()
    }

}