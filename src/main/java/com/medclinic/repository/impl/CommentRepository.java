package com.medclinic.repository.impl;

import com.medclinic.entity.Comment;
import com.medclinic.config.hibernate.GenericDAOImpl;
import com.medclinic.repository.ICommentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CommentRepository extends GenericDAOImpl implements ICommentRepository {
    public CommentRepository() {
        this.setEntityClass(Comment.class);
    }

    @Override
    public List findByUserID(long id) {
        CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery();
        Root<Comment> root = criteria.from(Comment.class);
        criteria.select(root).where(builder.equal(root.get("createUser"), id));
        return this.getEntityManager().createQuery(criteria).getResultList();
    }
}
