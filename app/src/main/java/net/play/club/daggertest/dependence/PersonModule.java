package net.play.club.daggertest.dependence;

import net.play.club.daggertest.dependence.entity.Janet;
import net.play.club.daggertest.dependence.entity.JanetMeizi;
import net.play.club.daggertest.dependence.entity.Nance;
import net.play.club.daggertest.dependence.entity.NanceMeizi;
import net.play.club.daggertest.dependence.entity.Person;

import dagger.Module;
import dagger.Provides;

/**
 * 项目名称：DaggerTest
 * 类描述：
 * 创建人：fuzh2
 * 创建时间：2016/10/14 15:31
 * 修改人：fuzh2
 * 修改时间：2016/10/14 15:31
 * 修改备注：
 */

@Module
public class PersonModule {

    @Provides
    @NanceMeizi
    Person provideNance() {
        return new Nance();
    }

    @Provides
    @JanetMeizi
    Person provideJanet() {
        return new Janet();
    }
}
