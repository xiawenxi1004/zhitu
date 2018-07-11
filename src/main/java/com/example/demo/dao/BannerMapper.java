package com.example.demo.dao;

import com.example.demo.model.Banner;
import com.example.demo.model.BannerExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BannerMapper {

    int countByExample(BannerExample example);

    int deleteByExample(BannerExample example);


    int deleteByPrimaryKey(Integer url);


    int insert(Banner record);


    int insertSelective(Banner record);


    List<Banner> selectByExample(BannerExample example);

 
    Banner selectByPrimaryKey(Integer url);


    int updateByExampleSelective(@Param("record") Banner record, @Param("example") BannerExample example);


    int updateByExample(@Param("record") Banner record, @Param("example") BannerExample example);


    int updateByPrimaryKeySelective(Banner record);


    int updateByPrimaryKey(Banner record);
}