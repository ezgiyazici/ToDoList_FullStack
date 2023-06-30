package ezgiyazici.todo.business.dto;

import ezgiyazici.todo.audit.AuditingAwareBaseDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

// LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2

public class TodoDto extends AuditingAwareBaseDto implements Serializable {
    public static final Long serialVersionUID = 1L;

    @NotEmpty(message = "{blog.header.validation.constraints.NotNull.message}")
    @Size(min = 10, message = "{blog.header.least.validation.constraints.NotNull.message}")
    private String header;

    @NotEmpty(message = "{blog.header.validation.constraints.NotNull.message}")
    private int status;

}
