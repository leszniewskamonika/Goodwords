package com.example.monika.goodwords.bazadanych

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.fragment.app.FragmentActivity
import com.example.monika.goodwords.model.User
import com.example.monika.goodwords.model.FamilyWord
import com.example.monika.goodwords.model.HomeWord
import com.example.monika.goodwords.model.UncategorizedWord
import java.util.ArrayList

class DatabaseHelper(context: FragmentActivity?)  : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){
    // tworzy tabelę z zapytania query
    private val CREATE_USER_TABLE = ("CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")")


    private val CREATE_FAMILYWORD_TABLE = ("CREATE TABLE " + TABLE_FAMILYWORD + "("
            + COLUMN_FAMILYWORD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_FAMILYWORD_ANG + " TEXT,"
            + COLUMN_FAMILYWORD_POL + " TEXT" + ")")

    private val CREATE_HOMEWORD_TABLE = ("CREATE TABLE " + TABLE_HOMEWORD + "("
            + COLUMN_HOMEWORD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_HOMEWORD_ANG + " TEXT,"
            + COLUMN_HOMEWORD_POL + " TEXT" + ")")

    private val CREATE_UNCATEGORIZEDWORD_TABLE = ("CREATE TABLE " + TABLE_UNCATEGORIZEDWORD + "("
            + COLUMN_UNCATEGORIZEDWORD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_UNCATEGORIZEDWORD_ANG + " TEXT,"
            + COLUMN_UNCATEGORIZEDWORD_POL + " TEXT" + ")")


    // usuwa tablę z zapytanie query
    private val DROP_USER_TABLE = "DROP TABLE IF EXISTS $TABLE_USER"

    private val DROP_FAMILYWORD_TABLE = "DROP TABLE IF EXISTS $TABLE_FAMILYWORD"

    private val DROP_HOMEWORD_TABLE = "DROP TABLE IF EXISTS $TABLE_HOMEWORD"

