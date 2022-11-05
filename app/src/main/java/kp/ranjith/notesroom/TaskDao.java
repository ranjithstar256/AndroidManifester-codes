package kp.ranjith.notesroom;


import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface TaskDao {

    @Insert
    void insert(Task task);

}