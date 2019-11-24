package com.addison.libjoketelling;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokeTelling {
    private List<String> mJokes;

    public JokeTelling() {
        mJokes = new ArrayList<>();
        mJokes.add("A user interface is like a joke. If you have to explain it, it's not that good.");
        mJokes.add("So, where did you two meet? Windows users: At the Office; Mac users: At Starbucks; Linux users: GitHub.");
        mJokes.add("Siri, who is your boyfriend? I'll leave the relations to the databases.");
    }

    public String getAJoke() {
        Random random = new Random();
        int pos = random.nextInt(mJokes.size());
        return mJokes.get(pos);
    }
}
