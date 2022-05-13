#!/php

<?php

class Solution
{

    /**
     * @param String $first
     * @param String $second
     * @return Boolean
     */
    function oneEditAway($first, $second)
    {

        // 如果两个字符串长度相差超过1 就直接false 了
        $firstLen = strlen($first);
        $secondLen = strlen($second);
        $len =  abs($firstLen - $secondLen);
        if ($len > 1) {
            return false;
        }

        // 让第一个字符串长度大的那个字符串为基准
        if ($firstLen > $secondLen)return $this->oneEditAway($second, $first);

        $diff = 0;
        $firstIndex = 0;
        $secondIndex = 0;
        while($firstIndex < $firstLen && $secondIndex < $secondLen && $diff < 2){
            // 第一个字符串中的字符
            $firstStr = $first[$firstIndex];
            $secondStr = $second[$secondIndex];
            if ($firstStr == $secondStr) {
                $firstIndex ++;
            } else {
                $diff ++;
                if ($firstLen == $secondLen) {
                    $firstIndex ++;
                }
            }
            $secondIndex ++;
        }

        return $diff < 2;
    }
}

$sol = new Solution();
var_dump($sol->oneEditAway('pale', 'ple'));

var_dump($sol->oneEditAway('pales', 'pal'));

var_dump($sol->oneEditAway('horse', 'ros'));
var_dump($sol->oneEditAway('horse', 'hrse'));

var_dump($sol->oneEditAway('intention', 'execution'));
