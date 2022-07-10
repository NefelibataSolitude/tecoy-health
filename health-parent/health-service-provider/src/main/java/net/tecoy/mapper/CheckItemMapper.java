/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/3 23:31
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.mapper;

import com.github.pagehelper.Page;
import net.tecoy.pojo.CheckItem;

import java.util.List;

/**
 * 检查服务持久层
 * @author Tecoy
 */
public interface CheckItemMapper {
    /**
     * 新增
     * @param checkItem
     * @return
     */
    int add(CheckItem checkItem);

    /**
     * 分页查询
     * @param queryString
     * @return
     */
    Page<CheckItem> selectByCondition(String queryString);

    /**
     * 统计检查服务关联组的数量
     * @param id
     * @return
     */
    long countByCheckItemId(Integer id);

    /**
     * 通过id删除
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 编辑检查项数据
     * @param checkItem
     * @return
     */
    int edit(CheckItem checkItem);

    /**
     * 主键查询
     * @param id
     * @return
     */
    CheckItem selectById(Integer id);

    /**
     * 查询所有检查项
     * @return
     */
    List<CheckItem> selectAll();
}
