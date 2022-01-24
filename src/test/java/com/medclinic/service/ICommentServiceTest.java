package com.medclinic.service;

import com.medclinic.config.ApplicationConfigurationTest;
import com.medclinic.config.HibernateConfigurationTest;
import com.medclinic.dto.CreateCommentDto;
import com.medclinic.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(classes = {ApplicationConfigurationTest.class, HibernateConfigurationTest.class})
class ICommentServiceTest {

    @Autowired
    private ICommentService commentService;
    private Comment comment;

    @Test
    @DisplayName("This test find comments by ID")
    void findByID() {

        CreateCommentDto dto = new CreateCommentDto();
        dto.setCreateBy(1);
        dto.setDescription("Test comment");

        commentService.createComment(dto);

        assertNull(commentService.findByID(1));
    }

    @Test
    @DisplayName("This test find comment with not exist id")
    void findNotExistID(){
        assertNull(commentService.findByID(32323));
    }
}