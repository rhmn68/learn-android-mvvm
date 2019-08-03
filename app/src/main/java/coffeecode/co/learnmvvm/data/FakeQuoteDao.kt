package coffeecode.co.learnmvvm.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import coffeecode.co.learnmvvm.model.Quote

class FakeQuoteDao {
    private val quoteList = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
    }

    fun addQuote(quote: Quote){
        quoteList.add(quote)
        quotes.value = quoteList
    }

    fun getQuotes() = quotes as LiveData<List<Quote>>
}