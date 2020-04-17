package leetcode;

/**
 * https://leetcode.com/problems/iterator-for-combination
 */
public class Iterator_for_Combination {

    public static void main(String [] args) {
        String characters = "abc";
        int combinationLength = 2;
        Iterator_for_Combination entity = new Iterator_for_Combination(characters, combinationLength);
        System.out.println(entity.next());
        System.out.println(entity.hasNext());
        System.out.println(entity.next());
    }


    String cur;
    String str;
    final int l;

    public Iterator_for_Combination(String characters, int combinationLength) {
        cur="";
        str=characters;
        l=combinationLength;
    }

    public String next() {
        char[] charArray = cur.toCharArray();
        System.out.println("cur:" + cur);
        System.out.println("str:" + str);
        if(cur.length()==0) {
            // if cur has nothing, means next() should be the very first string to return.
            // First "l" chars.
            charArray = str.substring(0, l).toCharArray();
            System.out.println("cur.length=0, and charArray=" + new String(charArray));
        } else {
            int i=0;
            // loop from last char in substring, to the first position.
            for(i=l-1;i>=0;i--) {
                System.out.println("i:" + i);
                //
                if(charArray[i]!=str.charAt(str.length()-(l-i))) {
                    System.out.println("break");
                    break;
                }
            }

            int idx=str.indexOf(charArray[i])+1; // this will only work when the str has unique char

            System.out.println("idx:" + idx);
            System.out.println("Start loop i:" + i);
            for(i=i;i<l;i++,idx++) {
                System.out.println("Building charArray: " + new String(charArray));
                charArray[i]=str.charAt(idx);
            }
        }
        cur=new String(charArray);
        return cur;
    }

    public boolean hasNext() {
        // return (curr<ret.size());
        if(cur.length()==0) return true;
        for(int i=l-1;i>=0;i--) {
            if(cur.charAt(i)!=str.charAt(str.length()-l+i)) {
                return true;
            }
        }
        return false;
    }
}
