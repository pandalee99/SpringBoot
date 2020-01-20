package com.example.rest.controller;

import com.example.rest.enumeration.SexEnum;
import com.example.rest.pojo.User;
import com.example.rest.service.UserService;
import com.example.rest.vo.UserVo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    // 用户服务接口
    @Autowired
    private UserService userService = null;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @PostMapping("/user")
    public User insertUser(@RequestBody UserVo userVo){
        User user=this.changeToPo(userVo);
        return userService.insertUser(user);
    }

    // 获取用户
    @GetMapping(value = "/user/{id}")
    @ResponseBody
    public UserVo getUser(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        return changeToVo(user);
    }


    @GetMapping("/users/{userName}/{note}/{start}/{limit}")
    @ResponseBody
    public List<UserVo> findUsers(
            @PathVariable("userName") String userName,
            @PathVariable("note") String note,
            @PathVariable("start") int start,
            @PathVariable("limit") int limit) {
        List<User> userList = userService.findUsers(userName, note, start, limit);
        return this.changeToVoes(userList);
    }


    @PutMapping("/user/{id}")
    @ResponseBody
    public User updateUser(@PathVariable("id") Long id, @RequestBody UserVo userVo) {
        User user = this.changeToPo(userVo);
        user.setId(id);
        userService.updateUser(user);
        return user;
    }


    @PatchMapping("/user/{id}/{userName}")
    @ResponseBody
    public ResultVo changeUserName(@PathVariable("id") Long id,
                                   @PathVariable("userName") String userName) {
        int result = userService.updateUserName(id, userName);
        ResultVo resultVo = new ResultVo(result>0,result > 0 ? "更新成功" : "更新用户【" + id + "】失败。");
        return resultVo;
    }



    // 转换Vo变为PO
    private User changeToPo(UserVo userVo) {
        User user = new User();
        user.setId(userVo.getId());
        user.setUserName(userVo.getUserName());
        user.setSex(SexEnum.getSexEnum(userVo.getSexCode()));
        user.setNote(userVo.getNote());
        return user;
    }

    // 转换PO变为VO
    private UserVo changeToVo(User user) {
        UserVo userVo = new UserVo();
        userVo.setId(user.getId());
        userVo.setUserName(user.getUserName());
        userVo.setSexCode(user.getSex().getCode());
        userVo.setSexName(user.getSex().getName());
        userVo.setNote(user.getNote());
        return userVo;
    }

    // 将PO列表转换为VO列表
    private List<UserVo> changeToVoes(List<User> poList) {
        List<UserVo> voList = new ArrayList<>();
        for (User user : poList) {
            UserVo userVo = changeToVo(user);
            voList.add(userVo);
        }
        return voList;
    }

    // 结果VO
    @Data
    public class ResultVo {
        public ResultVo(Boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        private Boolean success = null;
        private String message = null;
    }
}
