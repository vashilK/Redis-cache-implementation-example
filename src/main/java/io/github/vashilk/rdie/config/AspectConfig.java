package io.github.vashilk.rdie.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nki.redis.cache.annotations.impl.CacheReleaseHandler;
import org.nki.redis.cache.annotations.impl.CacheSaveHandler;
import org.nki.redis.cache.annotations.impl.CacheSyncHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Author Neeschal Kissoon created on 03/08/2023
 */
@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {

    private final RedisTemplate<String, Object> template;
    private final ObjectMapper objectMapper;

    public AspectConfig(RedisTemplate<String, Object> template, ObjectMapper objectMapper) {
        this.template = template;
        this.objectMapper = objectMapper;
    }

    @Bean
    public CacheSyncHandler cacheSyncHandler() {
        return new CacheSyncHandler(template, objectMapper);
    }

    @Bean
    public CacheSaveHandler cacheSaveHandler() {
        return new CacheSaveHandler(objectMapper, template);
    }

    @Bean
    public CacheReleaseHandler cacheReleaseHandler() {
        return new CacheReleaseHandler(template);
    }
}
    