    private val DROP_UNCATEGORIZEDWORD_TABLE = "DROP TABLE IF EXISTS $TABLE_UNCATEGORIZEDWORD"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_USER_TABLE)
        db.execSQL(CREATE_FAMILYWORD_TABLE)
        db.execSQL(CREATE_HOMEWORD_TABLE)
        db.execSQL(CREATE_UNCATEGORIZEDWORD_TABLE)
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        //Usuwa tabelę jeśli istnieje
        db.execSQL(DROP_USER_TABLE)
        db.execSQL(DROP_FAMILYWORD_TABLE)
        db.execSQL(DROP_HOMEWORD_TABLE)
        db.execSQL(DROP_UNCATEGORIZEDWORD_TABLE)

        // Tworzy tabelę ponownie
        onCreate(db)

    }

    /**
     * Metody odpowiedzialne za rekacje z użytkownikami (User)
     */

    /**
     * Medota tworzy rekord użytkownika
     *
     * @param user
     */
    fun addUser(user: User) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(COLUMN_USER_NAME, user.name)
        values.put(COLUMN_USER_EMAIL, user.email)
        values.put(COLUMN_USER_PASSWORD, user.password)


        db.insert(TABLE_USER, null, values)
        db.close()
    }


    /**
     * Metoda aktualizuje rekord użytkownika
     *
     * @param user
     */
    fun updateUser(user: User) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(COLUMN_USER_NAME, user.name)
        values.put(COLUMN_USER_EMAIL, user.email)
        values.put(COLUMN_USER_PASSWORD, user.password)


        db.update(TABLE_USER, values, "$COLUMN_USER_ID = ?",
            arrayOf(user.id.toString()))
        db.close()
    }



    /**
     * Metoda usuwa rekord użytkownika
     *
     * @param user
     */
    fun deleteUser(user: User) {

        val db = this.writableDatabase
        // delete user record by id
        db.delete(TABLE_USER, "$COLUMN_USER_ID = ?",
            arrayOf(user.id.toString()))
        db.close()

    }


    /**
     * Metoda sprawdza czy użytkownik isteniej czy nie
     *
     * @param email
     * @return true/false
     */
    fun checkUser(email: String): Boolean {


        val columns = arrayOf(COLUMN_USER_ID)
        val db = this.readableDatabase


        val selection = "$COLUMN_USER_EMAIL = ?"


        val selectionArgs = arrayOf(email)


        /**
         * W tym przypadku funkcja zapytania służy do pobierania rekordów z tabeli user-ów. Ta funkcja działa tak samo jak, używanie
         * zapytań sql.
         * SELECT user_id FROM user WHERE user_email = 'monika@wp.pl';
         */
        val cursor = db.query(TABLE_USER,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null
        )


        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if (cursorCount > 0) {
            return true
        }

        return false
    }


    /**
     * Metoda sprawdzająca czy użytkownik istnieje czy nie
     *
     * @param email
     * @param password
     * @return true/false
     */
    fun checkUser(email: String, password: String): Boolean {


        val columns = arrayOf(COLUMN_USER_ID)

        val db = this.readableDatabase


        val selection = "$COLUMN_USER_EMAIL = ? AND $COLUMN_USER_PASSWORD = ?"


        val selectionArgs = arrayOf(email, password)


        /**
         * W tym przypadku funkcja zapytania służy do pobierania rekordów z tabeli user-ów. Ta funkcja działa tak samo jak, używanie
         * zapytań sql.
         * SELECT user_id FROM user WHERE user_email = 'monika@wp.pl' AND user_password = 'monika';
         */
        val cursor = db.query(TABLE_USER,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null)

        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if (cursorCount > 0)
            return true

        return false

    }

    /**
     * Metody odpowiedzialne za reakcję ze słówkami kategorii rodzina (FamilyWord)
     * */


    /**
     * Metoda pobiera wszytskie słow z familyword i zwraca listę
     *
     * @return list
     */
    fun getAllFamilyWord(): List<FamilyWord> {


        val columns = arrayOf(COLUMN_FAMILYWORD_ID, COLUMN_FAMILYWORD_ANG, COLUMN_FAMILYWORD_POL)


        val sortOrder = "$COLUMN_FAMILYWORD_ANG ASC"
        val familywordList = ArrayList<FamilyWord>()

        val db = this.readableDatabase


        val cursor = db.query(TABLE_FAMILYWORD,
            columns,
            null,
            null,
            null,
            null,
            sortOrder)
        if (cursor.moveToFirst()) {
            do {
                val familyword = FamilyWord(id = cursor.getString(cursor.getColumnIndex(COLUMN_FAMILYWORD_ID)).toInt(),
                    ang = cursor.getString(cursor.getColumnIndex(COLUMN_FAMILYWORD_ANG)),
                    pol = cursor.getString(cursor.getColumnIndex(COLUMN_FAMILYWORD_POL)))

                familywordList.add(familyword)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return familywordList
    }


    /**
     * Medota tworzy rekord familyWord
     *
     * @param familyWord
     */
    fun addFamilyWord(familyWord: FamilyWord) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(COLUMN_FAMILYWORD_ANG, familyWord.ang)
        values.put(COLUMN_FAMILYWORD_POL, familyWord.pol)


        db.insert(TABLE_FAMILYWORD, null, values)
        db.close()
    }


    /**
     * Metoda aktualizuje rekord familyWord
     *
     * @param familyWord
     */
    fun updateFamilyWord(familyWord: FamilyWord) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(COLUMN_FAMILYWORD_ANG, familyWord.ang)
        values.put(COLUMN_USER_EMAIL, familyWord.pol)


        db.update(TABLE_FAMILYWORD, values, "$COLUMN_FAMILYWORD_ID = ?",
            arrayOf(familyWord.id.toString()))
        db.close()
    }


    /**
     * Metoda usuwa rekord familyWord
     *
     * @param familyWord
     */
    fun deleteFamilyWord(familyWord: FamilyWord) {

        val db = this.writableDatabase
        // delete user record by id
        db.delete(TABLE_FAMILYWORD, "$COLUMN_FAMILYWORD_ID = ?",
            arrayOf(familyWord.id.toString()))
        db.close()
    }


    /**
     * Metoda sprawdza czy familyWord isteniej czy nie
     *
     * @param ang
     * @return true/false
     */
    fun checkFamilyWord(ang: String): Boolean {


        val columns = arrayOf(COLUMN_FAMILYWORD_ID)
        val db = this.readableDatabase


        val selection = "$COLUMN_FAMILYWORD_ANG = ?"


        val selectionArgs = arrayOf(ang)


        /**
         * W tym przypadku funkcja zapytania służy do pobierania rekordów z tabeli familyword. Ta funkcja działa tak samo jak, używanie
         * zapytań sql.
         * SELECT familyword_id FROM familyword WHERE familyword_ang = 'mother';
         */
        val cursor = db.query(TABLE_FAMILYWORD,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null)


        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if (cursorCount > 0) {
            return true
        }

        return false
    }

    /**
     * Metoda sprawdzająca czy familyword istnieje czy nie
     *
     * @param ang
     * @param pol
     * @return true/false
     */
    fun checkFamilyWord(ang: String, pol: String): Boolean {


        val columns = arrayOf(COLUMN_FAMILYWORD_ID)

        val db = this.readableDatabase


        val selection = "$COLUMN_FAMILYWORD_ANG = ? AND $COLUMN_FAMILYWORD_POL = ?"


        val selectionArgs = arrayOf(ang, pol)


        /**
         * W tym przypadku funkcja zapytania służy do pobierania rekordów z tabeli familyword Ta funkcja działa tak samo jak, używanie
         * zapytań sql.
         * SELECT familyword_id FROM familyword WHERE familyword_ang = 'mother' AND familyword_pol = 'mama';
         */
        val cursor = db.query(TABLE_FAMILYWORD,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null)

        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if (cursorCount > 0)
            return true

        return false

    }

    /**
     * Metody odpowiedzialne za reakcję ze słówkami kategorii dom (HomeWord)
     * */

    /**
     * Metoda pobiera wszytskie słow z homeword i zwraca listę
     *
     * @return list
     */
    fun getAllHomeWord(): List<HomeWord> {


        val columns = arrayOf(COLUMN_HOMEWORD_ID, COLUMN_HOMEWORD_ANG, COLUMN_HOMEWORD_POL)


        val sortOrder = "$COLUMN_HOMEWORD_ANG ASC"
        val homewordList = ArrayList<HomeWord>()

        val db = this.readableDatabase


        val cursor = db.query(TABLE_HOMEWORD,
            columns,
            null,
            null,
            null,
            null,
            sortOrder)
        if (cursor.moveToFirst()) {
            do {
                val homeword = HomeWord(id = cursor.getString(cursor.getColumnIndex(COLUMN_HOMEWORD_ID)).toInt(),
                    ang = cursor.getString(cursor.getColumnIndex(COLUMN_HOMEWORD_ANG)),
                    pol = cursor.getString(cursor.getColumnIndex(COLUMN_HOMEWORD_POL)))

                homewordList.add(homeword)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return homewordList
    }

    /**
     * Metoda tworzy rekord homeword
     *
     * @param homeWord
     */
    fun addHomeWord(homeWord: HomeWord) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(COLUMN_HOMEWORD_ANG, homeWord.ang)
        values.put(COLUMN_HOMEWORD_POL, homeWord.pol)


        db.insert(TABLE_HOMEWORD, null, values)
        db.close()
    }

    /**
     * Metoda aktualizuje rekord słowa homeword
     *
     * @param homeWord
     */
    fun updateHomeWrod(homeWord: HomeWord) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(COLUMN_HOMEWORD_ANG, homeWord.ang)
        values.put(COLUMN_HOMEWORD_POL, homeWord.pol)


        db.update(TABLE_HOMEWORD, values, "$COLUMN_HOMEWORD_ID = ?",
            arrayOf(homeWord.id.toString()))
        db.close()
    }

    /**
     * Metoda usuwa rekord homeword
     *
     * @param homeWord
     */
    fun deleteHomeWord(homeWord: HomeWord) {

        val db = this.writableDatabase

        db.delete(TABLE_HOMEWORD, "$COLUMN_HOMEWORD_ID = ?",
            arrayOf(homeWord.id.toString()))
        db.close()

    }

    /**
     * Metoda sprawdza czy słowo angielkie homeword isteniej czy nie
     *
     * @param ang
     * @return true/false
     */
    fun checkHomeWord(ang: String): Boolean {


        val columns = arrayOf(COLUMN_HOMEWORD_ID)
        val db = this.readableDatabase


        val selection = "$COLUMN_HOMEWORD_ANG = ?"


        val selectionArgs = arrayOf(ang)


        /**
         * W tym przypadku funkcja zapytania służy do pobierania rekordów z tabeli homeword. Ta funkcja działa tak samo jak, używanie
         * zapytań sql.
         */
        val cursor = db.query(TABLE_HOMEWORD,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null)


        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if (cursorCount > 0) {
            return true
        }

        return false
    }
    /**
     * Metoda sprawdzająca czy homeword istnieje czy nie
     *
     * @param ang
     * @param pol
     * @return true/false
     */
    fun checkHomeWord(ang: String, pol: String): Boolean {


        val columns = arrayOf(COLUMN_HOMEWORD_ID)

        val db = this.readableDatabase


        val selection = "$COLUMN_HOMEWORD_ANG = ? AND $COLUMN_HOMEWORD_POL = ?"


        val selectionArgs = arrayOf(ang, pol)


        /**
         * W tym przypadku funkcja zapytania służy do pobierania rekordów z tabeli homeword. Ta funkcja działa tak samo jak, używanie
         * zapytań sql.
         */
        val cursor = db.query(TABLE_HOMEWORD,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null)

        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if (cursorCount > 0)
            return true

        return false

    }

    /**
     * Metody odpowiedzialne za reakcję ze słówkami kategorii bez kategorii (UncategorizedWord)
     * */

    /**
     * Metoda pobiera wszytskie słow z uncategorizedword i zwraca listę
     *
     * @return list
     */
    fun getAllUncategorizedWord(): List<UncategorizedWord> {


        val columns = arrayOf(COLUMN_UNCATEGORIZEDWORD_ID, COLUMN_UNCATEGORIZEDWORD_ANG, COLUMN_UNCATEGORIZEDWORD_POL)


        val sortOrder = "$COLUMN_UNCATEGORIZEDWORD_ANG ASC"
        val uncategorizedwordList = ArrayList<UncategorizedWord>()

        val db = this.readableDatabase


        val cursor = db.query(TABLE_UNCATEGORIZEDWORD,
            columns,
            null,
            null,
            null,
            null,
            sortOrder)
        if (cursor.moveToFirst()) {
            do {
                val uncategorizedword = UncategorizedWord(id = cursor.getString(cursor.getColumnIndex(COLUMN_UNCATEGORIZEDWORD_ID)).toInt(),
                    ang = cursor.getString(cursor.getColumnIndex(COLUMN_UNCATEGORIZEDWORD_ANG)),
                    pol = cursor.getString(cursor.getColumnIndex(COLUMN_UNCATEGORIZEDWORD_POL)))

                uncategorizedwordList.add(uncategorizedword)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return uncategorizedwordList
    }

    /**
     * Medota tworzy rekord uncategorizedword
     *
     * @param uncategorizedWord
     */
    fun addUncategorizedWord(uncategorizedWord: UncategorizedWord) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(COLUMN_UNCATEGORIZEDWORD_ANG, uncategorizedWord.ang)
        values.put(COLUMN_UNCATEGORIZEDWORD_POL, uncategorizedWord.pol)


        db.insert(TABLE_UNCATEGORIZEDWORD, null, values)
        db.close()
    }

    /**
     * Metoda aktualizuje rekord słowa uncategorized
     *
     * @param uncategorizedWord
     */
    fun updateUncategorizedWord(uncategorizedWord: UncategorizedWord) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(COLUMN_UNCATEGORIZEDWORD_ANG, uncategorizedWord.ang)
        values.put(COLUMN_UNCATEGORIZEDWORD_POL, uncategorizedWord.pol)


        db.update(TABLE_UNCATEGORIZEDWORD, values, "$COLUMN_UNCATEGORIZEDWORD_ID = ?",
            arrayOf(uncategorizedWord.id.toString()))
        db.close()
    }

    /**
     * Metoda usuwa rekord uncategorizedword
     *
     * @param homeWord
     */
    fun deleteUncategorizedWord(uncategorizedWord: UncategorizedWord) {

        val db = this.writableDatabase

        db.delete(TABLE_UNCATEGORIZEDWORD, "$COLUMN_UNCATEGORIZEDWORD_ID = ?",
            arrayOf(uncategorizedWord.id.toString()))
        db.close()

    }

    /**
     * Metoda sprawdza czy słowo angielkie uncategorized isteniej czy nie
     *
     * @param ang
     * @return true/false
     */
    fun checkUncategorizedWord(ang: String): Boolean {


        val columns = arrayOf(COLUMN_UNCATEGORIZEDWORD_ID)
        val db = this.readableDatabase


        val selection = "$COLUMN_UNCATEGORIZEDWORD_ANG = ?"


        val selectionArgs = arrayOf(ang)


        /**
         * W tym przypadku funkcja zapytania służy do pobierania rekordów z tabeli uncategorized. Ta funkcja działa tak samo jak, używanie
         * zapytań sql.
         */
        val cursor = db.query(TABLE_UNCATEGORIZEDWORD,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null)


        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if (cursorCount > 0) {
            return true
        }

        return false
    }
    /**
     * Metoda sprawdzająca czy homeword istnieje czy nie
     *
     * @param ang
     * @param pol
     * @return true/false
     */
    fun checkUncategorizedWord(ang: String, pol: String): Boolean {


        val columns = arrayOf(COLUMN_UNCATEGORIZEDWORD_ID)

        val db = this.readableDatabase


        val selection = "$COLUMN_UNCATEGORIZEDWORD_ANG = ? AND $COLUMN_UNCATEGORIZEDWORD_POL = ?"


        val selectionArgs = arrayOf(ang, pol)


        /**
         * W tym przypadku funkcja zapytania służy do pobierania rekordów z tabeli uncategorized. Ta funkcja działa tak samo jak, używanie
         * zapytań sql.
         */
        val cursor = db.query(TABLE_UNCATEGORIZEDWORD,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null)

        val cursorCount = cursor.count
        cursor.close()
        db.close()

        if (cursorCount > 0)
            return true

        return false

    }


    companion object {

        //Wersja bazy danych
        private val DATABASE_VERSION = 1

        //Nazwa bazy dancyh
        private val DATABASE_NAME = "BazaDanych.db"

        /**
         * Tabela user
         */
        //Tabla użytkowników o nazwie user
        private val TABLE_USER = "user"

        //Tabela przechowująca wiersze user
        private val COLUMN_USER_ID = "user_id"
        private val COLUMN_USER_NAME = "user_name"
        private val COLUMN_USER_EMAIL = "user_email"
        private val COLUMN_USER_PASSWORD = "user_password"

        /**
         * Tabela familyword
         */

        //Tabela słów family o nazwie familyword
        private val TABLE_FAMILYWORD = "familyword"

        //Tabela przechowująca wiersze family
        private val COLUMN_FAMILYWORD_ID = "familyword_id"
        private val COLUMN_FAMILYWORD_ANG = "familyword_ang"
        private val COLUMN_FAMILYWORD_POL = "familyword_pol"

        /**
         * Tabela homeword
         */
        //Tabela słów home o nazwie homweword
        private val TABLE_HOMEWORD = "homeword"

        //Tabela przechowująca wiersze home
        private val COLUMN_HOMEWORD_ID = "homeword_id"
        private val COLUMN_HOMEWORD_ANG = "homeword_ang"
        private val COLUMN_HOMEWORD_POL = "homeword_pol"


        /**
         * Tabela uncategorizedword
         */

        //Tabela słów uncategorized o nazwie uncategorizedword
        private val TABLE_UNCATEGORIZEDWORD = "uncategorizedword"

        //Tabela przechowująca wiersze uncategorized
        private val COLUMN_UNCATEGORIZEDWORD_ID = "uncategorizedword_id"
        private val COLUMN_UNCATEGORIZEDWORD_ANG = "uncategorizedword_ang"
        private val COLUMN_UNCATEGORIZEDWORD_POL = "uncategorizedword_pol"

    }
}