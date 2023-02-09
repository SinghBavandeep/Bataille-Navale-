package Affichages;

public class Defeat {

    /**
     * La methode print permet d'afficher Défaite sur le terminal et de le faire clignoter.
     *
     * @throws InterruptedException InterruptedException
     */
    public void print() throws InterruptedException {
        ResetConsole.FullClear();
        // System.out.println("Tu as perdu face à l'ordinateur !");
        String DeafeatScreen = ("" +
                "        \"DDDDDDDDDDDDD                               ffffffffffffffff                    iiii          tttt                              \n" +
                "        \"D::::::::::::DDD                           f::::::::::::::::f                  i::::i      ttt:::t                              \n" +
                "        \"D:::::::::::::::DD                        f::::::::::::::::::f                  iiii       t:::::t                              \n" +
                "        \"DDD:::::DDDDD:::::D                       f::::::fffffff:::::f                             t:::::t                              \n" +
                "        \"  D:::::D    D:::::D     eeeeeeeeeeee     f:::::f       ffffffaaaaaaaaaaaaa   iiiiiiittttttt:::::ttttttt        eeeeeeeeeeee    \n" +
                "        \"  D:::::D     D:::::D  ee::::::::::::ee   f:::::f             a::::::::::::a  i:::::it:::::::::::::::::t      ee::::::::::::ee  \n" +
                "        \"  D:::::D     D:::::D e::::::eeeee:::::eef:::::::ffffff       aaaaaaaaa:::::a  i::::it:::::::::::::::::t     e::::::eeeee:::::ee\n" +
                "        \"  D:::::D     D:::::De::::::e     e:::::ef::::::::::::f                a::::a  i::::itttttt:::::::tttttt    e::::::e     e:::::e\n" +
                "        \"  D:::::D     D:::::De:::::::eeeee::::::ef::::::::::::f         aaaaaaa:::::a  i::::i      t:::::t          e:::::::eeeee::::::e\n" +
                "        \"  D:::::D     D:::::De:::::::::::::::::e f:::::::ffffff       aa::::::::::::a  i::::i      t:::::t          e:::::::::::::::::e \n" +
                "        \"  D:::::D     D:::::De::::::eeeeeeeeeee   f:::::f            a::::aaaa::::::a  i::::i      t:::::t          e::::::eeeeeeeeeee  \n" +
                "        \"  D:::::D    D:::::D e:::::::e            f:::::f           a::::a    a:::::a  i::::i      t:::::t    tttttte:::::::e           \n" +
                "        \"DDD:::::DDDDD:::::D  e::::::::e          f:::::::f          a::::a    a:::::a i::::::i     t::::::tttt:::::te::::::::e          \n" +
                "        \"D:::::::::::::::DD    e::::::::eeeeeeee  f:::::::f          a:::::aaaa::::::a i::::::i     tt::::::::::::::t e::::::::eeeeeeee  \n" +
                "        \"D::::::::::::DDD       ee:::::::::::::e  f:::::::f           a::::::::::aa:::ai::::::i       tt:::::::::::tt  ee:::::::::::::e  \n" +
                "        \"DDDDDDDDDDDDD            eeeeeeeeeeeeee  fffffffff            aaaaaaaaaa  aaaaiiiiiiii         ttttttttttt      eeeeeeeeeeeeee  \n");

        for (int i = 0; i < 60; i++) {
            System.out.println("\033[31m" + DeafeatScreen+"\033[30m");
            Thread.sleep(250);
            ResetConsole.FullClear();

            System.out.println(DeafeatScreen);
            Thread.sleep(250);
            ResetConsole.FullClear();


        }
    }
}