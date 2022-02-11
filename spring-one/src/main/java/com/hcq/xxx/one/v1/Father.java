package com.hcq.xxx.one.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Father {
    private Son1 son1;
    private Son2 son2;

    public void play() {
        son1.eat();
        son2.eat();
    }
}
