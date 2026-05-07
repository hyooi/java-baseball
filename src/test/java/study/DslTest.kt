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
        val actual =
            introduce {
                name("강효인")
                company("현대자동차그룹")
                skills {
                    soft("A passion for problem solving")
                    soft("Good communication skills")
                    hard("Kotlin")
                }
                languages {
                    "Korean" level 5
                    "English" level 3
                }
            }

        actual.name shouldBe "강효인"
        actual.company shouldBe "현대자동차그룹"
        actual.skill[0].type shouldBe SkillType.SOFT
        actual.skill[0].description shouldBe "A passion for problem solving"
        actual.skill[1].type shouldBe SkillType.SOFT
        actual.skill[1].description shouldBe "Good communication skills"
        actual.skill[2].type shouldBe SkillType.HARD
        actual.skill[2].description shouldBe "Kotlin"
        actual.languages[0].language shouldBe "Korean"
        actual.languages[0].level shouldBe 5
        actual.languages[1].language shouldBe "English"
        actual.languages[1].level shouldBe 3
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
    private var languages: List<Language> = emptyList()
    private var skills: List<Skill> = emptyList()

    fun name(name: String) { this.name = name }
    fun company(company: String) { this.company = company }
    fun skills(block: SkillBuilder.() -> Unit) {
        skills = SkillBuilder()
            .apply(block)
            .build()
    }
    fun languages(block: LanguageBuilder.() -> Unit) {
        languages = LanguageBuilder()
            .apply(block)
            .build()
    }

//    fun build(): Person = Person(name!!) //null회피1 : name이 null이 아니라고 강제로 알려줌. 만약 null이면 NPE
//    fun build(): Person = Person(name ?: "default name") //null회피2
    fun build(): Person = Person(name, company, skills, languages)
}

class SkillBuilder {
    private val skills = mutableListOf<Skill>()
    fun soft(description: String) {
        skills.add(Skill(SkillType.SOFT, description))
    }
    fun hard(description: String) {
        skills.add(Skill(SkillType.HARD, description))
    }
    fun build(): List<Skill> = skills

}

class LanguageBuilder {
    private val languages = mutableListOf<Language>()

    infix fun String.level(other: Int) {
        languages.add(Language(this, other))
    }

    fun build(): List<Language> = languages
}

class Person(val name: String,
             val company: String,
             val skill: List<Skill>,
             val languages: List<Language>) {}

data class Skill(val type: SkillType, val description: String) {}

enum class SkillType {
    SOFT, HARD
}

data class Language(val language: String,
    val level: Int) {
}