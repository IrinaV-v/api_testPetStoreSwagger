package org.example.entities;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Pet {
    private int id;
    private String name;
    private String[] photoUrls;
    private String[] tags;
    private String status;
}
