package com.rabbiter.pm.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rabbiter.pm.domain.Car;
import com.rabbiter.pm.domain.Stall;
import com.rabbiter.pm.domain.vo.CarVo;
import com.rabbiter.pm.domain.vo.StallCarVo;
import com.rabbiter.pm.mapper.StallMapper;
import com.rabbiter.pm.service.CarService;
import com.rabbiter.pm.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**一个 Spring MVC 控制器，处理了与汽车相关的增删改查操作。
 * 通过使用不同的 HTTP 请求方法和路径，它映射了多个操作到相应的服务方法，并使用 ResultJson 封装返回结果，以便统一处理响应格式。
 * <p>
 *  前端控制器
 * </p>
 *
 * @author rabbiter
 * @since 2023-03-27
 */
@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private StallMapper stallMapper;

    @PostMapping("/getList")
    public ResultJson<Object> getList(@RequestBody CarVo carVo){
        return ResultJson.success(carService.getList(carVo));
    }

    @PostMapping("/add")
    public ResultJson<Object> addCar(@RequestBody Car car){
        return ResultJson.success(carService.addCar(car));
    }

    @GetMapping("/del")
    public ResultJson<Boolean> del(Integer tid){
        return ResultJson.success(carService.removeById(tid));
    }

    @PostMapping("/update")
    public ResultJson<Object> updateCar(@RequestBody Car car){
        return ResultJson.success(carService.updateById(car));
    }


    @PostMapping("/getCar")
    public ResultJson<Object> getStallUser(@RequestBody StallCarVo stallCarVo){
        Page<Stall> page = new Page<>(stallCarVo.getPagenum(),stallCarVo.getPageSize());
        return ResultJson.success(stallMapper.getStallAll(page,stallCarVo.getNike(),stallCarVo.getCard()));
    }

}

