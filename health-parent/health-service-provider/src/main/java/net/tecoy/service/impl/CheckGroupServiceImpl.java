/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/4 17:20
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.tecoy.entity.PageResult;
import net.tecoy.entity.QueryPageBean;
import net.tecoy.mapper.CheckGroupMapper;
import net.tecoy.pojo.CheckGroup;
import net.tecoy.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = CheckGroupService.class)
@Transactional(rollbackFor = Exception.class)
public class CheckGroupServiceImpl implements CheckGroupService {

    @Autowired
    private CheckGroupMapper checkGroupMapper;

    @Override
    public boolean add(CheckGroup checkGroup, Integer[] checkitemIds) {
        // 新增检查组并关联检查项
        int number = checkGroupMapper.add(checkGroup);
        // 获得检查组id, 通过mybatis获取
        Integer checkGroupId = checkGroup.getId();
        this.addCheckGroupAndCheckItem(checkGroupId, checkitemIds);
        return number > 0;
    }

    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        PageHelper.startPage(currentPage, pageSize);
        Page<CheckGroup> page = checkGroupMapper.selectByCondition(queryString);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public CheckGroup queryById(Integer id) {
        return checkGroupMapper.selectById(id);
    }

    @Override
    public List<Integer> queryCheckItemIdsByCheckGroupId(Integer id) {
        return checkGroupMapper.selectCheckItemIdsByCheckGroupId(id);
    }

    @Override
    public boolean edit(CheckGroup checkGroup, Integer[] checkitemIds) {
        // 修改检查组基本信息
        int number = checkGroupMapper.edit(checkGroup);
        // 清理当前检查组关联的检查服务信息
        checkGroupMapper.deleteAssociation(checkGroup.getId());
        // 重新建立关联信息
        // 获得检查组id, 通过mybatis获取
        Integer checkGroupId = checkGroup.getId();
        this.addCheckGroupAndCheckItem(checkGroupId, checkitemIds);
        return number > 0;
    }

    @Override
    public boolean delete(Integer id) {
        Long count = checkGroupMapper.countAssociation(id);
        if (count > 0) {
            return false;
        }
        // 删除检查组关联信息
        checkGroupMapper.deleteAssociation(id);
        // 删除检查组信息
        return checkGroupMapper.deleteById(id) > 0;
    }

    @Override
    public List<CheckGroup> queryAll() {
        return checkGroupMapper.selectAll();
    }

    /**
     * 添加关联关系
     *
     * @param checkGroupId
     * @param checkitemIds
     */
    private void addCheckGroupAndCheckItem(Integer checkGroupId, Integer[] checkitemIds) {
        if (checkitemIds != null && checkitemIds.length > 0) {
            for (Integer checkitemId : checkitemIds) {
                Map<String, Integer> map = new HashMap<>();
                map.put("checkgroupId", checkGroupId);
                map.put("checkitemId", checkitemId);
                checkGroupMapper.addCheckGroupAndCheckItem(map);
            }
        }
    }
}
