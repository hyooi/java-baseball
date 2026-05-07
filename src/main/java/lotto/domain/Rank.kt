package lotto.domain

enum class Rank(
    val matchCount: Int,
    val bonusMatch: Boolean,
    val prize: Long,
) {
    FIFTH(3, false, 5_000L),
    FOURTH(4, false, 50_000L),
    THIRD(5, false, 1_500_000L),
    SECOND(5, true, 30_000_000L),
    FIRST(6, false, 2_000_000_000L),
    MISS(0, false, 0L);

    companion object {
        fun of(matchCount: Int, bonusMatch: Boolean): Rank =
            entries.firstOrNull { rank ->
                rank != MISS && rank.matchCount == matchCount && rank.bonusMatch == bonusMatch
            } ?: MISS
    }
}