package com.todos.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
//@ToString
//@EqualsAndHashCode
//@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;
    private int userId;
    //@NonNull
    private String title;
    private String body;
    private LocalDateTime insertDate;
    private boolean completed;

}
