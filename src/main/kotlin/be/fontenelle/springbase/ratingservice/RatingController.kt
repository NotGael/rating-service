package be.fontenelle.springbase.ratingservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ratings")
class RatingController {

    val ratings = listOf(Rating(1L, 1L, 2), Rating(2L, 1L, 3), Rating(3L, 2L, 4), Rating(4L, 2L, 5))

    @GetMapping("")
    fun findRatingsByBookId(@RequestParam bookId: Long?): List<Rating> {
        return if (bookId == null || bookId == 0L) {
            emptyList()
        } else {
            ratings.filter { r ->
                r.id == bookId
            }.toList()
        }
    }

    @GetMapping("/all")
    fun findAllRatings(): List<Rating> {
        return ratings
    }
}