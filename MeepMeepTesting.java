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
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-35, 59, Math.toRadians(270)))
                        .splineToLinearHeading(new Pose2d(-35,12, Math.toRadians(270)), Math.toRadians(270))
                        .strafeTo(new Vector2d(-48,12))
                        .setReversed(true)
                        .splineToLinearHeading(new Pose2d(-48,50, Math.toRadians(270)), Math.toRadians(270))
                        .setReversed(false)
                        .splineToLinearHeading(new Pose2d(-48,12, Math.toRadians(270)), Math.toRadians(270))
                        .strafeTo(new Vector2d(-54,12))
                        .setReversed(true)
                        .splineToLinearHeading(new Pose2d(-54,50, Math.toRadians(270)), Math.toRadians(270))
                        .setReversed(false)
                         .splineToLinearHeading(new Pose2d(-54,12, Math.toRadians(270)), Math.toRadians(270))
                       .strafeTo(new Vector2d(-61.5,12))
                         .setReversed(true)
                        .splineToLinearHeading(new Pose2d(-61.5,50, Math.toRadians(270)), Math.toRadians(270))
                        .splineToConstantHeading(new Vector2d(0,34), Math.toRadians(270))
                        .waitSeconds(1)
                        .setReversed(true)
                        .splineTo(new Vector2d(55,56), Math.toRadians(40))
                        .waitSeconds(1)
                        .setReversed(false)
                        .splineTo(new Vector2d(0,34), Math.toRadians(270))
                        .waitSeconds(1)
                        .setReversed(true)
                        .splineTo(new Vector2d(55,56), Math.toRadians(40))
                        .waitSeconds(1)
                        .setReversed(false)
                        .splineTo(new Vector2d(0,56), Math.toRadians(180))
                          .splineTo(new Vector2d(-50,56), Math.toRadians(180))



                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}