package com.alpha.common;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
//@TODO Remove
public class HelloBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    // ==== Getter && Setter ====

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}