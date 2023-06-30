package ezgiyazici.todo.controller.api.impl;


import ezgiyazici.todo.business.dto.TodoDto;
import ezgiyazici.todo.business.service.ITodoGenericsService;
import ezgiyazici.todo.controller.api.ITodoGenericsApi;
import ezgiyazici.todo.error.ApiResult;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// LOMBOK
@RequiredArgsConstructor //Injection
@Log4j2

// API
@RestController
@CrossOrigin(origins = TodoApiImpl.FRONTEND_URL) // CORS
@RequestMapping("/todo/api/v1")
public class TodoApiImpl implements ITodoGenericsApi<TodoDto> {
    public static final String FRONTEND_URL="";
    // INJECTION
    private final ITodoGenericsService iTodoGenericsService;

    //ERROR
    private ApiResult apiResult;

    // ### ROOT ###############################
    // localhost:3333
    // localhost:3333/index
    @Override
    @GetMapping({"/", "/index"})
    public ResponseEntity<String> getRoot() {
        return ResponseEntity.ok("index");
    }

    // SPEED
    // localhost:3333/todo/api/v1/speed/data
    @GetMapping("/speed/data")
    @Override
    public ResponseEntity<List<TodoDto>> speedDataService() {
        return ResponseEntity.ok(iTodoGenericsService.speedDataService());
    }

    // localhost:3333/todo/api/v1/all/delete
    @GetMapping("/all/delete")
    @Override
    public ResponseEntity<String> allDeleteService() {
        return ResponseEntity.ok(iTodoGenericsService.allDeleteService());
    }

    // localhost:3333/todo/api/v1/app/information
    @GetMapping("/app/information")
    @Override
    public ResponseEntity<String> appInformationService(HttpServletRequest request, HttpServletResponse response) {
        return ResponseEntity.ok(iTodoGenericsService.appInformationService(request,response));
    }

    // ### CRUD ###############################
    // CREATE
    // localhost:3333/todo/api/v1/create
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> todoServiceCreate(@Valid @RequestBody TodoDto todoDto) {
        return ResponseEntity.ok(iTodoGenericsService.todoServiceCreate(todoDto));
    }

    // LIST
    // localhost:3333/todo/api/v1/list
    @Override
    @GetMapping(value = "/list")
    public ResponseEntity<List<TodoDto>> todoServiceList() {
        return ResponseEntity.ok(iTodoGenericsService.todoServiceAllList());
    }

    // FIND
    // localhost:3333/todo/api/v1/find
    // localhost:3333/todo/api/v1/find/0
    // localhost:3333/todo/api/v1/find/1
    @Override
    @GetMapping({"/find", "/find/{id}"})
    public ResponseEntity<?> todoServiceFindById(@PathVariable(name = "id", required = false) Long id) {
        if (id == null) {
            log.error("Todo Api Null Pointer Exception Geldi");
            throw new NullPointerException(id + " Todo Api Null Veri Geldi");
        }
        if (id == 0) {
            log.error("Todo Api 0 badrequest Geldi");
            //(int status, String error, String message, String path)
            apiResult = new ApiResult(400, "bad Request", " Kötü İstek", "/todo/api/v1/find/0");
            return ResponseEntity.ok(apiResult);
        }
        return ResponseEntity.ok(iTodoGenericsService.todoServiceFindById(id));
    }

    // DELETE
    // localhost:3333/todo/api/v1/delete/1
    @Override
    @DeleteMapping({"/delete", "/delete/{id}"})
    public ResponseEntity<?> todoServiceDeleteById(@PathVariable(name = "id", required = false) Long id) {
        return ResponseEntity.ok(iTodoGenericsService.todoServiceDeleteById(id));
    }

    // UPDATE
    // localhost:3333/todo/api/v1/update/1
    @Override
    @PutMapping({"/update", "/update/{id}"})
    public ResponseEntity<?> todoServiceUpdateById(
            @PathVariable(name = "id", required = false) Long id,
            @Valid @RequestBody TodoDto todoDto) {
        todoDto.setId(id);
        return ResponseEntity.ok(iTodoGenericsService.todoServiceUpdateById(id,todoDto));
    }

    /////////////////
    // PAGE, PAGEABLE
    @Override
    public ResponseEntity<List<TodoDto>> todoServiceAllList() {
        return null;
    }

    @Override
    public ResponseEntity<Page<TodoDto>> todoServicePagination(int currentPage, int pageSize) {
        return null;
    }

    @Override
    public ResponseEntity<Page<TodoDto>> todoServicePagination(Pageable pageable, TodoDto todoDto) {
        return null;
    }

    @Override
    public ResponseEntity<Page<TodoDto>> todoServicePagination(Pageable pageable, Object d) {
        return null;
    }
}

