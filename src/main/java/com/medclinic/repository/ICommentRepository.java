package com.medclinic.repository;

import com.medclinic.config.hibernate.GenericDAO;
import java.util.List;


public interface ICommentRepository<T, ID> extends GenericDAO {
    List<T> findByUserID(long id);
}
