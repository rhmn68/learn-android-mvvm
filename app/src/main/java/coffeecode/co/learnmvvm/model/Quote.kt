package coffeecode.co.learnmvvm.model

data class Quote(
        val quoteText: String,
        val author: String){
    override fun toString(): String {
        return "$quoteText - $author"
    }
}