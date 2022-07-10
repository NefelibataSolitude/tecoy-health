/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/6 18:47
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.tecoy.constant.RedisConstant;
import net.tecoy.entity.PageResult;
import net.tecoy.entity.QueryPageBean;
import net.tecoy.mapper.SetmealMapper;
import net.tecoy.pojo.Setmeal;
import net.tecoy.service.SetmealService;
import net.tecoy.utils.FreeMarkerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = SetmealService.class)
@Transactional(rollbackFor = Exception.class)
public class SetmealServiceImpl implements SetmealService {

    @Autowired
    private SetmealMapper setmealMapper;
    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;
    /**
     * 从属性文件中读取输出目录
     */
    @Value("${out_put_path}")
    private String outputPath;


    @Override
    public boolean add(Setmeal setmeal, Integer[] ids) {
        int number = setmealMapper.add(setmeal);
        Integer id = setmeal.getId();
        this.addAssociation(id, ids);
        // 将图片名称保存到redis
        String fileName = setmeal.getImg();
        jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_DB_RESOURCES, fileName);
        // 当添加套餐后需要生成新的静态页面
        this.generateMobileStaticHtml();
        return number > 0;
    }

    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
         PageHelper.startPage(currentPage, pageSize);
        Page<Setmeal> page = setmealMapper.selectByCondition(queryString);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List<Integer> selectAssociation(Integer id) {
        return setmealMapper.selectAssociation(id);
    }

    @Override
    public Setmeal selectById(Integer id) {
        return setmealMapper.selectById(id);
    }

    @Override
    public boolean edit(Setmeal setmeal, Integer[] ids) {
        int number = setmealMapper.edit(setmeal);
        Integer id = setmeal.getId();
        setmealMapper.deleteAssociation(id);
        this.addAssociation(id, ids);
        return number > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        setmealMapper.deleteAssociation(id);
        int number = setmealMapper.deleteById(id);
        return number > 0;
    }


    @Override
    public List<Setmeal> selectAll() {
        return setmealMapper.selectAll();
    }


    @Override
    public List<Map<String, Object>> selectCount() {
        return setmealMapper.selectCount();
    }

    /**
     * 添加关联关系
     * @param setmealId
     * @param checkGroupIds
     */
    private void addAssociation(Integer setmealId, Integer[] checkGroupIds) {
        if (checkGroupIds != null && checkGroupIds.length > 0) {
            for (Integer checkGroupId : checkGroupIds) {
                Map<String, Integer> map = new HashMap<>();
                map.put("setmealId", setmealId);
                map.put("checkgroupId", checkGroupId);
                setmealMapper.addAssociation(map);
            }
        }
    }

    /**
     * 生成静态页面
     */
    private void generateMobileStaticHtml() {
        //准备模板文件中所需的数据
        List<Setmeal> setmealList = this.selectAll();
        //生成套餐列表静态页面
        generateMobileSetmealListHtml(setmealList);
        //生成套餐详情静态页面（多个）
        generateMobileSetmealDetailHtml(setmealList);
    }

    /**
     * 生成套餐列表静态页面
     * @param setmealList
     */
    private void generateMobileSetmealListHtml(List<Setmeal> setmealList) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("setmealList", setmealList);
        FreeMarkerUtils.generateHtml(freeMarkerConfigurer, outputPath, "mobile_setmeal.ftl","m_setmeal.html",dataMap);
    }

    /**
     * 生成套餐详情静态页面（多个）
     * @param setmealList
     */
    private void generateMobileSetmealDetailHtml(List<Setmeal> setmealList) {
        for (Setmeal setmeal : setmealList) {
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("setmeal", this.selectById(setmeal.getId()));
            FreeMarkerUtils.generateHtml(freeMarkerConfigurer, outputPath, "mobile_setmeal_detail.ftl",
                    "setmeal_detail_"+setmeal.getId()+".html",
                    dataMap);
        }
    }



}
