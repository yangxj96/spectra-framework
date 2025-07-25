/*
 *  Copyright 2025 yangxj96.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package com.yangxj96.spectra.core.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangxj96.spectra.core.system.javabean.entity.Organization;
import com.yangxj96.spectra.core.system.javabean.from.OrganizationFrom;
import com.yangxj96.spectra.core.system.javabean.vo.OrganizationTreeVo;

import java.util.List;

/**
 * 组织机构业务层
 *
 * @author Jack Young
 * @version 1.0
 * @since 2025-6-15
 */
public interface OrganizationService extends IService<Organization> {

    /**
     * 组织机构树形结构
     *
     * @return 组织机构树形结构数组
     */
    List<OrganizationTreeVo> tree();

    /**
     * 新增组织机构
     *
     * @param from 请求入参
     */
    void created(OrganizationFrom from);

    /**
     * 编辑组织机构
     *
     * @param from 请求入参
     */
    void modify(OrganizationFrom from);
}
