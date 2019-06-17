package com.maryang.storage.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/maryang/storage/ui/ImagesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/maryang/storage/ui/ImagesAdapter$ImageViewHolder;", "activityContext", "Lcom/maryang/storage/base/ActivityContext;", "(Lcom/maryang/storage/base/ActivityContext;)V", "value", "", "Lcom/maryang/storage/entity/model/PixabayImage;", "items", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ImageViewHolder", "app_bDebug"})
public final class ImagesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.maryang.storage.ui.ImagesAdapter.ImageViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.maryang.storage.entity.model.PixabayImage> items;
    private final com.maryang.storage.base.ActivityContext activityContext = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.maryang.storage.entity.model.PixabayImage> getItems() {
        return null;
    }
    
    public final void setItems(@org.jetbrains.annotations.NotNull()
    java.util.List<com.maryang.storage.entity.model.PixabayImage> value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.maryang.storage.ui.ImagesAdapter.ImageViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.maryang.storage.ui.ImagesAdapter.ImageViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public ImagesAdapter(@org.jetbrains.annotations.NotNull()
    com.maryang.storage.base.ActivityContext activityContext) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/maryang/storage/ui/ImagesAdapter$ImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "activityContext", "Lcom/maryang/storage/base/ActivityContext;", "(Landroid/view/View;Lcom/maryang/storage/base/ActivityContext;)V", "bind", "", "image", "Lcom/maryang/storage/entity/model/PixabayImage;", "save", "context", "Landroid/content/Context;", "showFilePath", "app_bDebug"})
    public static final class ImageViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.maryang.storage.base.ActivityContext activityContext = null;
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.maryang.storage.entity.model.PixabayImage image) {
        }
        
        private final void showFilePath(android.content.Context context, com.maryang.storage.entity.model.PixabayImage image) {
        }
        
        private final void save(android.content.Context context, com.maryang.storage.entity.model.PixabayImage image) {
        }
        
        public ImageViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view, @org.jetbrains.annotations.NotNull()
        com.maryang.storage.base.ActivityContext activityContext) {
            super(null);
        }
    }
}