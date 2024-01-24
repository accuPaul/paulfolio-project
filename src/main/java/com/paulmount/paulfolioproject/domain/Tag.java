package com.paulmount.paulfolioproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * *  Created by paulm on 1/24/2024
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag {
    private UUID id;
    private String name;
}
