package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import com.medclinic.entity.Comment;

import java.util.List;


public interface ICommentRepository extends GenericDAO<Comment> {
    List<Comment> findByUserID(long id);
}
