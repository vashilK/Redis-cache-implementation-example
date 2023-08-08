package io.github.vashilk.rdie.model.dto;

import lombok.Data;
import org.nki.redis.cache.annotations.RedisCacheSerializable;

/**
 * Author Neeschal Kissoon created on 05/08/2023
 */

@Data
@RedisCacheSerializable
public class BookDto {
    private Long id;
    private String title;
    private String author;
}
