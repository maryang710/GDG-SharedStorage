package com.maryang.storage.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0000H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0003J\u0012\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0012\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r\u00a8\u0006\""}, d2 = {"Lcom/maryang/storage/ui/ImagesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/maryang/storage/base/ActivityContext;", "()V", "adapter", "Lcom/maryang/storage/ui/ImagesAdapter;", "getAdapter", "()Lcom/maryang/storage/ui/ImagesAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "repository", "Lcom/maryang/storage/data/repository/PixabayRepository;", "getRepository", "()Lcom/maryang/storage/data/repository/PixabayRepository;", "repository$delegate", "getContext", "hideLoading", "", "loadImages", "showLoading", "", "logStorage", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "toast", "message", "", "app_aDebug"})
public final class ImagesActivity extends androidx.appcompat.app.AppCompatActivity implements com.maryang.storage.base.ActivityContext {
    private final kotlin.Lazy repository$delegate = null;
    private final kotlin.Lazy adapter$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    private final com.maryang.storage.data.repository.PixabayRepository getRepository() {
        return null;
    }
    
    private final com.maryang.storage.ui.ImagesAdapter getAdapter() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @android.annotation.SuppressLint(value = {"NewApi"})
    private final void logStorage() {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void loadImages(boolean showLoading) {
    }
    
    @java.lang.Override()
    public void showLoading() {
    }
    
    @java.lang.Override()
    public void hideLoading() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.maryang.storage.ui.ImagesActivity getContext() {
        return null;
    }
    
    @java.lang.Override()
    public void toast(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public ImagesActivity() {
        super();
    }
}