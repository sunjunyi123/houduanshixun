package com.rabbiter.pm.controller;


import com.rabbiter.pm.domain.Stall;
import com.rabbiter.pm.domain.StallRes;
import com.rabbiter.pm.domain.vo.StallResVo;
import com.rabbiter.pm.domain.vo.StallVo;
import com.rabbiter.pm.service.StallService;
import com.rabbiter.pm.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>StallController 类通过 Spring MVC 提供的注解，定义了一组处理摊位管理业务逻辑的 RESTful API 端点。
 * 每个方法根据其功能使用不同的 HTTP 方法和路径，接收不同的参数，然后调用 StallService 提供的相应方法来处理业务逻辑，
 * 并返回包装好的 ResultJson 结果。
 *  前端控制器
 * </p>
 *
 * @author rabbiter
 * @since 2023-03-22
 */
@RestController
@RequestMapping("/stall")
public class StallController {

    @Autowired
    private StallService stallService;

    @PostMapping("/getStallList")
    public ResultJson<Object> getStallList(@RequestBody StallVo stallVo){
        return ResultJson.success(stallService.getStallList(stallVo));
    }

    @GetMapping("/orderStall")
    public ResultJson<Object> orderStall(Integer uid, Integer sid){
        return ResultJson.success(stallService.orderStall(uid,sid));
    }

    @PostMapping("/add")
    public ResultJson<Object> addStall(@RequestBody Stall stall){
        return ResultJson.success(stallService.addStall(stall));
    }

    @PostMapping("/update")
    public ResultJson<Object> updateStall(@RequestBody Stall stall){
        return ResultJson.success(stallService.updateStall(stall));
    }

    @GetMapping("/del")
    public ResultJson<Object> deleteStall(Integer sid){
        Stall stall = new Stall();
        stall.setSid(sid);
        stall.setStallLive("0");
        return ResultJson.success(stallService.updateById(stall));
    }

    @GetMapping("/allRes")
    public ResultJson<Object> allStallRes(String person){
        return ResultJson.success(stallService.getAllStallRes(person));
    }

    @GetMapping("/allNoPay")
    public ResultJson<Object> allNoPay(String person){
        return ResultJson.success(stallService.getAllNoPay(person).stream().filter(r -> r.getOverTime()==null));
    }

    @PostMapping("/allList")
    public ResultJson<Object> allStallResList(@RequestBody StallResVo stallResVo){
        return ResultJson.success(stallService.getAllListStallRes(stallResVo));
    }

    @PostMapping("/payMoney")
    public ResultJson<Object> payMoney(@RequestBody StallRes stallRes){
        return ResultJson.success(stallService.payMoneyManager(stallRes));
    }

    @PostMapping("/payMoneyPerson")
    public ResultJson<Object> payMoneyPerson(@RequestBody StallRes stallRes){
        return ResultJson.success(stallService.payMoneyPerson(stallRes));
    }



}

