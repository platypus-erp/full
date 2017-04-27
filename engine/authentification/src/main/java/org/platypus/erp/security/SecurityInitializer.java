package org.platypus.erp.security;

import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.RelationshipManager;
import org.picketlink.idm.credential.Password;
import org.picketlink.idm.model.basic.Role;
import org.picketlink.idm.model.basic.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import static org.picketlink.idm.model.basic.BasicModel.grantRole;
import static org.platypus.erp.security.ApplicationRole.ADMINISTRATOR;
import static org.platypus.erp.security.ApplicationRole.DEVELOPER;
import static org.platypus.erp.security.ApplicationRole.PROJECT_MANAGER;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
@Singleton
@Startup
public class SecurityInitializer {
    private final Logger LOG = LoggerFactory.getLogger(SecurityInitializer.class);

    @Inject
    private PartitionManager partitionManager;

    @PostConstruct
    public void createUsers() {
        createUser("admin", ADMINISTRATOR);
        createUser("john", PROJECT_MANAGER);
        createUser("kate", DEVELOPER);
    }

    private void createUser(String loginName, String roleName) {
        User user = new User(loginName);

        IdentityManager identityManager = this.partitionManager.createIdentityManager();

        identityManager.add(user);

        Password password = new Password(loginName + "123");

        identityManager.updateCredential(user, password);

        Role role = new Role(roleName);

        identityManager.add(role);

        RelationshipManager relationshipManager = this.partitionManager.createRelationshipManager();

        grantRole(relationshipManager, user, role);

        LOG.info("User[{}] created with password[{}] and role name [{}]", loginName, password.getValue(), roleName);
    }
}
