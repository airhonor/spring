package com.honorzhang.postgresql.service.impl;


import com.honorzhang.postgresql.mapper.PeopleMapper;
import com.honorzhang.postgresql.model.People;
import com.honorzhang.postgresql.service.PeopleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：zgr
 * @date ：Created in 2019/6/10
 */
@Service
public class PeopleServiceImpl implements PeopleService {
    private final PeopleMapper peopleMapper;

    public PeopleServiceImpl(PeopleMapper peopleMapper) {
        this.peopleMapper = peopleMapper;
    }

    @Override
    public List<People> findAll() {
        return peopleMapper.selectAll();
    }

    @Override
    public People findById(Long id) {
        return peopleMapper.findById(id);
    }

    @Override
    public void updatePeople(People people) {
        peopleMapper.updatePeople(people);

    }

    @Override
    public void deletePeople(Long id) {
        peopleMapper.deletePeople(id);
    }

    @Override
    public void addPeople(People people) {
        peopleMapper.addPeople(people);
    }

    @Override
    public List<People> findByCondition(People people) {
        return peopleMapper.findByCondition(people);
    }
}
