package com.karthikr.album_assignment.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.karthikr.album_assignment.repository.FakeAlbumRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AlbumViewModelTest {
    private lateinit var albumViewModel: AlbumViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        albumViewModel = AlbumViewModel(FakeAlbumRepository())
    }

    @Test
    fun getAllAlbumsShouldReturnAllAlbums() {
        val allAlbumsLiveData = albumViewModel.getAllAlbums()

        val actualAlbums = allAlbumsLiveData.value

        assertEquals(actualAlbums?.get(0)?.userId, 1)
        assertEquals(actualAlbums?.get(0)?.id, 1)
        assertEquals(actualAlbums?.get(0)?.title, "Album1")

        assertEquals(actualAlbums?.get(1)?.userId, 1)
        assertEquals(actualAlbums?.get(1)?.id, 2)
        assertEquals(actualAlbums?.get(1)?.title, "Album2")
    }
}