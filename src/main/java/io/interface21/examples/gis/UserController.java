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
package io.interface21.examples.gis;

import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * A UserController.
 *
 * @author <a href="mailto:scherrer@openwms.org">Heiko Scherrer</a>
 */
@RestController
class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    /* Hack: We use a POST here to pass complex objects. */
    @PostMapping(value = "/users")
    List<UserVO> getByCoordinateWindow(@RequestBody @NotNull List<Coordinate> area) {
        return userService.findUsersWithin(new LinkedList<>(area));
    }
}
