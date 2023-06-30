package ezgiyazici.todo.data.repository;

import ezgiyazici.todo.data.entity.TodoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ITodoRepository extends CrudRepository<TodoEntity, Long> {

    TodoEntity findByHeader(String header);

    // Query
    @Query("select b from TodoEntity b")
    List<TodoEntity> myTodoList();
}
