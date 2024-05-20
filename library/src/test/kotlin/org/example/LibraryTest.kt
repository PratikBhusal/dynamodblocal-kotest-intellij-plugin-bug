package org.example

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.booleans.shouldNotBeFalse

class LibraryTest : FunSpec({
    val classUnderTest = Library()

    context("Sample context") {
        test("someLibraryMethod returns true") {
            classUnderTest
                .someLibraryMethod()
                .shouldBeTrue()
        }

        test("someLibraryMethod also returns true") {
            classUnderTest
                .someLibraryMethod()
                .shouldNotBeFalse()
        }
    }
})
