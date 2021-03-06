/**
 * Copyright © 2015 - 2017 EntDIY JavaEE Development Framework
 *
 * Site: https://www.entdiy.com, E-Mail: xautlx@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.entdiy.sys.dao;

import java.util.List;

import com.entdiy.auth.entity.User;
import com.entdiy.core.dao.jpa.BaseDao;
import com.entdiy.sys.entity.UserProfileData;

import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileDataDao extends BaseDao<UserProfileData, Long> {

    UserProfileData findByUserAndCode(User user, String code);

    List<UserProfileData> findByUser(User user);
}