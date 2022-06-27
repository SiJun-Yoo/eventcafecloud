package com.eventcafecloud.cafe;

import com.eventcafecloud.common.fileutil.Image;
import com.eventcafecloud.post.domain.Post;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class CafeImage extends Image {
    @ManyToOne(fetch = FetchType.LAZY)
    private Cafe cafe;
}
