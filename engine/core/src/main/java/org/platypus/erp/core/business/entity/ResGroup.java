package org.platypus.erp.core.business.entity;

import org.platypus.erp.core.util.CoreTableName;
import org.platypus.erp.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * Created by Alexis PASQUIER and Alexandre SALAUN on 01/08/16.
 *
 * @since 0.1
 * @version 0.1
 */
@Entity
@Table(name= CoreTableName.group)
@NamedQuery(name="ResGroup.findAll", query="SELECT r FROM ResGroup r")
public class ResGroup extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column
	private String comment;

//	//bi-directional many-to-many association to ResGroup
//	@ManyToMany
//	@JoinTable(
//		name="res_groups_implied_rel"
//		, joinColumns={
//			@JoinColumn(name="hid", nullable=false)
//			}
//		, inverseJoinColumns={
//			@JoinColumn(name="gid", nullable=false)
//			}
//		)
//	private List<ResGroup> resGroups1;
//
//	//bi-directional many-to-many association to ResGroup
//	@ManyToMany(mappedBy="resGroups1")
//	private List<ResGroup> resGroups2;
//
//	//bi-directional many-to-many association to ResUser
//	@ManyToMany(mappedBy="resGroups3")
//	private List<ResUser> resUsers;


    //<editor-fold desc="Getter Setter">
    public String getComment() {
        return comment;
    }

    public ResGroup setComment(String comment) {
        this.comment = comment;
        return this;
    }
    //</editor-fold>
}