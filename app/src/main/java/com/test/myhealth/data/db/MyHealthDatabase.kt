package com.test.myhealth.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.test.myhealth.data.storage.modelDb.*

@Database(
    version = 10, entities = [
        ArticleEntity::class,
        DreamEntity::class,
        DreamInfoEntity::class,
        FavoriteArticlesEntity::class,
        FoodEntity::class,
        GenderEntity::class,
        MedicineEntity::class,
        MedicineInfoEntity::class,
        MedicineInfoTimeEntity::class,
        MentalConditionEntity::class,
        MentalInfoEntity::class,
        PhysicalConditionEntity::class,
        PhysicalInfoEntity::class,
        PressureEntity::class,
        RatingEntity::class,
        RoleEntity::class,
        UserEntity::class,
        UserFavoriteArticlesEntity::class,
        UserParameterEntity::class,
        WaterEntity::class,
        WeightEntity::class
    ],
    exportSchema = true
)
abstract class MyHealthDatabase : RoomDatabase() {
    abstract fun myHealthDao(): MyHealthDao

    companion object {
        @Volatile
        var INSTANCE: MyHealthDatabase? = null

        @Synchronized
        fun getInstance(context: Context): MyHealthDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    MyHealthDatabase::class.java,
                    "myhealth.db"
                ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
            }
            return INSTANCE as MyHealthDatabase
        }
    }
}