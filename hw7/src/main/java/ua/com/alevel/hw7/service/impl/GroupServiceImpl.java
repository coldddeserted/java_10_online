package ua.com.alevel.hw7.service.impl;

import ua.com.alevel.hw7.db.DBResourse;
import ua.com.alevel.hw7.entity.Group;
import ua.com.alevel.hw7.service.GroupService;

import java.util.Collection;

public class GroupServiceImpl implements GroupService {

    private final DBResourse dbResourse = DBResourse.getInstance();
    @Override
    public void create(Group entity) {
        dbResourse.createGroup(entity);
    }

    @Override
    public void update(Group entity) {
        dbResourse.updateGroup(entity);
    }

    @Override
    public void delete(String id) {
        dbResourse.deleteGroup(id);
    }

    @Override
    public Group findById(String id) {
        return dbResourse.findGroupById(id);
    }

    @Override
    public Collection<Group> findAll() {
        return dbResourse.findAllGroups();
    }
}
