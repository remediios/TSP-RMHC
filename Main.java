package Q2;

public class Main {
    //Different testing data sets to use
    public static String data_48 = "TSP_Data/TSP_48.txt", opt_data_48 = "TSP_Data/TSP_48_OPT.txt",
            data_51 = "TSP_Data/TSP_51.txt", opt_data_51 = "TSP_Data/TSP_51_OPT.txt",
            data_52 = "TSP_Data/TSP_52.txt", opt_data_52 = "TSP_Data/TSP_52_OPT.txt",
            data_70 = "TSP_Data/TSP_70.txt", opt_data_70 = "TSP_Data/TSP_70_OPT.txt",
            data_76 = "TSP_Data/TSP_76.txt", opt_data_76 = "TSP_Data/TSP_76_OPT.txt",
            data_100 = "TSP_Data/TSP_100.txt", opt_data_100 = "TSP_Data/TSP_100_OPT.txt",
            data_105 = "TSP_Data/TSP_105.txt", opt_data_105 = "TSP_Data/TSP_105_OPT.txt",
            data_136 = "TSP_Data/TSP_136.txt", data_150 = "TSP_Data/TSP_150.txt",
            data_198 = "TSP_Data/TSP_198.txt", data_226 = "TSP_Data/TSP_226.txt",
            data_264 = "TSP_Data/TSP_264.txt", data_318 = "TSP_Data/TSP_318.txt",
            data_400 = "TSP_Data/TSP_400.txt", data_442 = "TSP_Data/TSP_442.txt",
            opt_data_442 = "TSP_Data/TSP_442_OPT.txt", data_493 = "TSP_Data/TSP_493.txt",
            data_574 = "TSP_Data/TSP_574.txt", none = "";

    public static void main(String[] args) {
        double [][] distances = TSP.ReadArrayFile(data_48, " ");
        System.out.println("Route = " + TSPProblem.RunTSP(100000, distances));
        System.out.println("Fitness = " + TSPProblem.finalFit);

    }
}
