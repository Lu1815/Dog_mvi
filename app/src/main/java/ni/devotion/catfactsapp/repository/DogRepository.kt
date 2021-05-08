package ni.devotion.catfactsapp.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ni.devotion.catfactsapp.model.Dog
import ni.devotion.catfactsapp.retrofit.DogRetrofit
import ni.devotion.catfactsapp.retrofit.NetworkMapper
import ni.devotion.catfactsapp.room.CacheMapper
import ni.devotion.catfactsapp.room.DogDao
import ni.devotion.catfactsapp.utils.DataState

class CatRepository constructor(
    private val dogDao: DogDao,
    private val dogRetrofit: DogRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {
    suspend fun getDogs(): Flow<DataState> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val dogData = dogRetrofit.get()
            val dogMap = networkMapper.mapFromEntityList(dogData)
            for (tempDog in dogMap){
                dogDao.insert(cacheMapper.mapToEntity(tempDog))
            }
            val cacheDog = dogDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cacheDog)))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }
}