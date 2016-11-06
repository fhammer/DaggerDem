package net.play.club.daggertest.modle;

import dagger.Component;

/**
 * 项目名称：DaggerTest
 * 类描述：
 * 创建人：fuzh2
 * 创建时间：2016/10/14 14:21
 * 修改人：fuzh2
 * 修改时间：2016/10/14 14:21
 * 修改备注：
 */

@Component(modules = FlowerModule.class)
public interface MainComponent {
    //    void inject(MainActivity pActivity);
}
