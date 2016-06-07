package com.example.immutablesbug;

import android.support.annotation.Nullable;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@Gson.TypeAdapters
public interface ResponseResult {

    @Nullable
    List<String> tags();
}
