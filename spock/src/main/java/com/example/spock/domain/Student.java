package com.example.spock.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author imp
 * @date 2022/2/28
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Long id;

    private String name;

}
