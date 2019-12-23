package ru.tropin.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import ru.tropin.model.Project;

import javax.validation.constraints.NotNull;

@Data
public class BugCreationDto {

    @NotNull
    private String title;
    @NotNull
    private String description;

    @JsonIgnore
    private Project project;

}
