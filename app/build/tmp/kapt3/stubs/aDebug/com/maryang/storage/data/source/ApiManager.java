package com.maryang.storage.data.source;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0013"}, d2 = {"Lcom/maryang/storage/data/source/ApiManager;", "", "()V", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "okHttpClientBuilder", "Lokhttp3/OkHttpClient$Builder;", "pixabayAdapter", "Lretrofit2/Retrofit;", "getPixabayAdapter", "()Lretrofit2/Retrofit;", "pixabayAdapter$delegate", "Lkotlin/Lazy;", "pixabayApi", "Lcom/maryang/storage/data/source/PixabayApi;", "getPixabayApi", "()Lcom/maryang/storage/data/source/PixabayApi;", "pixabayApi$delegate", "app_aDebug"})
public final class ApiManager {
    private static final com.google.gson.Gson gson = null;
    private static final okhttp3.OkHttpClient.Builder okHttpClientBuilder = null;
    private static final kotlin.Lazy pixabayAdapter$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy pixabayApi$delegate = null;
    public static final com.maryang.storage.data.source.ApiManager INSTANCE = null;
    
    private final retrofit2.Retrofit getPixabayAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.maryang.storage.data.source.PixabayApi getPixabayApi() {
        return null;
    }
    
    private ApiManager() {
        super();
    }
}