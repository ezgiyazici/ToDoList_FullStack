package ezgiyazici.todo.business.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITodoGenericsService<D, E> extends IProfileApp {

    // ### Model Mapper ###############################
    public D EntityToDto(E e);

    public E DtoToEntity(D d);

    // ### CRUD ###############################
    // CREATE
    public D todoServiceCreate(D d);

    // LIST
    public List<D> todoServiceList();

    // FIND
    public D todoServiceFindById(Long id);

    // DELETE
    public D todoServiceDeleteById(Long id);

    // UPDATE
    public D todoServiceUpdateById(Long id, D d);

    // ### PAGEABLE ###############################
    // Lıst: pageable
    public List<D> todoServiceAllList();

    // Lıst: Page page,size
    public Page<E> todoServicePagination(int currentPage, int pageSize);

    // Lıst: page, pageable
    public Page<E> todoServicePagination(Pageable pageable,D d);
}

