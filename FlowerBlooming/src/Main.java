import java.util.TreeSet;
public class Main {
        //Given flowers[i] =x
        //Flower will bloom on day= i+1
        //Position of flower = x
        //First day such that flowers such that blooming flower,...k-non....,blooming_flower
        //Lets suppose we are on day = i +1
        //Position : xc= flowers[i]
        //We account xc so k+1 dist away
        //Position left of xc k + 1 dist away: xl = xc -(k+1)
        //Position right of xc k+1 dist away: xr = xc +(k+1)



        public int kEmptySlots(int[] flowers, int k) {
            TreeSet<Integer> set = new TreeSet();

            for (int i = 0; i<flowers.length; i++){
                int xc= flowers[i];
                int xl = xc - (k+1);
                int xr= xc + (k+1);
                //This is basically saying see if there is a flower blooming
                //left of current flower (day less than the current day)and
                //if it is k distance away from current flower than the other flower in between must be invalid
                Integer l = set.lower(xc);
                if(l!=null && l==xl) return i + 1;
                //Same here
                Integer r = set.higher(xc);
                if(r!=null && r==xr) return i + 1;

                set.add(xc);


            }
            return -1;

        }


    public static void main(String[] args) {
	// write your code here
    }
}
