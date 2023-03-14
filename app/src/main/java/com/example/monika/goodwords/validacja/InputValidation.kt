package com.example.monika.goodwords.validacja

import android.app.Activity
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.FragmentActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class InputValidation
/**
 * constructor
 *
 * @param context
 */(private val context: FragmentActivity?) {

    /**
     * metoda sprawdzająca czy InputEditText jest wypełniony
     *
     * @param textInputEditText
     * @param textInputLayout
     * @param message
     * @return
     */
    fun isInputEditTextFilled(textInputEditText: TextInputEditText, textInputLayout: TextInputLayout, message: String): Boolean {
        val value = textInputEditText.text.toString().trim()
        if (value.isEmpty()) {
            textInputLayout.error = message
            hideKeyboardFrom(textInputEditText)
            return false
        } else {
            textInputLayout.isErrorEnabled = false
        }

        return true
    }


    /**
     * metoda sprawdzająca czy  InputEditText ma prawidłowy email
     *
     * @param textInputEditText
     * @param textInputLayout
     * @param message
     * @return
     */
    fun isInputEditTextEmail(textInputEditText: TextInputEditText, textInputLayout: TextInputLayout, message: String): Boolean {
        val value = textInputEditText.text.toString().trim()
        if (value.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            textInputLayout.error = message
            hideKeyboardFrom(textInputEditText)
            return false
        } else {
            textInputLayout.isErrorEnabled = false
        }
        return true
    }

    /**
     * metoda sprawdzająca zgodniości obu wartości InputEditText
     *
     * @param textInputEditText1
     * @param textInputEditText2
     * @param textInputLayout
     * @param message
     * @return
     */
    fun isInputEditTextMatches(textInputEditText1: TextInputEditText, textInputEditText2: TextInputEditText, textInputLayout: TextInputLayout, message: String): Boolean {
        val value1 = textInputEditText1.text.toString().trim()
        val value2 = textInputEditText2.text.toString().trim()
        if (!value1.contentEquals(value2)) {
            textInputLayout.error = message
            hideKeyboardFrom(textInputEditText2)
            return false
        } else {
            textInputLayout.isErrorEnabled = false
        }
        return true
    }

    /**
     * metoda ukrywająca klawiaturę
     *
     * @param view
     */
    private fun hideKeyboardFrom(view: View) {
        val imm = context!!.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }
}
