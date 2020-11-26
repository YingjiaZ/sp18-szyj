package synthesizer;

import edu.princeton.cs.introcs.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    public static void main(String[] args) {

        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

        synthesizer.GuitarString[] strings = new synthesizer.GuitarString[37];
        for (int i = 0; i < 37; i += 1) {
            strings[i] = new GuitarString(440.0 * Math.pow(2.0, (i - 12.0) / 12.0));
        }

        synthesizer.GuitarString string = strings[0];

        while (true) {

            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index != -1) {
                    string = strings[index];
                    string.pluck();
                }
            }

            StdAudio.play(string.sample());

            string.tic();
        }
    }
}
