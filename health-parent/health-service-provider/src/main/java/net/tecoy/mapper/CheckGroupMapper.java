/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/4 17:14
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.mapper;

import com.github.pagehelper.Page;
import net.tecoy.pojo.CheckGroup;

import java.util.List;
import java.util.Map;

/**+
 * 管理检查组
 * @author Tecoy
 */
public interface CheckGroupMapper {

    /**
     * 新增检查组
     * @param checkGroup
     * @return
     */
    int add(CheckGroup checkGroup);

    /**
     * 添加关联数据表数据
     * @param map
     * @return
     */
    int addCheckGroupAndCheckItem(Map<String, Integer> map);

    /**
     * 条件查询
     * @param queryString
     * @return
     */
    Page<CheckGroup> selectByCondition(String queryString);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    CheckGroup selectById(Integer id);

    /**
     * 通过检查组id查询关联检查服务id
     * @param id
     * @return
     */
    List<Integer> selectCheckItemIdsByCheckGroupId(Integer id);

    /**
     * 编辑检查组
     * @param checkGroup
     * @return
     */
    int edit(CheckGroup checkGroup);

    /**
     * 删除关联关系
     * @param id
     * @return
     */
    int deleteAssociation(Integer id);

    /**
     * 删除检查组信息
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 查询所有检查组
     * @return
     */
    List<CheckGroup> selectAll();

    /**
     * 统计关联信息
     * @param id
     * @return
     */
    Long countAssociation(Integer id);
}
