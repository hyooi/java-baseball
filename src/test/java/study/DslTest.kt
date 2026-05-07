package study

import io.kotest.matchers.shouldBe
import org.junit.Test

/**
 * introduce {
 *   name("강효인")
 *   company("현대자동차그룹")
 *   skills {
 *     soft("A passion for problem solving")
 *     soft("Good communication skills")
 *     hard("Kotlin")
 *   }
 *   languages {
 *     "Korean" level 5
 *     "English" level 3
 *   }
 * }
 *
 */
class DslTest {
    @Test
    fun name() {
        val actual = introduce {
            name("강효인")
            company("현대자동차그룹")
        }
        actual.name shouldBe "강효인"
        actual.company shouldBe "현대자동차그룹"
    }

    private fun introduce(block: PersonBuilder.() -> Unit): Person {
        return PersonBuilder()
            .apply(block)
            .build()
    }
}

class PersonBuilder {
//    private var name: String = "" // 코틀린은 반드시 초기화를 해야함
    private lateinit var name: String // 지연초기화
    private var company: String = ""

    fun name(name: String) { this.name = name }
    fun company(company: String) { this.company = company }
//    fun build(): Person = Person(name!!) //null회피1 : name이 null이 아니라고 강제로 알려줌. 만약 null이면 NPE
//    fun build(): Person = Person(name ?: "default name") //null회피2
    fun build(): Person = Person(name, company)
}

class Person(val name: String, val company: String) {}
