package kp.ranjith.notesroom;


import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface TaskDao {
    
     @Query("SELECT * FROM task")
    List<Task> getAll();

    @Insert
    void insert(Task task);

}
