/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.hilt.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * Data access object to query the database.
 */

/*
However, because LogDao is an interface, we cannot annotate
its constructor with @Inject as interfaces don't have one.
How can we tell Hilt how to provide instances of this type?

Modules are used to add bindings to Hilt, or in other words,
to tell Hilt  how to provide instances of different types.
In Hilt modules,
you include bindings for types that cannot be constructor
injected such as interfaces or classes that are not contained
in your project. An example of this is OkHttpClient -
you need to use its builder to create an instance.
 */

@Dao
interface LogDao {

    @Query("SELECT * FROM logs ORDER BY id DESC")
    fun getAll(): List<Log>

    @Insert
    fun insertAll(vararg logs: Log)

    @Query("DELETE FROM logs")
    fun nukeTable()
}
