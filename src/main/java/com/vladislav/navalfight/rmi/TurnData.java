package com.vladislav.navalfight.rmi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnData implements Serializable {
    private int x;
    private int y;
    private boolean target;
    private boolean hit;
}
