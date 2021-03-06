package net.play.club.daggertest.inject;

import javax.inject.Inject;

/**
 * 项目名称：DaggerTest
 * 类描述：
 * 创建人：fuzh2
 * 创建时间：2016/10/14 10:20
 * 修改人：fuzh2
 * 修改时间：2016/10/14 10:20
 * 修改备注：
 */
public class PotInject {

    private RoseInject rose;

    @Inject
    public PotInject(RoseInject rose) {
        this.rose = rose;
    }

    public String show() {
        return rose.whisper();
    }
}
