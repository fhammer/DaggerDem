package net.play.club.daggertest.dependence;

import net.play.club.daggertest.dependence.entity.JanetMeizi;
import net.play.club.daggertest.dependence.entity.NanceMeizi;
import net.play.club.daggertest.dependence.entity.Person;

import dagger.Component;

/**
 * 项目名称：DaggerTest
 * 类描述：
 * 创建人：fuzh2
 * 创建时间：2016/10/14 15:34
 * 修改人：fuzh2
 * 修改时间：2016/10/14 15:34
 * 修改备注：
 */
@Component(modules = PersonModule.class)
public interface PersonComponent {

    @NanceMeizi
    Person getNanceMeizi();

    @JanetMeizi
    Person getJanetMeizi();
}
