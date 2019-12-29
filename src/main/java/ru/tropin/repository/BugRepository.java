package ru.tropin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.tropin.model.Bug;
import ru.tropin.model.Project;

import java.util.List;

public interface BugRepository extends JpaRepository<Bug, Long> {

    List<Bug> fetchById(@Param("id") Project project);

//    @Modifying
//    @Query("update bug b set b.title = :title, b.description = : description " +
//            "where id = :id")
//    void updateBugById(@Param("id") String id, @Param("description") String description,
//                       @Param("title") String title),

}
