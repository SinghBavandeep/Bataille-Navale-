package Affichages;

import java.util.Random;

/**
 * Création de la classe Victory
 */

public class Victory {

    /**
     * La methode print permet d'afficher Victoire sur le terminal et de le faire clignoter.
     * @throws InterruptedException InterruptedException
     */
    public void print () throws InterruptedException {
        ResetConsole.FullClear();
       // System.out.println("VICTOIRE, BRAVO A TOI !");
        String VictoryScreen = ("VVVVVVVV           VVVVVVVV iiii                               tttt                             iiii                                              \n" +
                                "V::::::V           V::::::Vi::::i                           ttt:::t                            i::::i                                             \n" +
                                "V::::::V           V::::::V iiii                            t:::::t                             iiii                                              \n" +
                                "V::::::V           V::::::V                                 t:::::t                                                                               \n" +
                                " V:::::V           V:::::Viiiiiii     ccccccccccccccccttttttt:::::ttttttt       ooooooooooo   iiiiiiirrrrr   rrrrrrrrr       eeeeeeeeeeee         \n" +
                                "  V:::::V         V:::::V i:::::i   cc:::::::::::::::ct:::::::::::::::::t     oo:::::::::::oo i:::::ir::::rrr:::::::::r    ee::::::::::::ee       \n" +
                                "   V:::::V       V:::::V   i::::i  c:::::::::::::::::ct:::::::::::::::::t    o:::::::::::::::o i::::ir:::::::::::::::::r  e::::::eeeee:::::ee     \n" +
                                "    V:::::V     V:::::V    i::::i c:::::::cccccc:::::ctttttt:::::::tttttt    o:::::ooooo:::::o i::::irr::::::rrrrr::::::re::::::e     e:::::e     \n" +
                                "     V:::::V   V:::::V     i::::i c::::::c     ccccccc      t:::::t          o::::o     o::::o i::::i r:::::r     r:::::re:::::::eeeee::::::e     \n" +
                                "      V:::::V V:::::V      i::::i c:::::c                   t:::::t          o::::o     o::::o i::::i r:::::r     rrrrrrre:::::::::::::::::e      \n" +
                                "       V:::::V:::::V       i::::i c:::::c                   t:::::t          o::::o     o::::o i::::i r:::::r            e::::::eeeeeeeeeee       \n" +
                                "        V:::::::::V        i::::i c::::::c     ccccccc      t:::::t    tttttto::::o     o::::o i::::i r:::::r            e:::::::e                \n" +
                                "         V:::::::V        i::::::ic:::::::cccccc:::::c      t::::::tttt:::::to:::::ooooo:::::oi::::::ir:::::r            e::::::::e               \n" +
                                "          V:::::V         i::::::i c:::::::::::::::::c      tt::::::::::::::to:::::::::::::::oi::::::ir:::::r             e::::::::eeeeeeee       \n" +
                                "           V:::V          i::::::i  cc:::::::::::::::c        tt:::::::::::tt oo:::::::::::oo i::::::ir:::::r              ee:::::::::::::e       \n" +
                                "            VVV           iiiiiiii    cccccccccccccccc          ttttttttttt     ooooooooooo   iiiiiiiirrrrrrr                eeeeeeeeeeeeee       \n" +
                                "                                                                                                                                              \n");

        for (int i = 0 ;i<20;i++)
        {
            System.out.println("\033[32m"+ VictoryScreen+"\033[30m");
            Thread.sleep(250);
            ResetConsole.FullClear();

            System.out.println("\033[34m"+ VictoryScreen+"\033[30m");
            Thread.sleep(250);
            ResetConsole.FullClear();

            System.out.println("\033[31m"+ VictoryScreen+"\033[30m");
            Thread.sleep(250);
            ResetConsole.FullClear();

            System.out.println("\033[33m"+ VictoryScreen+"\033[30m");
            Thread.sleep(250);
            ResetConsole.FullClear();

            System.out.println("\033[36m"+ VictoryScreen+"\033[30m");
            Thread.sleep(250);
            ResetConsole.FullClear();

            System.out.println("\033[35m"+ VictoryScreen+"\033[30m");
            Thread.sleep(250);
            ResetConsole.FullClear();
        }
        }
}
