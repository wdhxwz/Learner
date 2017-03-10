package com.wangdh.learner.springmvc.base;

import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.RowBoundsMapper;
import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.base.BaseUpdateMapper;
import tk.mybatis.mapper.common.sqlserver.InsertMapper;
import tk.mybatis.mapper.common.sqlserver.InsertSelectiveMapper;


public interface MSSQLMapper<T> extends 
		InsertMapper<T>,
		InsertSelectiveMapper<T>,
		BaseSelectMapper<T>,
		BaseUpdateMapper<T>, 
		BaseDeleteMapper<T>, 
		ExampleMapper<T>, 
		RowBoundsMapper<T>,
		Marker{
}
