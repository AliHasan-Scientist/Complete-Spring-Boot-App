package com.backend.myappbackend.payload;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PostDto implements Serializable {
    private final Integer postId;
    private final String title;
    private final String content;
    private final String imageName;
    private final Date addedDate;
}
