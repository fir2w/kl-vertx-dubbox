package com.klwork.business.domain.service;


import com.klwork.common.utils.logging.Logger;
import com.klwork.common.utils.logging.LoggerFactory;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.Picture;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.util.IoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @version 1.0
 * @created ${plugin.now}
 * @author ww
 */

@Service
public class UserService {
	private transient Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	IdentityService identityService;
	
	public User query(String userId){
		return identityService.createUserQuery().userId(userId).singleResult();
	}

	public User createUser(String userId, String firstName, String lastName,
						   String password, String email, String imageResource,
						   List<String> groups, List<String> userInfo) {
		User user = null;
		if (identityService.createUserQuery().userId(userId).count() == 0) {

			// Following data can already be set by demo setup script

			user = identityService.newUser(userId);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setPassword(password);
			user.setEmail(email);
			identityService.saveUser(user);

			if (groups != null) {
				for (String group : groups) {
					identityService.createMembership(userId, group);
				}
			}
		}else {
			return identityService.createUserQuery().userId(userId).singleResult();
		}

		// Following data is not set by demo setup script

		// image
		if (imageResource != null) {
			//WW_TODO url图像怎么处理
			byte[] pictureBytes = IoUtil.readInputStream(getClass()
					.getClassLoader().getResourceAsStream(imageResource), null);
			Picture picture = new Picture(pictureBytes, "image/jpeg");
			identityService.setUserPicture(userId, picture);
		}

		// user info
		if (userInfo != null) {
			for (int i = 0; i < userInfo.size(); i += 2) {
				identityService.setUserInfo(userId, userInfo.get(i),
						userInfo.get(i + 1));
			}
		}
		return user;

	}

	public void createGroup(String groupId, String type) {
		if (identityService.createGroupQuery().groupId(groupId).count() == 0) {
			Group newGroup = identityService.newGroup(groupId);
			newGroup.setName(groupId.substring(0, 1).toUpperCase()
					+ groupId.substring(1));
			newGroup.setType(type);
			identityService.saveGroup(newGroup);
		}
	}

}