package dev.matheuslf.desafio.inscritos.Repository;

import dev.matheuslf.desafio.inscritos.entity.Task;
import dev.matheuslf.desafio.inscritos.enums.StatusTask;
import dev.matheuslf.desafio.inscritos.enums.PriorityTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT p FROM Task p WHERE " +
            "(:title IS NULL OR LOWER(p.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
            "(:statusTask IS NULL OR p.StatusTask = :statusTask) AND " +
            "(:priorityTask IS NULL OR p.PriorityTask = :priorityTask)")
    List<Task> buscarComFiltros(@Param("title") String title,
                                @Param("statusTask") StatusTask statusTask,
                                @Param("priorityTask") PriorityTask priorityTask);
}
