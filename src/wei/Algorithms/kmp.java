package wei.Algorithms;

/**
 * @ClassName kmp
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class kmp {
        public static int Kmp(String ms,String os){
            int j = 0;
            int i = 0;
            char [] m = ms.toCharArray();
            char [] o = os.toCharArray();
            int [] next = GetNext(os);
            while (i < m.length && j <o.length){
                if (j == -1 || m[i] == o[j]) {
                    i++;
                    j++;
                }
                else {
                    j = next[j];
                }
            }
            if (j == o.length) {
                return i-j;
            }
            else {
                return -1;
            }
        }
        public static int[] GetNext(String ss){ //求next数组
            char [] s = ss.toCharArray();
            int [] next = new int[ss.length()];
            next[0] = -1;
            int j = 0;
            int k = -1;
            while (j < ss.length()-1){
                if (k == -1 || s[j] == s[k]) {
                    next[++j] = ++k;
                }
                else {
                    k = next[k];
                }
            }
            return next;
        }
    }

