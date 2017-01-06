/*
 * Shop2gether Backend.
 *
 * This software module including the design and software principals used is and remains
 * the property of Heiko Scherrer (the initial author of the project)
 * and is submitted with the understanding that it is not to be reproduced nor copied in
 * whole or in part, nor licensed or otherwise provided or communicated to any third party
 * without their prior written consent. It must not be used in any way detrimental to the
 * interests of both authors. Acceptance of this module will be construed as an agreement
 * to the above.
 *
 * All rights of Heiko Scherrer remain reserved. Shop2gether Backend
 * is a registered trademark of Heiko Scherrer. Other products and
 * company names mentioned herein may be trademarks or trade names of their respective owners.
 * Specifications are subject to change without notice.
 */
package io.interface21.examples.gis.integration.jpa;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import io.interface21.shop2gether.Coordinate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.ameba.integration.jpa.ApplicationEntity;

/**
 * An User is some authenticated human user of the system.
 *
 * @author <a href="mailto:scherrer@openwms.org">Heiko Scherrer</a>
 */
@Getter
@ToString(exclude = "password")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
class User extends ApplicationEntity {

    private String username;
    private Point homePosition;

    public User(String username) {
        this.username = username;
    }

    @PrePersist
    @PreUpdate
    protected void onPostConstruct() {
        this.homePosition = new GeometryFactory().createPoint(new com.vividsolutions.jts.geom.Coordinate(home.getLongitude(), home.getLatitude()));
    }
}
