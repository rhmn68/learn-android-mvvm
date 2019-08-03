package coffeecode.co.learnmvvm.utils

import coffeecode.co.learnmvvm.data.FakeDatabase
import coffeecode.co.learnmvvm.data.QuoteRepository
import coffeecode.co.learnmvvm.view_models.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory{
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }

}