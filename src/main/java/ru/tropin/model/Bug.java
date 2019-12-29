package ru.tropin.model;

import lombok.*;
import ru.tropin.repository.ProjectRepository;
import ru.tropin.util.RegularExpHandler;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString(exclude = "project")
@NamedQuery(name="Bug.fetchById", query = "select b from Bug b where b.project = :id")
@Table(name = "bug")
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @ManyToOne()
    @JoinColumn(name = "project_id")
    private Project project;

    @NotNull
    private String description;

    public Bug(Map<String, String> rqBody, ProjectRepository projectRepository) {
        Long project_id = Long.valueOf(RegularExpHandler.getSubstring("^[0-9]*", rqBody.get("project_id_name")) );
        this.title = rqBody.get("title");
        this.description = rqBody.get("description");
        this.project = projectRepository.findOne(project_id);
    }

}
