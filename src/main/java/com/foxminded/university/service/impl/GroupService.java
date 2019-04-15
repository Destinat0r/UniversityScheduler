package com.foxminded.university.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foxminded.university.dao.DaoException;
import com.foxminded.university.dao.GroupRepository;
import com.foxminded.university.model.Group;
import com.foxminded.university.service.EntityService;

@Service
public class GroupService implements EntityService<Group> {

    private GroupRepository groupRepository;
    
    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group create(Group group) {
        groupRepository.save(group);
        return group;
    }

    @Override
    public Group findById(int id) {
        Optional<Group> result = groupRepository.findById(id);
        
        Group group = null;
        
        if (result.isPresent()) {
            group = result.get();
        } else {
            throw new DaoException("Nothing found by id " + id);
        }
        
        return group;
    }

    @Override
    public List<Group> findAll() {

        return groupRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        
    }

}
