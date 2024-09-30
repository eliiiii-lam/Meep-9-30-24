package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class Meep_BlueRight {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(38, 59, Math.toRadians(270)))
                .splineToConstantHeading(new Vector2d(48,40), Math.toRadians(270))
                .waitSeconds(1)
                .splineToLinearHeading(new Pose2d(53,53,Math.toRadians(220)),Math.toRadians(230))
                .waitSeconds(1)
                .turn(Math.toRadians(60))
                .waitSeconds(1)
                .turn(Math.toRadians(-60))
                .waitSeconds(1)
                .turn(Math.toRadians(85))
                .waitSeconds(1)
                .turn(Math.toRadians(-85))
                .waitSeconds(1)
                .splineTo(new Vector2d(26,0),Math.toRadians(180))
                .waitSeconds(1)
                .setReversed(true)
                .splineTo(new Vector2d(53,53), Math.toRadians(40))
                .waitSeconds(1)
                .setReversed(false)
                .splineTo(new Vector2d(26, 0), Math.toRadians(180))
                .waitSeconds(1)
                .setReversed(true)
                .splineTo(new Vector2d(53,53), Math.toRadians(40))
                .splineToLinearHeading(new Pose2d(20,54, Math.toRadians(180)), Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(-50,60, Math.toRadians(180)), Math.toRadians(180))


                /* .lineToXSplineHeading(38, Math.toRadians(270))
                 .splineToConstantHeading(new Vector2d(53,53), Math.toRadians(270))
                 .turn(Math.toRadians(-50))
                         */



                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}