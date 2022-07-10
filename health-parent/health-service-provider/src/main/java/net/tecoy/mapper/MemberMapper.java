/**
 * @Author: Tecoy
 * Contact: itecoy@163.com
 * @Date: 2022/7/9 15:00
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.mapper;

import net.tecoy.pojo.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会员管理
 * @author Tecoy
 */
public interface MemberMapper {
    /**
     * 添加会员
     * @param member
     * @return
     */
    int add(Member member);

    /**
     * 查询所有会员
     * @return
     */
    List<Member> selectAll();

    /**
     * id查询
     * @param id
     * @return
     */
    Member selectById(Integer id);

    /**
     * 通过手机号查询
     * @param telephone
     * @return
     */
    Member selectByTelephone(String telephone);

    /**
     * 根据月统计数据
     * @param startTime
     * @param endTime
     * @return
     */
    int countMemberByDate(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 统计会员总数
     * @return
     */
    int countTotal();
}
