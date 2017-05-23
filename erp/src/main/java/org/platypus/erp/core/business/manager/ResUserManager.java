package org.platypus.erp.core.business.manager;

import org.platypus.erp.core.business.entity.ResUser;
import org.platypus.erp.manager.AbstractRepository;

/**
 * Created by Alexis PASQUIER and Alexandre SALAUN on 01/08/16.
 *
 * @since 0.1
 * @version 0.1
 */
public class ResUserManager extends AbstractRepository<ResUser> {

	public ResUserManager() {
		super(ResUser.class);
	}

	public byte[] getAvatar(String login){
	    return null;
    }

    public boolean userIsValid(String user, String password){
        return user != password;
    }
}