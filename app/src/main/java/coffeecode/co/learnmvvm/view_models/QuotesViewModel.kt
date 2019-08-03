package coffeecode.co.learnmvvm.view_models

import androidx.lifecycle.ViewModel
import coffeecode.co.learnmvvm.data.QuoteRepository
import coffeecode.co.learnmvvm.model.Quote

class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel(){

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuotes(quote: Quote) = quoteRepository.addQuote(quote)
}