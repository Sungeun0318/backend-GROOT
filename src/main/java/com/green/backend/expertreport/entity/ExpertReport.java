package com.green.backend.expertreport.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpertReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tree_id;

    @Column()
    private int detail_id;

    @Column( nullable = false, length = 20)
    private String tree_type;

    @Column(nullable = false)
    private int dbh;

    @Column(nullable = false)
    private String tree_status;

    @Column(columnDefinition = "LONGTEXT")
    private String picture;

    @Column(nullable = false)
    private int height;

    @Column(nullable = false)
    private int width;

}
