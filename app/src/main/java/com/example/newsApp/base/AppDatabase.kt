package com.example.newsApp.base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsApp.feature.bookmarks.data.local.BookmarkEntity
import com.example.newsApp.feature.bookmarks.data.local.BookmarksDao

@Database(entities = [BookmarkEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookmarksDao(): BookmarksDao
}