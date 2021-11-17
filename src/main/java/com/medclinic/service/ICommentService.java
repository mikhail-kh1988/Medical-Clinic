package com.medclinic.service;

import com.medclinic.dto.CreateCommentDto;
import com.medclinic.entity.Comment;
import java.util.List;

public interface ICommentService {

    void createComment(CreateCommentDto dto);
    List<Comment> findCommentByUserID(long id);
    Comment findByID(long ID);

}
