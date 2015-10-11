package com.alpha.common;

import com.alpha.models.Poll;
import com.alpha.service.IPollService;
import com.alpha.service.PollService;
import org.hibernate.service.spi.InjectService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by patrick on 11/10/15.
 */

@ManagedBean
@SessionScoped
public class PollBean {

    @ManagedProperty(value = "#{roleHolderBean}")
    private RoleHolderBean roleHolderBean;


    public List<Poll> getCurrentUserPolls(){
        getRoleHolderBean();
        return null;
    }


    public RoleHolderBean getRoleHolderBean() {
        return roleHolderBean;
    }

    public void setRoleHolderBean(RoleHolderBean roleHolderBean) {
        this.roleHolderBean = roleHolderBean;
    }
}
