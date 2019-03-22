/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */

//$Id$
package org.hibernate.orm.test.annotations.manytomany;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterJoinTable;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.WhereJoinTable;

/**
 * @author Emmanuel Bernard
 */
@Entity
@Table(name = "tbl_group")
@FilterDef(name="Groupfilter")
public class Group {
	private Integer id;
	private Collection<Permission> permissions;

	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToMany(cascade = CascadeType.PERSIST)
	@OrderBy("expirationDate")
	@Where(clause = "1=1")
	@WhereJoinTable(clause = "2=2")
	@Filter(name="Groupfilter", condition = "3=3")
	@FilterJoinTable(name="Groupfilter", condition = "4=4")
	@JoinTable(name = "tbl_group_permissions", joinColumns = @JoinColumn(name = "tbl_group_id"))
	public Collection<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Collection<Permission> permissions) {
		this.permissions = permissions;
	}
}