/**
 * Copyright 1999-2014 dangdang.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.klwork.business.domain.facade;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.klwork.business.domain.model.Team;
import com.klwork.business.domain.service.TeamService;
import com.klwork.business.domain.service.UserService;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author lishen
 */
@Path("users")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
public class UserRestServiceImpl implements UserRestService {

//    private static final Logger logger = LoggerFactory.getLogger(UserRestServiceImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private TeamService teamService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public TeamService getTeamService() {
        return teamService;
    }

    public void setTeamService(TeamService teamService) {
        this.teamService = teamService;
    }

    @GET
    @Path("{id : \\w+}")
    public UserResponse getUser(@PathParam("id") String id/*, @Context HttpServletRequest request*/) {
        Team team = teamService.findTeamById("101");
        System.out.println(team.getName() + "sadfsd");
        User user =  userService.query(id);
        UserResponse response = new UserResponse();
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        return response;
    }

    @POST
    @Path("register")
    public RegistrationResult registerUser(User user) {
        return new RegistrationResult(1l);
    }
}
