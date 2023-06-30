package ezgiyazici.todo.controller.api;

import ezgiyazici.todo.business.dto.TodoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface ITodoGenericsApi<D> extends IPageableAndProfileApp {

    // Spring MVC (Thymeleaf)
    public ResponseEntity<String>  getRoot();

    // ### CRUD ###############################
    // CREATE
    public ResponseEntity<?>  todoServiceCreate(D d);

    // LIST
    public ResponseEntity<List<D>>  todoServiceList();

    // FIND
    public ResponseEntity<?> todoServiceFindById(Long id);

    // DELETE
    public  ResponseEntity<?> todoServiceDeleteById(Long id);

    // UPDATE
    public ResponseEntity<?>  todoServiceUpdateById(Long id, D d);

    ResponseEntity<Page<TodoDto>> todoServicePagination(Pageable pageable, Object d);
}

