package com.gmail.rgizmalkov.edu.dissertation.controller;


import io.lettuce.core.RedisFuture;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private final StatefulRedisConnection<String, String> statefulRedisConnection;

    @Autowired
    public RedisController(StatefulRedisConnection<String, String> statefulRedisConnection) {
        this.statefulRedisConnection = statefulRedisConnection;
    }

    @GetMapping("/write")
    public @ResponseBody String write(@RequestParam("key") String key, @RequestParam("value") String value) {
        RedisAsyncCommands<String, String> async = statefulRedisConnection.async();
        async.set(key, value);
        return String.format("[KEY:%s] %s", key, value);
    }


    @GetMapping("/read")
    public @ResponseBody String read(@RequestParam("key") String key) throws ExecutionException, InterruptedException {
        RedisAsyncCommands<String, String> async = statefulRedisConnection.async();
        RedisFuture<String> stringRedisFuture = async.get(key);
        RedisCommands<String, String> sync = statefulRedisConnection.sync();
        return stringRedisFuture.get();
    }
}
