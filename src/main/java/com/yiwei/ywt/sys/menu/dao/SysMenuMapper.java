package com.yiwei.ywt.sys.menu.dao;



import com.yiwei.ywt.framework.dao.CRUDMapper;
import com.yiwei.ywt.sys.menu.model.SysMenu;
import org.apache.ibatis.annotations.Mapper;


/**
 * 系统菜单 dao接口类</p>
 *
 * @author czy
 * @version 1.0.0
 * @date 2016/11/25 9:36
 */
@Mapper
public interface SysMenuMapper extends CRUDMapper<SysMenu> {


}
