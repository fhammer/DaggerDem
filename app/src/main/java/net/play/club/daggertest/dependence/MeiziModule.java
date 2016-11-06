package net.play.club.daggertest.dependence;

import net.play.club.daggertest.dependence.entity.JanetMeizi;
import net.play.club.daggertest.dependence.entity.MeiZi;
import net.play.club.daggertest.dependence.entity.NanceMeizi;
import net.play.club.daggertest.dependence.entity.Person;

import dagger.Module;
import dagger.Provides;

/**
 * 项目名称：DaggerTest
 * 类描述：
 * 创建人：fuzh2
 * 创建时间：2016/10/14 15:38
 * 修改人：fuzh2
 * 修改时间：2016/10/14 15:38
 * 修改备注：
 */
@Module
public class MeiziModule {

    @Provides
    MeiZi provideMeizi(@NanceMeizi Person meizi) {
        return new MeiZi(meizi);
    }
}
