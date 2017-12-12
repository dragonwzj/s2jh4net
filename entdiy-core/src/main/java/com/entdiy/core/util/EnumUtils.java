/**
 * Copyright © 2015 - 2017 EntDIY JavaEE Development Framework
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.entdiy.core.util;

import java.lang.reflect.Field;
import java.util.Map;

import com.entdiy.core.annotation.MetaData;

import com.google.common.collect.Maps;

public class EnumUtils {

    private static Map<Class<?>, Map<Enum<?>, String>> enumDatasContainer = Maps.newHashMap();

    /**
     * 基于Enum类返回对应的key-value Map构建对象
     * @param enumClass
     * @return
     */
    public static Map<Enum<?>, String> getEnumDataMap(Class<? extends Enum> enumClass) {
        Map<Enum<?>, String> enumDataMap = enumDatasContainer.get(enumClass);
        if (enumDataMap != null) {
            return enumDataMap;
        }
        enumDataMap = Maps.newLinkedHashMap();
        enumDatasContainer.put(enumClass, enumDataMap);
        Field[] fields = enumClass.getFields();
        for (Field field : fields) {
            String name = field.getName();
            String label = name;
            MetaData entityComment = field.getAnnotation(MetaData.class);
            if (entityComment != null) {
                label = entityComment.value();
            }
            enumDataMap.put(Enum.valueOf(enumClass, name), label);
        }
        return enumDataMap;
    }

}