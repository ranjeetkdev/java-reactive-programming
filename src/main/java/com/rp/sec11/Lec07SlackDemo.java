package com.rp.sec11;

import com.rp.courseUtil.Util;
import com.rp.sec11.assignment.SlackMember;
import com.rp.sec11.assignment.SlackMessage;
import com.rp.sec11.assignment.SlackRoom;

public class Lec07SlackDemo {

    public static void main(String[] args) {

        SlackRoom slackRoom = new SlackRoom("Reactor");
        SlackMember ranjeet = new SlackMember("Ranjeet");
        SlackMember supriya = new SlackMember("Supriya");
        SlackMember vaishnavi = new SlackMember("Vaishnavi");

        slackRoom.joinRoom(ranjeet);
        slackRoom.joinRoom(supriya);

        ranjeet.say("Hi all..");
        Util.sleepSeconds(4);

        supriya.say("Hey !");
        ranjeet.say("I simply wanted to say hi");
        Util.sleepSeconds(4);

        slackRoom.joinRoom(vaishnavi);
        vaishnavi.say("Hey guys.. glad to be here");


    }
}
