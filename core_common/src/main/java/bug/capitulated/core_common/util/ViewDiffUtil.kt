package bug.capitulated.core_common.util

import android.app.Activity
import android.view.View
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.view.ActionMode
import androidx.core.view.isVisible
import io.reactivex.subjects.BehaviorSubject

var TextView.diffedText: CharSequence
    get() = text
    set(value) {
        if (text != value) text = value
    }

var EditText.diffedText: String
    get() = text.toString()
    set(value) {
        if (text.toString() != value) text = value.toEditable()
    }

var Activity.diffedTitle: CharSequence
    get() = title
    set(value) {
        if (title != value) title = value
    }

var ActionMode.diffedTitle: CharSequence
    get() = title
    set(value) {
        if (title != value) title = value
    }

var CompoundButton.diffedCheck: Boolean
    get() = isChecked
    set(value) {
        if (isChecked != value) isChecked = value
    }

var <T> BehaviorSubject<T>.diffedValue: T?
    get() = value
    set(value) {
        if (this.value != value && value != null) onNext(value)
    }

inline var View.diffedIsVisible: Boolean
    get() = isVisible
    set(value) {
        if (isVisible != value) isVisible = value
    }