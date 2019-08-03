package coffeecode.co.learnmvvm.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import coffeecode.co.learnmvvm.R
import coffeecode.co.learnmvvm.model.Quote
import coffeecode.co.learnmvvm.utils.InjectorUtils
import coffeecode.co.learnmvvm.view_models.QuotesViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer {
            val stringBuilder = StringBuilder()
            it.forEach {
                stringBuilder.append("$it\n\n")
            }

            tvQuote.text = stringBuilder.toString()
        })

        btnAddQuote.setOnClickListener {
            val quote = Quote(etQuote.text.toString(), etAuthor.text.toString())
            viewModel.addQuotes(quote)
            etQuote.setText("")
            etAuthor.setText("")
        }
    }
}
