package com.allen;


import com.allen.controller.DepotStationManageController;
import com.allen.controller.DepotTruckManageController;
import com.allen.mapper.OrderManageMapper;
import com.allen.pojo.Order;
import com.allen.service.AuthorSendMessage;
import com.allen.service.DepotTruckManageService;
import com.allen.service.Impl.UserSubscribeImpl;
import com.allen.service.SelectOrderService;
import com.allen.service.UserSubscribe;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class AppRunTests {

    @Autowired
    SelectOrderService service;

    @Autowired
    OrderManageMapper orderManageMapper;

    @Autowired
    DepotTruckManageService service1;

    @Autowired
    DepotStationManageController controller;

    @Autowired
    UserSubscribe userSubscribe;

    @Autowired
    AuthorSendMessage message;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test04() {
        Order order = new Order("2019-07-01","test4","test","32855768",null,"1","300625",15000,2,"2019-07-21 19:00:00",2);
        service.addSingleOrder(order);
    }

    @Test
    public void test05() {

    }

    public void solve(char[][] board) {
        if(board==null || board.length==0)return;
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                boolean isEdge = i==0||j==0||i==m-1||j==n-1;
                if(isEdge && board[i][j]=='O'){
                    dfs(board,i,j);  //将与边界联通的O替换为#
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
                if(board[i][j]=='#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    void dfs(char[][] board,int i,int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]=='X' || board[i][j]=='#'){
            //board[i][j]=='#' 说明已经遍历过
            return;
        }
        board[i][j] = '#';  //将与边界联通的O替换为#
        //上、下、左、右
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }

}
