package com.example.lumet13.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.lumet13.db.userModel

class DBHandler // creating a constructor for our database handler.
    (context: Context?) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    // below method is for creating a database by running a sqlite query
    override fun onCreate(db: SQLiteDatabase) {
        // on below line we are creating an sqlite query and we are
        // setting our column names along with their data types.
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + AGE_COL + " TEXT,"
                + TOKEN_COL + " TEXT)")

        // at last we are calling a exec sql method to execute above sql query
        db.execSQL(query)
    }

    // this method is use to add new course to our sqlite database.
    fun addNewUser(
        courseName: String?,
        courseAge: String?,
        courseToken: String?,

        ) {

        val db = this.writableDatabase

        val values = ContentValues()

        values.put(NAME_COL, courseName)
        values.put(AGE_COL, courseAge)
        values.put(TOKEN_COL, courseToken)

        db.insert(TABLE_NAME, null, values)

        db.close()
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    companion object {
        private const val DB_NAME = "coursedb"

        private const val DB_VERSION = 1

        private const val TABLE_NAME = "mycourses"

        private const val ID_COL = "id"

        private const val NAME_COL = "name"

        private const val AGE_COL = "age"

        private const val TOKEN_COL = "token"

    }

    // we have created a new method for reading all the courses.
    fun readUsers(): ArrayList<userModel>? {
        // on below line we are creating a database for reading our database.
        val db = this.readableDatabase

        // on below line we are creating a cursor with query to read data from database.
        val cursorCourses: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        // on below line we are creating a new array list.
        val courseModelArrayList: ArrayList<userModel> = ArrayList()

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModelArrayList.add(
                    userModel(
                        cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3),
                        cursorCourses.getString(4),
                        cursorCourses.getString(5),
                        cursorCourses.getString(6),
                        cursorCourses.getString(7),
                        cursorCourses.getString(8)
                    )
                )
            } while (cursorCourses.moveToNext())
            // moving our cursor to next.
        }
        // at last closing our cursor and returning our array list.
        cursorCourses.close()
        return courseModelArrayList
    }

    fun updateUsers(
        originalCourseName: String, courseName: String?, courseAge: String?,
        courseToken: String?
    ) {

        // calling a method to get writable database.
        val db = this.writableDatabase
        val values = ContentValues()

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, courseName)
        values.put(AGE_COL, courseAge)
        values.put(TOKEN_COL, courseToken)

        // on below line we are calling a update method to update
        // our database and passing our values.
        // and we are comparing it with name of our course
        // which is stored in original name variable.
        db.update(TABLE_NAME, values, "name=?", arrayOf(originalCourseName))
        db.close()
    }

    // on below line creating a function to delete course
    fun deleteCourse(courseName: String) {
        // on below line we are creating
        // a variable to write our database.
        val db = this.writableDatabase

        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        db.delete(TABLE_NAME, "name=?", arrayOf(courseName))
        db.close()
    }
}
