package com.example.arthursaad.cedroapp.helper;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;

public class GliderHelper {
    public static GlideUrl getImg(String url, String token) {
        return new GlideUrl(url, new LazyHeaders.Builder()
                .addHeader("Authorization",token)
                .build());
    }
}
