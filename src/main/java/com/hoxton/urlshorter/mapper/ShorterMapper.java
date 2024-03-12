package com.hoxton.urlshorter.mapper;

import com.hoxton.urlshorter.entity.Url;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;


@Mapper
@Repository
public interface ShorterMapper extends BaseMapper<Url> {
    String findByShortURL(@Param("url") String shortURL);

}
