/**
 * Created by Lori on 2/2/2017.
 */
public class Application {

    /**
     * This method invokes the other methods that fill up the goal kilos of a package with first big bars and
     * next with small bars of chocolate.
     *
     * @param small number of small bars.
     * @param big   big bars.
     * @param goal  package size.
     * @return the number of small chocolate bars used to fill up the package or -1 if it could not be done.
     */
    private int makeChocolate(int small, int big, int goal) {
        int goal_after_big_basrs = 0;
        int number_of_small_bars = 0;

        if (small < 0 || big < 0 || goal < 0)
            return -1;
        goal_after_big_basrs = bigBarsFirst(big, goal);
        number_of_small_bars = smallBarsNext(small, goal_after_big_basrs);

        return number_of_small_bars;
    }

    /**
     * This method fills up the package of goal kilos with big bars of chocolate.
     *
     * @param big  number of big bars.
     * @param goal the size of the package.
     * @return the remaining space in the package (goal).
     */
    private int bigBarsFirst(int big, int goal) {
        int big_bars = 5;

        if (big == 0)
            return goal;
        goal -= big_bars;
        return bigBarsFirst(big - 1, goal);
    }

    /**
     * This method receives the remaining space in the package (goal) after it was filled up by the method bigBarsFirst.
     *
     * @param small number of small bars.
     * @param goal  the remaining space in the package.
     * @return the number of small bars used to fill up the package or -1 if the package could not be filled up.
     */
    private int smallBarsNext(int small, int goal) {
        int small_bars = 1;
        int result = 0;
        int number_of_small_bars = 0;

        number_of_small_bars = small * small_bars;
        result = number_of_small_bars - goal;
        if (result < 0)
            return -1;
        if (result == 0)
            return small;
        else
            return small - result;
    }

    public static void main(String[] args) {
        Application application = new Application();

        System.out.println(application.makeChocolate(4, 1, 10));

    }
}
