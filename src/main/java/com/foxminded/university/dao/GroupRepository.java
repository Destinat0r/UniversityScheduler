package com.foxminded.university.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.foxminded.university.model.Group;

public interface GroupRepository extends CrudRepository<Group, Integer> {

    List<Group> findAll();
}
