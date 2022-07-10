/**
 * @Author: Tecoy
 * @Contact: itecoy@163.com
 * @Date: 2022/7/10 10:45
 * @Version: 1.0
 * @Description:
 */
package net.tecoy.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.tecoy.constant.MessageConstant;
import net.tecoy.entity.Result;
import net.tecoy.pojo.Setmeal;
import net.tecoy.service.MemberService;
import net.tecoy.service.ReportService;
import net.tecoy.service.SetmealService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 报表数据
 *
 * @author Tecoy
 */
@RestController
@RequestMapping("/report")
public class ReportController {
    @Reference
    private MemberService memberService;
    @Reference
    private SetmealService setmealService;
    @Reference
    private ReportService reportService;

    /**
     * 会员数据统计
     *
     * @return
     */
    @RequestMapping("/getMemberReport")
    public Result getMemberReport() {
        Calendar calendar = Calendar.getInstance();
        Map<String, Object> map = new HashMap<>();
        List<String> months = new ArrayList<>();
        // 计算过去12个月
        calendar.add(Calendar.MONTH, -12);
        for (int i = 0; i < 12; i++) {
            calendar.add(Calendar.MONTH, 1);
            Date date = calendar.getTime();
            months.add(new SimpleDateFormat("yyyy-MM").format(date));
        }
        // 根据月份查询数据
        List<Integer> memberCount = memberService.countMemberByMonth(months);
        map.put("months", months);
        map.put("memberCount", memberCount);
        return new Result(true, MessageConstant.GET_MEMBER_NUMBER_REPORT_SUCCESS, map);
    }

