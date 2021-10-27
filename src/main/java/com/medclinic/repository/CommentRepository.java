package com.medclinic.repository;

import com.medclinic.hibernate.GenericDAO;
import java.util.List;


public interface CommentRepository<T, ID> extends GenericDAO {
    List<T> findByUserID(long id);
}
