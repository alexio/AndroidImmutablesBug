# AndroidImmutablesBug
Sample repo to demonstrate bug in Immutables project. https://github.com/immutables/immutables

# Bug

Say you have some sample json, `{ "tags" : []}`, and the below class definition.

    ```@Value.Immutable
    @Gson.TypeAdapters
    public interface ResponseResult {
        @Nullable
        List<String> tags();
    }```

Even though the json field `tags` is an empty array, the output object of `ResponseResult` from gson will be null instead of an empty list. Issue is demonstrated in the test, `ImmutableBugTest#testObjectParsing`.
