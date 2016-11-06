package net.play.club.daggertest.dependence;

import net.play.club.daggertest.dependence.entity.MeiZi;

import dagger.Component;

/**
 * 项目名称：DaggerTest
 * 类描述：
 * 创建人：fuzh2
 * 创建时间：2016/10/14 15:39
 * 修改人：fuzh2
 * 修改时间：2016/10/14 15:39
 * 修改备注：
 */

@Component(modules = MeiziModule.class,dependencies = PersonComponent.class)
public interface MeiziComponent {
    MeiZi getMeizi();
}
