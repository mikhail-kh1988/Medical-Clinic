package com.medclinic.repository.impl;

import com.medclinic.hibernate.GenericDAOImpl;
import com.medclinic.repository.ICommentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository extends GenericDAOImpl implements ICommentRepository {
    public CommentRepository() {
        this.setEntityClass(this.getClass());
    }

    @Override
    public List findByUserID(long id) {
        return null;
    }
}
