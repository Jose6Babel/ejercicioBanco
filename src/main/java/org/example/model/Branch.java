package org.example.model;

import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@NoArgsConstructor
@Repository
public class Branch {
    Long id;
    String name;
    String director;
    String direction;
}
