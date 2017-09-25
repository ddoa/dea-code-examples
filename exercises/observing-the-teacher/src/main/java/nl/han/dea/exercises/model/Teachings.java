package nl.han.dea.exercises.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Teachings {

    private List<String> teachings = new ArrayList<String>();

    /**
     * Private constructor to prevent instantiation.
     */
    private Teachings() {
        teachings.add("There are 10 types of people in the world: those who understand binary, and those who don’t.");
        teachings.add("If at first you don’t succeed; call it version 1.0");
        teachings.add("I’m not anti-social; I’m just not user friendly.");
        teachings.add("I would love to change the world, but they won’t give me the source code");
        teachings.add("Programming today is a race between software engineers striving to build bigger and better idiot-proof programs, and the Universe trying to produce bigger and better idiots. So far, the Universe is winning.");
        teachings.add("A computer lets you make more mistakes faster than any invention in human history – with the possible exceptions of handguns and tequila.");
        teachings.add("My software never has bugs. It just develops random features.");
        teachings.add("The box said ‘Requires Windows 95 or better’. So I installed LINUX.");
    }

    public static Teachings getInstance() {
        return new Teachings();
    }

    public String getWisdom() {
        String wisdowm = teachings.get((new Random()).nextInt(teachings.size()));
        return wisdowm;
    }
}
