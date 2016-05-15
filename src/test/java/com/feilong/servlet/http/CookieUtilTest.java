/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.servlet.http;

import javax.servlet.http.Cookie;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feilong.core.bean.PropertyUtil;
import com.feilong.servlet.http.entity.CookieEntity;
import com.feilong.tools.jsonlib.JsonUtil;

/**
 *
 * @author feilong
 * @version 1.5.4 2016年5月11日 下午5:35:24
 * @since 1.5.4
 */
public class CookieUtilTest{

    private static final Logger LOGGER = LoggerFactory.getLogger(CookieUtilTest.class);

    @Test
    public final void test(){
        CookieEntity cookieEntity = new CookieEntity("name", "jinxin");
        cookieEntity.setHttpOnly(false);

        Cookie cookie = new Cookie(cookieEntity.getName(), cookieEntity.getValue());

        PropertyUtil.copyProperties(cookie, cookieEntity //
                        , "httpOnly"//@since Servlet 3.0
        );

        if (LOGGER.isDebugEnabled()){
            LOGGER.debug(JsonUtil.format(cookie));
        }

    }
}