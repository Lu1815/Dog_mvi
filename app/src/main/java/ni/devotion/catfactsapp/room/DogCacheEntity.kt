package ni.devotion.catfactsapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName =  "perrito")
class DogCacheEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "message")
    var message: String,
    @ColumnInfo(name = "status")
    var status: String
)