import java.util.List;

/**
 * @author lyq on 2020-11-12 11:18 下午
 * @desc 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 *  拆分时可以重复使用字典中的单词。
 *  你可以假设字典中没有重复的单词。
 */
public class 单词拆分 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len +1];
        dp[0] = true;
        for (int i=1;i<=len+1;i++) {
            for (int j=0;j<i;j++) {
                dp[i] = dp[j] && wordDict.contains(s.substring(j, i));
            }
        }
        return dp[len];
    }

}
