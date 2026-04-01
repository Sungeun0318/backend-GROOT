package com.green.backend.report.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QrShare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
