package net.play.club.daggertest.modle.entity;

import javax.inject.Inject;

/**
 * 项目名称：DaggerTest
 * 类描述：
 * 创建人：fuzh2
 * 创建时间：2016/10/14 14:14
 * 修改人：fuzh2
 * 修改时间：2016/10/14 14:14
 * 修改备注：
 */
public class Pot {
    private Flower flower;

    @Inject
    public Pot(@LilyFlower Flower pFlower) {
        this.flower = pFlower;
    }

    public String show() {
        return this.flower.whisper();
    }
}
