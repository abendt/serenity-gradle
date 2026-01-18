package demo

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import net.serenitybdd.annotations.Steps
import net.serenitybdd.junit5.SerenityJUnit5Extension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(SerenityJUnit5Extension::class)
class SerenityTest {

    @Steps
    lateinit var steps: MySteps

    @Test
    fun serenityTest() {
        steps.givenCount(0)
        steps.whenCountIncremented()
        steps.thenCountIs(1)
    }
}

open class MySteps {

    var count = -1

    @Given("count is {0}")
    open fun givenCount(init: Int) {
        count = init
    }

    @When("count is incremented")
    open fun whenCountIncremented() {
        count++
    }

    @Then("count is {0}")
    open fun thenCountIs(expected: Int) {
        assert(count == expected)
    }

}