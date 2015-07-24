package im.tox.antox.utils

import java.lang.Iterable
import java.util.concurrent.TimeUnit

import android.content.ContentValues
import android.database.Cursor
import com.squareup.sqlbrite.BriteDatabase
import com.squareup.sqlbrite.SqlBrite.Query
import rx.Observable

class BriteScalaDatabase {
  private var db: BriteDatabase = _

  def beginTransaction(): Unit = db.beginTransaction()

  def close(): Unit = db.close()

  def createQuery(table: String, sql: String, args: String*): Observable[Query] = db.createQuery(table, sql, args)

  def createQuery(tables: Iterable[String], sql: String, args: String*): Observable[Query] = db.createQuery(tables, sql, args)

  def delete(table: String, whereClause: String, whereArgs: String*): Int = db.delete(table, whereClause, whereArgs)

  def endTransaction(): Unit = db.endTransaction()

  def insert(table: String, values: ContentValues): Long = db.insert(table, values)

  def insert(table: String, values: ContentValues, conflictAlgorithm: Int): Long = db.insert(table, values, conflictAlgorithm)

  def query(sql: String, args: String*): Cursor = db.query(sql, args)

  def setLoggingEnabled(enabled: Boolean): Unit = db.setLoggingEnabled(enabled)

  def setTransactionSuccessful(): Unit = db.setTransactionSuccessful()

  def update(table: String, values: ContentValues, conflictAlgorithm: Int, whereClause: String, whereArgs: String*): Int = db.update(table, values, conflictAlgorithm, whereClause, whereArgs)

  def update(table: String, values: ContentValues, whereClause: String, whereArgs: String*): Int = db.update(table, values, whereClause, whereArgs)

  def yieldIfContendedSafely(): Boolean = db.yieldIfContendedSafely()

  def yieldIfContendedSafely(sleepAmount: Long, sleepUnit: TimeUnit): Boolean = db.yieldIfContendedSafely(sleepAmount, sleepUnit)
}