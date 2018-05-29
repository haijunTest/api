package com.example.api.controller;

import com.example.api.model.HaijunTblEmployee;
import com.example.api.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * class $classname
 *
 * @author haijun
 * @date 2018/4/19, 13:41
 */
@RestController
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "通过id查询用户信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")}
    )
    @RequestMapping(path = "/api/to/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public HaijunTblEmployee getUserInfo(@Valid @NotNull @PathVariable("id") Integer id) {
        HaijunTblEmployee userInfo = userInfoService.getUserInfo(id);
        if (Objects.isNull(userInfo)) {
            return null;
        }
        return userInfo;
    }

    @ApiOperation(value = "登录")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")}
    )
    @RequestMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public String getLogin() {
        return null;
    }
}
