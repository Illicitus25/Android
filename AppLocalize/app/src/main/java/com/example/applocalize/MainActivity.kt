import android.content.res.Configuration
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.applocalize.R
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var selectedLanguage: TextView
    private lateinit var checkboxEnglish: CheckBox
    private lateinit var checkboxSpanish: CheckBox
    private lateinit var checkboxFrench: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectedLanguage = findViewById(R.id.selected_language)
        checkboxEnglish = findViewById(R.id.checkbox_english)
        checkboxSpanish = findViewById(R.id.checkbox_spanish)
        checkboxFrench = findViewById(R.id.checkbox_french)

        // Set up checkbox listeners
        checkboxEnglish.setOnClickListener {
            if (checkboxEnglish.isChecked) {
                changeLanguage("en")
                checkboxSpanish.isChecked = false
                checkboxFrench.isChecked = false
            }
        }

        checkboxSpanish.setOnClickListener {
            if (checkboxSpanish.isChecked) {
                changeLanguage("es")
                checkboxEnglish.isChecked = false
                checkboxFrench.isChecked = false
            }
        }

        checkboxFrench.setOnClickListener {
            if (checkboxFrench.isChecked) {
                changeLanguage("fr")
                checkboxEnglish.isChecked = false
                checkboxSpanish.isChecked = false
            }
        }
    }

    private fun changeLanguage(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val resources = resources
        val dm: DisplayMetrics = resources.displayMetrics
        val config: Configuration = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, dm)

        // Refresh the activity to apply the new language
        recreate()
    }
}
