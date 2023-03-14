package com.example.monika.goodwords.ui.word


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.example.monika.goodwords.R
import com.example.monika.goodwords.bazadanych.DatabaseHelper
import com.example.monika.goodwords.model.FamilyWord
import com.example.monika.goodwords.validacja.InputValidation
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_add_family.*


class AddFamilyFragment : Fragment() , View.OnClickListener {

    private lateinit var inputValidation: InputValidation
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_add_family, container, false)

        val appCompatButtonAddFamily: AppCompatButton = root.findViewById(R.id.appCompatButtonAddFamily)
        appCompatButtonAddFamily!!.setOnClickListener(this)

        inputValidation = InputValidation(activity)
        databaseHelper = DatabaseHelper(activity)

        return root
    }

    /**
     * Metoda odpowiedzialna za kliknięci
     *
     * @param v
     */
    override fun onClick(v: View) {
        when (v.id) {

            R.id.appCompatButtonAddFamily -> postDataToSQLite()


        }
    }

    private fun postDataToSQLite() {

        if (!inputValidation!!.isInputEditTextFilled(textInputEditTextFamilyAng, textInputLayoutFamilyAng, getString(R.string.error_message_ang))) {
            return
        }
        if (!inputValidation!!.isInputEditTextFilled(textInputEditTextFamilyPol, textInputLayoutFamilyPol, getString(R.string.error_message_pol))) {
            return
        }



        if (!databaseHelper!!.checkFamilyWord(textInputEditTextFamilyAng!!.text.toString().trim())) {

            var familyWord = FamilyWord(ang = textInputEditTextFamilyAng!!.text.toString().trim(),
                pol = textInputEditTextFamilyPol!!.text.toString().trim())

            databaseHelper!!.addFamilyWord(familyWord)


            Snackbar.make(nestedScrollView!!, getString(R.string.success_message_add), Snackbar.LENGTH_LONG).show()
            emptyInputEditText()


        } else {

            Snackbar.make(nestedScrollView!!, getString(R.string.error_word_exists), Snackbar.LENGTH_LONG).show()
        }

    }

    /**
     * Metoda sprawdza czy wprowadzone dane nie są null(puste)
     */
    private fun emptyInputEditText() {
        textInputEditTextFamilyAng!!.text = null
        textInputEditTextFamilyPol!!.text = null
    }


}

