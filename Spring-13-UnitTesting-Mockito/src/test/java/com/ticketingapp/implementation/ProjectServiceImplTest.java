package com.ticketingapp.implementation;

import com.ticketingapp.dto.ProjectDTO;
import com.ticketingapp.entity.Project;
import com.ticketingapp.mapper.MapperUtil;
import com.ticketingapp.mapper.ProjectMapper;
import com.ticketingapp.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;
    @Mock
    ProjectMapper projectMapper;

    @InjectMocks
    ProjectServiceImpl projectServiceImpl;

    @Test
    void getByProjectCode() {
        Project project = new Project();
        ProjectDTO projectDTO = new ProjectDTO();
        when(projectRepository.findByProjectCode("PR01")).thenReturn(project);
        when(projectMapper.convertToDTO(project)).thenReturn(projectDTO);
        ProjectDTO projectDTO1 = projectServiceImpl.getByProjectCode("PR01");
        verify(projectRepository).findByProjectCode(Mockito.anyString());
        verify(projectMapper).convertToDTO(Mockito.any(Project.class));
        assertNotNull(projectDTO1);
    }

    @Test
    void getByProjectCode_exception_test() {
        when(projectRepository.findByProjectCode("")).thenThrow(new RuntimeException("Project not found"));
        Throwable exception = assertThrows(RuntimeException.class, () -> projectServiceImpl.getByProjectCode(""));
        verify(projectRepository).findByProjectCode(Mockito.anyString());
        assertEquals(exception.getMessage(), "Project not found");
    }

    @Test
    void save() {
        ProjectDTO projectDTO = new ProjectDTO();
        Project project = new Project();
        when(projectMapper.convertToEntity(projectDTO)).thenReturn(project);
        when(projectRepository.save(project)).thenReturn(project);
        projectServiceImpl.save(projectDTO);
        verify(projectRepository).save(project); //verify - is used to verify if mock has been executed 1 time
    }

}