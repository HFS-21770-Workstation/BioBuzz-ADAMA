package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                .setConstraints(
                        60, 60,
                        Math.toRadians(180),
                        Math.toRadians(180),
                        15
                )
                .build();

        myBot.runAction(
                myBot.getDrive().actionBuilder(
                                new Pose2d(61, -16, Math.toRadians(180))
                        )
                        .waitSeconds(2)
                        .strafeTo(new Vector2d(57,-54))
                        .waitSeconds(0.5)
                        .strafeTo(new Vector2d(-34,-54))
                        .splineTo(new Vector2d(-51,-16), Math.toRadians(0))
                        .waitSeconds(2)
                        .splineTo(new Vector2d(-34,-57), Math.toRadians(180))

                        .build()
        );

        meepMeep.setBackground(
                        MeepMeep.Background.FIELD_BIOBUZZ_JUICE_DARK
                )
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}