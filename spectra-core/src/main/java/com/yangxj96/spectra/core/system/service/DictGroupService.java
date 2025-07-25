package com.yangxj96.spectra.core.system.service;

import com.yangxj96.spectra.common.base.BaseService;
import com.yangxj96.spectra.core.system.javabean.entity.DictGroup;

/**
 * 字典(字典类型)业务层
 *
 * @author Jack Young
 * @version 1.0
 * @since 2025-6-18
 */
public interface DictGroupService extends BaseService<DictGroup> {

    /**
     * 根据字典类型编码获取字典类型
     *
     * @param code 字典类型编码
     * @return 字典类型
     */
    DictGroup getByCode(String code);
}
