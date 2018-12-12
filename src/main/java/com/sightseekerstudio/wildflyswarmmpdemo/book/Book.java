package com.sightseekerstudio.wildflyswarmmpdemo.book;

import java.io.Serializable;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    private int id;
    @Size(max = 512)
    private String name;
    private int price;
}
