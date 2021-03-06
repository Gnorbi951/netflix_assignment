package com.codecool.videoservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Video {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String viewKey;

}
