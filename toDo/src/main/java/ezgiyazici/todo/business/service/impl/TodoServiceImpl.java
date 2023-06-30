package ezgiyazici.todo.business.service.impl;

import ezgiyazici.todo.bean.ModelMapperBean;
import ezgiyazici.todo.business.dto.TodoDto;
import ezgiyazici.todo.business.service.ITodoGenericsService;
import ezgiyazici.todo.data.entity.TodoEntity;
import ezgiyazici.todo.data.repository.ITodoRepository;
import ezgiyazici.todo.exception.BadRequestException;
import ezgiyazici.todo.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

// LOMBOK
@RequiredArgsConstructor // Injection
@Log4j2

// SERVICE
@Service // Asıl iş Yükünü yapan yer
public class TodoServiceImpl implements ITodoGenericsService<TodoDto, TodoEntity> {

    private final ModelMapperBean modelMapperBean;
    private final ITodoRepository iTodoRepository;

    // ### Model Mapper ###############################
    @Override
    public TodoDto EntityToDto(TodoEntity todoEntity) {
        return modelMapperBean.modelMapperMethod().map(todoEntity, TodoDto.class);
    }

    @Override
    public TodoEntity DtoToEntity(TodoDto todoDto) {
        return modelMapperBean.modelMapperMethod().map(todoDto, TodoEntity.class);
    }

    // ### CRUD ###############################
    // CREATE
    @Transactional // Create, Delete, Update
    public TodoDto todoServiceCreate(TodoDto todoDto) {
        if (todoDto != null) {
            TodoEntity todoEntityModel = DtoToEntity(todoDto);
            TodoEntity todoEntity = iTodoRepository.save(todoEntityModel);
            todoDto.setId(todoEntity.getId());
            todoDto.setSystemDate(todoDto.getSystemDate());
            todoDto.setStatus(0);
        } else if (todoDto == null)
            throw new BadRequestException("todoDto yoktur");
        return todoDto;
    }

    // LIST
    @Override
    public List<TodoDto> todoServiceList() {
        Iterable<TodoEntity> todoEntityIterable = iTodoRepository.findAll();
        List<TodoDto> list = new ArrayList<>();
        for (TodoEntity entity : todoEntityIterable) {
            TodoDto todoDto = EntityToDto(entity);
            list.add(todoDto);
        }
        return list;
    }

    // FIND
    @Override
    public TodoDto todoServiceFindById(Long id) {
        TodoEntity todoEntity = null;
        if (id != null) {
            todoEntity = iTodoRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(id + " nolu ID bulunamadı"));
        } else if (id == null)
            throw new BadRequestException(id + "Todo Dto Null Geldi"); // 400
            throw new BadRequestException(id + "Todo Dto Null Geldi"); // 400
    }

    // DELETE
    @Transactional // Create, Delete, Update
    @Override
    public TodoDto todoServiceDeleteById(Long id) {
        TodoDto todoDtoDeleteFind = todoServiceFindById(id);
        TodoEntity todoEntity = DtoToEntity(todoDtoDeleteFind);
        iTodoRepository.delete(todoEntity);
        return todoDtoDeleteFind;
    }

    // Update
    // CommandLineRunner

    // UPDATE
    @Transactional // Create, Delete, Update
    @Override
    public TodoDto todoServiceUpdateById(Long id, TodoDto todoDto) {
        TodoEntity todoEntity = DtoToEntity(todoServiceFindById(id));
        if (todoEntity != null) {
            todoEntity.setId(id);
            todoEntity.setHeader(todoDto.getHeader());
            iTodoRepository.save(todoEntity);
            todoDto.setId(todoEntity.getId());
            todoDto.setSystemDate(todoDto.getSystemDate());
        }
        return EntityToDto(todoEntity);
    }

    // ### PAGEABLE ###################################################################
    // Lıst: pageable
    @Override
    public List<TodoDto> todoServiceAllList() {
        Iterable<TodoEntity> todoEntityPage = iTodoRepository.findAll();
        List<TodoDto> list = new ArrayList<>();
        for (TodoEntity entity : todoEntityPage) {
            TodoDto todoDto = EntityToDto(entity);
            list.add(todoDto);
        }
        return list;
    }

    @Override
    public Page<TodoEntity> todoServicePagination(int currentPage, int pageSize) {
        return null;
    }

    @Override
    public Page<TodoEntity> todoServicePagination(Pageable pageable, TodoDto todoDto) {
        return null;
    }

    // ### PROFILE ########################################################################
    // ÇOKLU VERİ EKLE
    @Override
    public List<TodoDto> speedDataService() {
        List<TodoDto> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            TodoDto todoDto = TodoDto.builder()
                    .header("header " + i)
                    .build();
            todoServiceCreate(todoDto);
            list.add(todoDto);
        }
        return list;
    }

    // ÇOKLU VERİ SİL
    @Override
    public String allDeleteService() {
        iTodoRepository.deleteAll();
        log.info("Silindi");
        return "Silindi ";
    }

    // APP INFO
    @Override
    public String appInformationService(HttpServletRequest request, HttpServletResponse response) {
        // URL URI
        // relative Path, absolute Path
        String URI = request.getRequestURI();
        String LOCALHOST = request.getLocalAddr();
        String SESSION = request.getSession().toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(URI).append(" ").append(LOCALHOST).append(" ").append(SESSION);
        return stringBuilder.toString();
    }
} //end class
