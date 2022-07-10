/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/4 17:08
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import net.tecoy.constant.MessageConstant;
import net.tecoy.entity.PageResult;
import net.tecoy.entity.QueryPageBean;
import net.tecoy.entity.Result;
import net.tecoy.pojo.CheckGroup;
import net.tecoy.service.CheckGroupService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 服务检查组
 * @author Tecoy
 */
@RestController
@RequestMapping("/checkgroup")
public class CheckGroupController {

    @Reference
    private CheckGroupService checkGroupService;

    /**
     * 新增检查组
     * @param checkGroup
     * @param checkitemIds
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody CheckGroup checkGroup, Integer[] checkitemIds) {
        boolean flag = false;
        try {
            flag = checkGroupService.add(checkGroup, checkitemIds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(flag, flag ? MessageConstant.ADD_CHECKGROUP_SUCCESS : MessageConstant.ADD_CHECKGROUP_FAIL);
    }

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        return checkGroupService.pageQuery(queryPageBean);
    }

    /**
     * id查询
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public Result findById(Integer id) {
        try {
            CheckGroup checkGroup = checkGroupService.queryById(id);
            return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS, checkGroup);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_CHECKGROUP_FAIL);
        }
    }

    /**
     * 查询关联关系
     * @param id
     * @return
     */
    @RequestMapping("/findCheckItemIdsByCheckGroupId")
    public Result findCheckItemIdsByCheckGroupId(Integer id) {
        try {
            List<Integer> list = checkGroupService.queryCheckItemIdsByCheckGroupId(id);
            return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_CHECKGROUP_FAIL);
        }
    }

    /**
     * 编辑检查组数据
     * @param checkGroup
     * @param checkitemIds
     * @return
     */
    @RequestMapping("/edit")
    public Result edit(@RequestBody CheckGroup checkGroup, Integer[] checkitemIds) {
        boolean flag = false;
        try {
            flag = checkGroupService.edit(checkGroup, checkitemIds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(flag, flag ? MessageConstant.EDIT_CHECKGROUP_SUCCESS : MessageConstant.EDIT_CHECKGROUP_FAIL);
    }

    /**
     * 删除检查组
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Integer id) {
        boolean flag = false;
        try {
            flag = checkGroupService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(flag, flag ? MessageConstant.DELETE_CHECKGROUP_SUCCESS : MessageConstant.DELETE_CHECKGROUP_FAIL);
    }

    /**
     * 查询所有检查组
     * @return
     */
    @RequestMapping("/findAll")
    public Result findAll() {
        try {
            List<CheckGroup> checkGroups = checkGroupService.queryAll();
            return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS, checkGroups);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_CHECKGROUP_FAIL);
        }
    }

}
