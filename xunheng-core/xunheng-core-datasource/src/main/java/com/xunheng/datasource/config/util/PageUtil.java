package com.xunheng.datasource.config.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.base.dto.PageDto;

/**
 * @program: xunheng-cloud-cola
 * @description: 分页工具类 mvc模式使用
 * @author: hhqkkr
 * @date: 2023/7/4 13:13
 */
public class PageUtil {

    /**
     * Mybatis-Plus分页封装
     * @param page
     * @return
     */
    public static Page initMpPage(PageDto page){

        Page p = null;
        int pageNumber = page.getPage();
        int pageSize = page.getPageSize();

        if(pageNumber<1){
            pageNumber = 1;
        }
        if(pageSize<1){
            pageSize = 10;
        }
        p = new Page(pageNumber, pageSize);
        return p;
    }

}
