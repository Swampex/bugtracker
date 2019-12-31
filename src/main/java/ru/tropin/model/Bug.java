package ru.tropin.model;

import lombok.*;
import ru.tropin.repository.ProjectRepository;

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
        this.title = rqBody.get("title");
        this.description = rqBody.get("description");
        String projectId = rqBody.get("project_id");
        if(!projectId.equals("")) {
            this.project = projectRepository.findOne(Long.valueOf(rqBody.get("project_id")));
        }
    }

//    public static Bug from(Map<String, String> rqBody, ProjectRepository projectRepository) {
//
//        Bug bug = Bug.builder()
//                .title(rqBody.get("title"))
//                .description(rqBody.get("description"))
//                .
//    }

}
