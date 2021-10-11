package com.opstty;

import com.opstty.job.WordCount;
import com.opstty.job.Districts;
import com.opstty.job.Species;
import com.opstty.job.NbTreesByKinds;
import com.opstty.job.MaxHeightPerKind;
import com.opstty.job.SortHeight;
import com.opstty.job.OldestTreeDistrict;
/*import com.opstty.job.MostTreesDistrict;*/


import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");

            programDriver.addClass("DistinctDistricts", Districts.class,
                    "Exo 1.8.1 : A map/reduce program that displays distinctly the districts containing trees in the input file.");

            programDriver.addClass("Species", Species.class,
                    "Exo 1.8.2 : A map/reduce program that displays the list of different species trees in the input file.");

            programDriver.addClass("NbTreesByKinds", NbTreesByKinds.class,
                    "Exo 1.8.3 : A map/reduce program that calculates the number of trees of each kinds (column:Genre) in the input file.");

            programDriver.addClass("MaxHeightPerKind", MaxHeightPerKind.class,
                    "Exo 1.8.4 : A map/reduce program that calculates the height of the tallest tree of each kind in the input file.");

            programDriver.addClass("SortHeight", SortHeight.class,
                    "Exo 1.8.5 : A map/reduce program that sort the trees height from smallest to largest.");

            programDriver.addClass("OldestTreeDistrict", OldestTreeDistrict.class,
                    "Exo 1.8.6 : A map/reduce program that displays the district where the oldest tree is.");

            /*programDriver.addClass("MostTreesDistrict", MostTreesDistrict.class,
                    "Exo 1.8.7 : A map/reduce program that displays the district that contains the most trees.");

             */

            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
