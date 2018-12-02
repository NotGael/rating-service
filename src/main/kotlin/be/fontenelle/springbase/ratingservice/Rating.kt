package be.fontenelle.springbase.ratingservice

data class Rating (

        val id: Long,

        val bookId: Long,

        val stars: Int
)
