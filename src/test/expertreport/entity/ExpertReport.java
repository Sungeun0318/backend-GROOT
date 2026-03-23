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
    private int detail_id;
    private String tree_type;
    private int dbh;
    private String tree_status;


}
