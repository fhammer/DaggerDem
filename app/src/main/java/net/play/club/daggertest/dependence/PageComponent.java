package net.play.club.daggertest.dependence;

import net.play.club.daggertest.MainActivity;

import dagger.Component;

/**
 * 项目名称：DaggerTest
 * 类描述：
 * 创建人：fuzh2
 * 创建时间：2016/10/14 15:41
 * 修改人：fuzh2
 * 修改时间：2016/10/14 15:41
 * 修改备注：
 */

@Component(dependencies = MeiziComponent.class)
public interface PageComponent {
    void inject(MainActivity pActivity);
}
