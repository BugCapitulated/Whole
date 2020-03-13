package bug.capitulated.core_common.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

fun EditText.onTextChanged(onTextChanged: (String) -> Unit) {
    addTextChangedListener(createTextWatcher(onTextChanged))
}

fun createTextWatcher(onTextChanged: (String) -> Unit): TextWatcher {
    return object : TextWatcher {
        override fun afterTextChanged(s: Editable) {}
        
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        
        override fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int) {
            onTextChanged.invoke(text.toString())
        }
    }
}