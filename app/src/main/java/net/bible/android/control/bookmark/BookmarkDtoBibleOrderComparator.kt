/*
 * Copyright (c) 2020 Martin Denham, Tuomas Airaksinen and the And Bible contributors.
 *
 * This file is part of And Bible (http://github.com/AndBible/and-bible).
 *
 * And Bible is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * And Bible is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with And Bible.
 * If not, see http://www.gnu.org/licenses/.
 *
 */
package net.bible.android.control.bookmark

import net.bible.android.control.versification.sort.VerseRangeComparator
import net.bible.android.database.bookmarks.BookmarkEntities.Bookmark
import java.util.*

/**
 * Complex comparison of dtos ensuring the best v11n is used for each comparison.
 *
 * @author Martin Denham [mjdenham at gmail dot com]
 */

class BookmarkBibleOrderComparator(bookmarkDtos: List<Bookmark>) : Comparator<Bookmark> {
    private val convertibleVerseRangeComparator
		= VerseRangeComparator.Builder().withBookmarks(bookmarkDtos).build()
	override fun compare(o1: Bookmark, o2: Bookmark): Int {
        return convertibleVerseRangeComparator.compare(o1, o2)
    }

}
