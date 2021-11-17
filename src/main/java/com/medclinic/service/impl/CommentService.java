package com.medclinic.service.impl;

import com.medclinic.dto.CreateCommentDto;
import com.medclinic.entity.Comment;
import com.medclinic.entity.User;
import com.medclinic.repository.ICommentRepository;
import com.medclinic.repository.IUserRepository;
import com.medclinic.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public class CommentService implements ICommentService {

    @Autowired
    private ICommentRepository commentRepository;

    @Autowired
    private IUserRepository userRepository;

    @Transactional
    @Override
    public void createComment(CreateCommentDto dto) {
        User createByUser = (User) userRepository.findByID(dto.getCreateBy());

        Comment comment = new Comment();
        comment.setCreateUser(createByUser);
        comment.setDescription(dto.getDescription());
        comment.setCreateDate(LocalDate.now());

        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findCommentByUserID(long id) {
        return commentRepository.findByUserID(id);
    }

    @Override
    public Comment findByID(long ID) {
        return (Comment) commentRepository.findByID(ID);
    }
}
