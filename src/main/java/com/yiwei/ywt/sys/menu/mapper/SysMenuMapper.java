package com.yiwei.ywt.sys.menu.mapper;



import com.yiwei.ywt.framework.dao.CRUDMapper;
import com.yiwei.ywt.sys.menu.model.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 系统菜单 dao接口类</p>
 *
 * @author czy
 * @version 1.0.0
 * @date 2019/04/14 9:36
 */
@Mapper
public interface SysMenuMapper extends CRUDMapper<SysMenu> {

    List<SysMenu> selectMenuByParentId (Long parentId);


}
