package Q2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class TSPProblem {

    public static double finalFit = 0;
    public static ArrayList<Integer> RunTSP(int iterations, double distances[][]){
        ArrayList<Integer> empty = new ArrayList<Integer>();
        if (distances == null) return empty;
        if (iterations < 0) return null;
        if (distances.length == 0) return null;

        int arraySize = distances.length;
        ArrayList<Integer> randomRoute = RandomRoute(arraySize);
        ArrayList<Integer> bestRoute = new ArrayList<Integer>(distances.length);
        bestRoute = RMHC(randomRoute, iterations, distances);

        return bestRoute;
    }

    public static ArrayList<Integer> RandomRoute(int n){
        //n - nr of cities
        ArrayList<Integer> randomArray = new ArrayList<Integer>(n);

        for (int i = 0; i < n; i++)
        {
            randomArray.add(i);
        }
        Collections.shuffle(randomArray);
        return randomArray;
    }

    public static double RouteFitness(int n, ArrayList<Integer> route, double[][] distances){
        double s = 0;
        for (int i = 0; i < (n-1); i++) {

            int a = route.get(i);
            int b = route.get(i+1);

            s = s + distances[a][b];
        }

        int finalCity = route.size() - 1;
        int startCity = route.get(0);

        s = s + distances[finalCity][startCity];
        return s;
    }

    public static ArrayList<Integer> SwapRoute(ArrayList<Integer> oldRoute){
        ArrayList<Integer> newRoute = (ArrayList<Integer>) oldRoute.clone();
        int i = 0,j=0;

        while (i == j) {
            i = UI(1, newRoute.size() - 1);
            j = UI(1, newRoute.size() - 1);
        }
        int temp = newRoute.get(i);
        newRoute.set(i, newRoute.get(j));
        newRoute.set(j, temp);
        return newRoute;
    }

    //RMHC Optimisation
    public static ArrayList<Integer> RMHC(ArrayList<Integer> route, int iter, double[][] dataRead){
        int arraySize = route.size();
        double oldFit,newFit = 0;

        for (int i = 0; i < iter; i++) {
            oldFit = RouteFitness(arraySize, route, dataRead);

            //Store route
            ArrayList<Integer> oldRoute = (ArrayList<Integer>) route.clone();
            setRoute(oldRoute);
            ArrayList<Integer> newRoute = SwapRoute(route);
            newFit = RouteFitness(arraySize, newRoute, dataRead);
            if (newFit < oldFit) {
                route = (ArrayList<Integer>) newRoute.clone();
            }
            else {
                route = setRoute(oldRoute);
            }
            finalFit = oldFit;
        }
        return route;
    }

    public static ArrayList<Integer> setRoute(ArrayList<Integer> route){
        ArrayList<Integer> thisroute = route;
        return thisroute;
    }

    //Shared random object
    static private Random rand;
    //Create a uniformly distributed random integer between aa and bb inclusive
    static public int UI(int aa,int bb)
    {
        int a = Math.min(aa,bb);
        int b = Math.max(aa,bb);
        if (rand == null)
        {
            rand = new Random();
            rand.setSeed(System.nanoTime());
        }
        int d = b - a + 1;
        int x = rand.nextInt(d) + a;
        return(x);
    }
}