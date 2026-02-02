public class BitManipulation {
    //Finding max xor pair(a,b) in the range of (l,r):
    private static int maximizingXOR(int l, int r){
        int num = l ^ r;
        int pos = 0;
        while(num > 0){
            num = num >> 1;
            pos++;
        }
        // to get ther element which is ans 2 to power pos -1 whi hojayega 

        int ans = (int)Math.pow(2,pos) - 1;
        return ans;
    }
    public static void main(String[] args){
        System.out.println(maximizingXOR(5, 12));
        
    }
}
