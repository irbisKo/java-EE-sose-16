package com.alpha.models;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by erwinschens on 27.04.15.
 */
public interface IModel extends Serializable {
    Long getId();

    void setId(Long id);

    Date getCreatedAt();

    Date getUpdatedAt();

    void setCreatedAt(Date createdAt);

    void setUpdatedAt(Date updatedAt);
}
