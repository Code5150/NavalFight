package com.vladislav.navalfight.rmi;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class TurnData implements Serializable {
    private int x, y;
}
