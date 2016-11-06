package net.play.club.daggertest.dependence.entity;

/**
 * 项目名称：DaggerTest
 * 类描述：
 * 创建人：fuzh2
 * 创建时间：2016/10/14 15:36
 * 修改人：fuzh2
 * 修改时间：2016/10/14 15:36
 * 修改备注：
 */
public class MeiZi {

    private Person meizi;

    public MeiZi(Person p) {
        this.meizi = p;
    }

    public String show() {
        return meizi.whisper();
    }
}
