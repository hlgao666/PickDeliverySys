package com.allen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Allen
 * @date 2021/6/15 14:36
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User  implements Serializable {

    private String username;
    private String password;

}
