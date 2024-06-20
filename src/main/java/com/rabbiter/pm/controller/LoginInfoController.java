package com.rabbiter.pm.controller;


import com.rabbiter.pm.domain.LoginInfo;
import com.rabbiter.pm.domain.vo.LoginInfoVo;
import com.rabbiter.pm.domain.vo.StallVo;
import com.rabbiter.pm.service.LoginInfoService;
import com.rabbiter.pm.service.StallService;
import com.rabbiter.pm.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> LoginInfoController 类通过Spring框架提供的注解和依赖注入机制，实现了获取登录信息列表的功能。
 * 它是一个典型的基于RESTful风格的控制器，用于处理与登录信息相关的业务逻辑。
 *  前端控制器
 * </p>
 *
 * @author rabbiter
 * @since 2023-03-27
 */
@RestController
@RequestMapping("/login-info")
public class LoginInfoController {
    @Autowired
    private LoginInfoService loginInfoService;

    @PostMapping("/getLoginInfoList")
    public ResultJson<Object> getStallList(@RequestBody LoginInfoVo loginInfoVo){
        Object loginInfoList = loginInfoService.getLoginInfoList(loginInfoVo);
        return ResultJson.success(loginInfoList);
    }
}

