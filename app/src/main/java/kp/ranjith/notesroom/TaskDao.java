package kp.ranjith.notesroom;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao {
    
     @Query("SELECT * FROM task")
     List<Task> getAll();

      @Query("SELECT * FROM task WHERE task LIKE :taskname ")
    Task getdesktn(String taskname);

    
    @Insert
    void insert(Task task);

}
