package DynamicProgramming;

/**
 * Created by piyush.bajaj on 29/07/17.\
 * Given a dictionary of words, find minimum number of trials to reach from source word to destination word.
 * A valid trial on word 'w' is defined as either insert, delete or substitute operation of a single character in word 'w'
 * which results in a word 'w1' which is also present in the given dictionary.
 * For example, for dictionary {"BCCI","AICC","ICC","CCI","MCC","MCA", "ACC"},
 * minimum number of trials to reach from word "AICC" to "ICC" is 1. Only 1 opeartion of deleting character 'A' is required
 * to reach from word "AICC" to word "ICC". Minimum number of trials to reach from "AICC" to "MCC" is 2(AICC->ICC->MCC) and
 * minimum number of trials to reach from "AICC" to "MCA" is 3(AICC->ICC->MCC->MCA).
 * <p>
 * Now if you notice, there are no valid trials with source as "AICC" and destination as "BCCI" for above dictionary.
 * Hence the output returned by program should be '-1' indicating destination word cannot be reached from source word.
 */
public class minTrials {

    //public
}


