package com.alpha.models;

import java.io.Serializable;

/**
 * Created by erwinschens on 27.04.15.
 */
public interface IModel extends Serializable {
    Long getId();

    void setId(Long id);
}
