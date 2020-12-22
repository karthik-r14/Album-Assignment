package com.karthikr.album_assignment

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.karthikr.album_assignment.adapter.AlbumAdapter.AlbumViewHolder
import com.karthikr.album_assignment.model.Album
import com.karthikr.album_assignment.view.MainActivity
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @get:Rule
    val activitytRule = ActivityScenarioRule(MainActivity::class.java)

    val LIST_ITEM_IN_TEST = 0

    @Test
    fun albumRecyclerViewIsVisibleOnAppLaunchAndGivenAlbumIsPresentAtGivenPosition() {
        val expectedAlbum = Album(1, 1, "quidem molestiae enim")

        Thread.sleep(10000)

        onView(withId(R.id.album_list)).check(matches(isDisplayed()))

        onView(withId(R.id.album_list))
            .perform(
                RecyclerViewActions.scrollToPosition<AlbumViewHolder>(LIST_ITEM_IN_TEST)
            )

        onView(allOf(withId(R.id.album_title), withText(expectedAlbum.title)))
        onView(allOf(withId(R.id.user_id), withText(expectedAlbum.id)))
        onView(allOf(withId(R.id.album_id), withText(expectedAlbum.userId)))
    }
}