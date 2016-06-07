package com.example.immutablesbug;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@Gson.TypeAdapters
public interface Response {

    String status();

    List<ResponseResult> results();
}
