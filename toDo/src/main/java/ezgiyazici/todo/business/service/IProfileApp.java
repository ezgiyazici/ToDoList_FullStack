package ezgiyazici.todo.business.service;


import ezgiyazici.todo.business.dto.TodoDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface IProfileApp {

    // Bütün veri eklesin
    public List<TodoDto> speedDataService();

    // Bütün veriyi silsin
    public String allDeleteService();

    // App Information
    public String appInformationService(HttpServletRequest request, HttpServletResponse response);
}