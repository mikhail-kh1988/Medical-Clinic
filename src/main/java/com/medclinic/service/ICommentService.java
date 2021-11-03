package com.medclinic.service;

import com.medclinic.dto.CreateCommentDTO;
import com.medclinic.entity.Comment;
import java.util.List;

public interface ICommentService {

    void createComment(CreateCommentDTO dto);
    List<Comment> findCommentByUserID(long id);
    Comment findByID(long ID);

}