    /**
     * 套餐预约统计
     *
     * @return
     */
    @RequestMapping("/getSetmealReport")
    public Result getSetmealReport() {
        try {
            Map<String, Object> map = new HashMap<>();
            List<String> setmealNames = new ArrayList<>();
            List<Map<String, Object>> setmealCount = setmealService.selectCount();
            for (Map<String, Object> setmealMap : setmealCount) {
                String name = (String) setmealMap.get("name");
                setmealNames.add(name);
            }
            map.put("setmealNames", setmealNames);
            map.put("setmealCount", setmealCount);
            return new Result(true, MessageConstant.GET_SETMEAL_COUNT_REPORT_SUCCESS, map);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.GET_SETMEAL_COUNT_REPORT_FAIL);
        }
    }

    /**
     * 运营数据统计分析
     *
     * @return
     */
    @RequestMapping("/getBusinessReportData")
    public Result getBusinessReportData() {
        try {
            Map<String, Object> data = reportService.BusinessReport();
            return new Result(true, MessageConstant.GET_BUSINESS_REPORT_SUCCESS, data);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.GET_BUSINESS_REPORT_FAIL);
        }
    }

    /**
     * 导出报表
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/exportBusinessReport")
    public Result exportBusinessReport(HttpServletRequest request, HttpServletResponse response) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        Workbook workbook = null;
        try {
            Map<String, Object> result = reportService.BusinessReport();
            //取出返回结果数据，准备将报表数据写入到Excel文件中
            String reportDate = (String) result.get("reportDate");
            Integer todayNewMember = (Integer) result.get("todayNewMember");
            Integer totalMember = (Integer) result.get("totalMember");
            Integer thisWeekNewMember = (Integer) result.get("thisWeekNewMember");
            Integer thisMonthNewMember = (Integer) result.get("thisMonthNewMember");
            Integer todayOrderNumber = (Integer) result.get("todayOrderNumber");
            Integer thisWeekOrderNumber = (Integer) result.get("thisWeekOrderNumber");
            Integer thisMonthOrderNumber = (Integer) result.get("thisMonthOrderNumber");
            Integer todayVisitsNumber = (Integer) result.get("todayVisitsNumber");
            Integer thisWeekVisitsNumber = (Integer) result.get("thisWeekVisitsNumber");
            Integer thisMonthVisitsNumber = (Integer) result.get("thisMonthVisitsNumber");
            List<Map<String, Object>> hotSetmeal = (List<Map<String, Object>>) result.get("hotSetmeal");
            // 基于模板创建Excel对象
            String filePath = request.getSession().getServletContext().getRealPath("template") + File.separator + "report_template.xlsx";
            inputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            // 获得第三行
            Row row = sheet.getRow(2);
            // 日期
            row.getCell(5).setCellValue(reportDate);

            row = sheet.getRow(4);
            // 新增会员数（本日）
            row.getCell(5).setCellValue(todayNewMember);
            // 总会员数
            row.getCell(7).setCellValue(totalMember);

            row = sheet.getRow(5);
            // 本周新增会员数
            row.getCell(5).setCellValue(thisWeekNewMember);
            // 本月新增会员数
            row.getCell(7).setCellValue(thisMonthNewMember);

            row = sheet.getRow(7);
            // 今日预约数
            row.getCell(5).setCellValue(todayOrderNumber);
            // 今日到诊数
            row.getCell(7).setCellValue(todayVisitsNumber);

            row = sheet.getRow(8);
            // 本周预约数
            row.getCell(5).setCellValue(thisWeekOrderNumber);
            // 本周到诊数
            row.getCell(7).setCellValue(thisWeekVisitsNumber);

            row = sheet.getRow(9);
            // 本月预约数
            row.getCell(5).setCellValue(thisMonthOrderNumber);
            // 本月到诊数
            row.getCell(7).setCellValue(thisMonthVisitsNumber);
            row.getCell(5).setCellValue(reportDate);

            row = sheet.getRow(4);
            // 新增会员数（本日）
            row.getCell(5).setCellValue(todayNewMember);
            // 总会员数
            row.getCell(7).setCellValue(totalMember);

            row = sheet.getRow(5);
            // 本周新增会员数
            row.getCell(5).setCellValue(thisWeekNewMember);
            // 本月新增会员数
            row.getCell(7).setCellValue(thisMonthNewMember);

            row = sheet.getRow(7);
            // 今日预约数
            row.getCell(5).setCellValue(todayOrderNumber);
            // 今日到诊数
            row.getCell(7).setCellValue(todayVisitsNumber);

            row = sheet.getRow(8);
            // 本周预约数
            row.getCell(5).setCellValue(thisWeekOrderNumber);
            // 本周到诊数
            row.getCell(7).setCellValue(thisWeekVisitsNumber);

            row = sheet.getRow(9);
            // 本月预约数
            row.getCell(5).setCellValue(thisMonthOrderNumber);
            // 本月到诊数
            row.getCell(7).setCellValue(thisMonthVisitsNumber);
            int rowNum = 12;
            for (Map<String, Object> map : hotSetmeal) {
                // 热门套餐
                String name = (String) map.get("name");
                Long setmeal_count = (Long) map.get("setmeal_count");
                BigDecimal proportion = (BigDecimal) map.get("proportion");
                String remark = (String) map.get("remark");
                row = sheet.getRow(rowNum++);
                // 套餐名称
                row.getCell(4).setCellValue(name);
                // 预约数量
                row.getCell(5).setCellValue(setmeal_count);
                // 占比
                row.getCell(6).setCellValue(proportion.doubleValue());
                // 备注
                row.getCell(7).setCellValue(remark);
            }
            // 使用输出流进行下载, 基于浏览器
            outputStream = response.getOutputStream();
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("content-Disposition", "attachment;filename=report.xlsx");
            workbook.write(outputStream);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.GET_BUSINESS_REPORT_FAIL);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 导出pdf
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/exportBusinessReportPDF")
    public Result exportBusinessReportPDF(HttpServletRequest request, HttpServletResponse response) {
        OutputStream outputStream = null;
        try {
            Map<String, Object> result = reportService.BusinessReport();
            List<Map<String, Object>> hotSetmeal = (List<Map<String, Object>>) result.get("hotSetmeal");
            // 基于模板创建Excel对象
            String jrxmlPath = request.getSession().getServletContext().getRealPath("template") + File.separator + "health_business3.jrxml";
            String jasperPath = request.getSession().getServletContext().getRealPath("template") + File.separator + "health_business3.jasper";

            //编译模板
            JasperCompileManager.compileReportToFile(jrxmlPath, jasperPath);

            //填充数据---使用JavaBean数据源方式填充
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath, result, new JRBeanCollectionDataSource(hotSetmeal));

            // 使用输出流进行下载, 基于浏览器
            outputStream = response.getOutputStream();
            response.setContentType("application/pdf");
            response.setHeader("content-Disposition", "attachment;filename=report.pdf");

            //输出文件
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.GET_BUSINESS_REPORT_FAIL);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
