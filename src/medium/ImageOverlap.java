package medium;

public class ImageOverlap {
    public static void main(String[] args) {
        int[][] img1 = {{1, 1, 0}, {0, 1, 0}, {0, 1, 0}};
        int[][] img2 = {{0, 0, 0}, {0, 1, 1}, {0, 0, 1}};
        SolutionImageOverlap m = new SolutionImageOverlap();
        int l = m.largestOverlap(img1, img2);
        System.out.println(l);
        int[][] img3 =   {{1}};
        int[][] img4 =   {{1}};
        l = m.largestOverlap(img3, img4);
        System.out.println(l);
        int[][] img5 =   {{0}};
        int[][] img6 =   {{0}};
        l = m.largestOverlap(img5, img6);
        System.out.println(l);

    }
}

class SolutionImageOverlap {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int ret = 0;
        int N = img1.length;
        for(int i =0;i<N;i++){
            for(int j=0;j<N;j++){
                ret = Math.max(ret, helper(img1, img2, i, j, N));
                ret = Math.max(ret, helper(img2, img1, i, j, N));
            }
        }
        return ret;
    }

    int helper(int[][] img1, int[][] img2, int img1i, int img1j, int N) {
        int count =0, img2i=0;
        for(int i=img1i;i<N;i++){
            int img2j=0;
            for(int j=img1j;j<N;j++){
                if(img1[i][j] == 1 && img1[i][j] == img2[img2i][img2j]) {
                    count++;
                }
                img2j++;
            }
            img2i++;
        }
        return count;
    }
    int helper1(int[][] img1, int[][] img2, int x_shift, int y_shift, int N) {
        int num = 0;
        for(int i = 0; i<N;i++) {
            for (int j = 0; j < N; j++) {
                if(0<=j+x_shift && j+x_shift < N && 0<=i+y_shift && i+y_shift < N && img1[i+y_shift][j+x_shift] == 1 && img2[i][j] == 1) {
                    num += 1;
                }
            }
        }
        return num;
    }

}