package com.epam.rd.autotasks;
import static com.epam.rd.autotasks.DecrementingCarousel.array;

public class HalvingCarousel extends DecrementingCarousel {


    public HalvingCarousel(final int capacity) {
        super(capacity);
    }
    public HalvingRun run() {
        if (isRunning) return null;
        isRunning = true;
        return new HalvingRun(this);
    }
}

class HalvingRun extends CarouselRun {
    boolean isRunning = false;
    int position = 0;

    public HalvingRun(HalvingCarousel halvingRun) {

        super(halvingRun);
    }


    @Override
    public int next() {
        int temp;
        if(isFinished()) {
            return -1;
        }
        else {
            while (array[position %= array.length] <= 0) {
                position++;
            }
        }
        temp = array[position];
        array[position++]/=2;
        return temp;
    }
        @Override
        public boolean isFinished() {
            for (int var : array) {
                if (var > 0) return false;
            }
            return true;
        }
    }





