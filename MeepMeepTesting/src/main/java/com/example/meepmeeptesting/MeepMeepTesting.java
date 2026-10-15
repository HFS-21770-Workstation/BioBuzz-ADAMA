package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
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
                                new Pose2d(0, 0, 0)
                        )
                        .lineToXLinearHeading(40, Math.PI / 2)
                        .lineToX(-40)
//                        .lineToXLinearHeading(40, Math.PI * 2)
//                        .lineToYLinearHeading(40, Math.PI * 2)
                        .build()
        );

        meepMeep.setBackground(
                        MeepMeep.Background.FIELD_DECODE_JUICE_DARK
                )
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}