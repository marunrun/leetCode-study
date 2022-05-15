<?php

class Solution {

    /**
     * @param Integer[][] $points
     * @return Float
     */
    function largestTriangleArea($points) {
        $len = count($points);
        $max = 0;
        for($i =0;$i<$len;$i++){
            for($j = $i+1;$j<$len;$j++){
                for($k = $j+1;$k<$len;$k++){
                    $max = max($max,$this->getArea($points[$i][0],$points[$i][1],$points[$j][0],$points[$j][1],$points[$k][0],$points[$k][1]));
                }
            }
        }

        return $max;
    }

    function getArea($x1,$y1,$x2,$y2,$x3,$y3){
        return 0.5 * abs($x1 * $y2 + $x2 * $y3 + $x3 * $y1 - $x1 * $y3 - $x2 * $y1 - $x3 * $y2);
    }
}

$solution = new Solution();
var_dump($solution->largestTriangleArea([[4,6],[6,5],[3,1]]));