package org.sabaini.testingonandroid

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `empty username returns false`() {
        val result = RegistrationUtil.validateRegistrationInput("", "123", "123")
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true`() {
        val result = RegistrationUtil.validateRegistrationInput("Philipp", "123", "123")
        assertThat(result).isTrue()
    }

    @Test
    fun `username already exists returns false`() {
        val result = RegistrationUtil.validateRegistrationInput("Carl", "123", "123")
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput("Bill", "", "")
        assertThat(result).isFalse()
    }

    @Test
    fun `incorrectly confirmed password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput("Peter", "123", "12345")
        assertThat(result).isFalse()
    }

    @Test
    fun `less than two digits password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput("Peter", "abc1", "abc1")
        assertThat(result).isFalse()
    }
}