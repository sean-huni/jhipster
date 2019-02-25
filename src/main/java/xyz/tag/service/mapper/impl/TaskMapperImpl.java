package xyz.tag.service.mapper.impl;

import org.springframework.stereotype.Component;
import xyz.tag.domain.Task;
import xyz.tag.service.dto.TaskDTO;
import xyz.tag.service.mapper.TaskMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * PROJECT   : jhipster-tasks
 * PACKAGE   : xyz.tag.service.mapper.impl
 * USER      : sean
 * DATE      : 23-Sat-Feb-2019
 * TIME      : 21:55
 * E-MAIL    : kudzai@bcs.org
 * CELL      : +27-64-906-8809
 */
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task toEntity(TaskDTO dto) {
        final Task taskEntity = new Task();
        taskEntity.setId(dto.getId());
        taskEntity.setName(dto.getName());
        taskEntity.setCompleted(dto.isCompleted());
        taskEntity.setDueDate(dto.getDueDate());
        return taskEntity;
    }

    @Override
    public TaskDTO toDto(Task entity) {
        final TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(entity.getId());
        taskDTO.setName(entity.getName());
        taskDTO.setCompleted(entity.isCompleted());
        taskDTO.setDueDate(entity.getDueDate());
        return taskDTO;
    }

    @Override
    public List<Task> toEntity(List<TaskDTO> dtoList) {
        return dtoList.stream().map(taskDTO -> toEntity(taskDTO)).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> toDto(List<Task> entityList) {
        return entityList.stream().map(task -> toDto(task)).collect(Collectors.toList());
    }
}
