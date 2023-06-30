package ezgiyazici.todo.controller.api;

import ezgiyazici.todo.business.dto.TodoDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface IPageableAndProfileApp {

    // Bütün veri eklesin
    public ResponseEntity<List<TodoDto> > speedDataService();

    // Bütün veriyi silsin
    public ResponseEntity<String>  allDeleteService();

    // App Information
    public ResponseEntity<String>  appInformationService(HttpServletRequest request, HttpServletResponse response);

    // ### PAGEABLE ###############################
    // Lıst: pageable
    public ResponseEntity<List<TodoDto>> todoServiceAllList();

    // Lıst: Page page,size
    public ResponseEntity<Page<TodoDto>>  todoServicePagination(int currentPage, int pageSize);

    // Lıst: page, pageable
    public ResponseEntity<Page<TodoDto>>  todoServicePagination(Pageable pageable,TodoDto blogDto);
}

