package com.johndcoding.demojpa.repositories;

import com.johndcoding.demojpa.entities.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    @Sql("/data.sql")
    public void test(){

        Optional<Task> task = taskRepository.findById(1l);
        assertTrue(task.isPresent());
        assertEquals(1L, task.get().getId());
        assertEquals("Alpha", task.get().getAuthor().getName());

    }

}
