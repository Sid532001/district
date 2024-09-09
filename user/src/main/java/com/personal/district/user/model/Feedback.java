package com.personal.district.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Feedback {
    private String eventId;
    private int rating;
    private String comment;

}