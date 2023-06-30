package ezgiyazici.todo.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="todo")
public class TodoEntity extends BaseEntity  implements Serializable {
    @Column(name = "header",columnDefinition = "varchar(255) default 'header girmediniz'")
    private String header;

    @Column(name = "status",columnDefinition = "integer default 0")
    private int status;

}
