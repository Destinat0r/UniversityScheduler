package com.foxminded.university.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foxminded.university.dao.GroupRepository;
import com.foxminded.university.domain.Group;
import com.foxminded.university.service.EntityService;

@Service
public class GroupService implements EntityService<Group> {

    private GroupRepository groupRepository;
    
    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group create(Group t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Group findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Group update(Group t) {
        // TODO Auto-generated method stub
        return null;
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
