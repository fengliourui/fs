package database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import database.Sum;

@Dao
public interface SumDao {
    @Insert
    void insert(Sum sum);//插入

    @Query("SELECT * FROM Sum")
    List<Sum> getAllSums();//获取

    @Delete
    void deleteUser(Sum sum);//删除

    @Query("SELECT * FROM Sum WHERE placeid = :placeId")
    Sum getSumByPlaceId(String placeId);//查找

    @Update
    void updateSum(Sum sum);//对已有数据进行更新

    @Query("SELECT * FROM Sum ORDER BY id DESC LIMIT 1")
    Sum getLatestSum();//按id逆序排序，输出最后一个数据，即最新数据

}
