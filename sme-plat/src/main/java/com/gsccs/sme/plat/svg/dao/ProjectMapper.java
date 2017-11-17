package com.gsccs.sme.plat.svg.dao;

import com.gsccs.sme.plat.svg.model.ProjectT;
import com.gsccs.sme.plat.svg.model.ProjectTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectMapper {
    int countByExample(ProjectTExample example);

    int deleteByExample(ProjectTExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectT record);

    int insertSelective(ProjectT record);

    List<ProjectT> selectByExample(ProjectTExample example);

    ProjectT selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectT record, @Param("example") ProjectTExample example);

    int updateByExample(@Param("record") ProjectT record, @Param("example") ProjectTExample example);

    int updateByPrimaryKeySelective(ProjectT record);

    int updateByPrimaryKey(ProjectT record);

	List<ProjectT> selectPageByExample(ProjectTExample example);
}