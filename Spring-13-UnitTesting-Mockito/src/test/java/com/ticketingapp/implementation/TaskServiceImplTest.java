package com.ticketingapp.implementation;

import com.ticketingapp.dto.TaskDTO;
import com.ticketingapp.entity.Task;
import com.ticketingapp.mapper.MapperUtil;
import com.ticketingapp.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    TaskRepository taskRepository;
    @Mock
    MapperUtil mapperUtil;

    @InjectMocks
    TaskServiceImpl taskServiceImpl;

    @ParameterizedTest
    @ValueSource(longs = {1L,2L,3L})
    void findByIdTest(long arg) {
        Task task = new Task();
        when(taskRepository.findById(arg)).thenReturn(Optional.of(task));
        when(mapperUtil.convert(task, new TaskDTO())).thenReturn(new TaskDTO());
        taskServiceImpl.findById(arg);
        verify(taskRepository.findById(arg));
    }

    @Test
    void findByIdBddTest() {
        //given
        Task task = new Task();
        given(taskRepository.findById(Mockito.anyLong())).willReturn(Optional.of(task));
        given(mapperUtil.convert(task, new TaskDTO())).willReturn(new TaskDTO());
        //when
        taskServiceImpl.findById(Mockito.anyLong());
        //then
        then(taskRepository).should().findById(Mockito.anyLong());
        then(taskRepository).should(never()).findById(-5L);
    }

}