package com.personal.district.admin.model;

import jakarta.annotation.Generated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private Date date;
    private String venue;
    private String description;
    private int totalTickets;
    private int availableTickets;
    private List<String> images;
    private String createdBy;
    private Category category;

}
