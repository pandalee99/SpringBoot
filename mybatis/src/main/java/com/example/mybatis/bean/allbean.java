package com.example.mybatis.bean;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;

public class allbean {
    @Bean
    public PaginationInterceptor
    paginationInterceptor
            ()

    {


        return

                new

                        PaginationInterceptor
                        ();

    }
}
