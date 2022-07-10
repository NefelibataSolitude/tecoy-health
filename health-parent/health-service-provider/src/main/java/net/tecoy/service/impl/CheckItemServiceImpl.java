/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/3 23:28
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.tecoy.entity.PageResult;
import net.tecoy.entity.QueryPageBean;
import net.tecoy.mapper.CheckItemMapper;
import net.tecoy.pojo.CheckItem;
import net.tecoy.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 检查项服务
 * @author Tecoy
 */
@Service(interfaceClass = CheckItemService.class)
@Transactional(rollbackFor = Exception.class)
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    private CheckItemMapper checkItemMapper;
    @Override
    public boolean add(CheckItem checkItem) {
        return checkItemMapper.add(checkItem) > 0;
    }

    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        // 基于mybatis的分页插件助手完成
        PageHelper.startPage(currentPage, pageSize);

        Page<CheckItem> page = checkItemMapper.selectByCondition(queryString);
        long total = page.getTotal();
        List<CheckItem> rows = page.getResult();
        return new PageResult(total, rows);
    }

    @Override
    public boolean deleteById(Integer id) {
        // 判断当前检查项是否关联检查组
        long count = checkItemMapper.countByCheckItemId(id);
        if (count > 0) {
            // 当前检查项被关联到检查组, 不允许删除
            return false;
        }
        return checkItemMapper.deleteById(id) > 0;
    }

    @Override
    public boolean edit(CheckItem checkItem) {
        return checkItemMapper.edit(checkItem) > 0;
    }

    @Override
    public CheckItem queryById(Integer id) {
        return checkItemMapper.selectById(id);
    }

    @Override
    public List<CheckItem> queryAll() {
        return checkItemMapper.selectAll();
    }
}
